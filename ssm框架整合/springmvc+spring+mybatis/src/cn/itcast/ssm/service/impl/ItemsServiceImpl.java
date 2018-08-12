package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        if (items == null) {
            throw new CustomException("修改的商品信息不存在");
        }


        //处理....
        ItemsCustom itemsCustom = null;
        //将items的属性值拷贝到itemsCustom中
        if (items != null) {
            itemsCustom = new ItemsCustom();
            BeanUtils.copyProperties(items, itemsCustom);
        }
        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        //添加业务校验，通常在service接口对关键参数进行校验
        //检验id是否为空，如果为空，抛出异常

        //更新商品信息,使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括大文本类型字段
        //updateByPrimaryKeyWithBLOBs要求必须传入id
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
