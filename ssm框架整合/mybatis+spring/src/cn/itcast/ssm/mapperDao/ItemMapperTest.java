package cn.itcast.ssm.mapperDao;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.List;

public class ItemMapperTest {

    private ApplicationContext applicationContext;
    private ItemsMapper itemsMapper;

    //在setUp这个方法的得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
        itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
    }

    //根据主键查询
    @Test
    public void testDeleteByPrimaryKey() {
        Items items=itemsMapper.selectByPrimaryKey(1);
        System.out.println(items);
    }

    //自定义条件查询
    @Test
    public void testSelectByExample(){
        ItemsExample itemsExample=new ItemsExample();
        ItemsExample.Criteria criteria=itemsExample.createCriteria();
        criteria.andNameEqualTo("笔记本");
        //可能返回多条记录
        List<Items> list=itemsMapper.selectByExample(itemsExample);
        System.out.println(list);
    }

    //插入
    @Test
    public void testInsert() {
        Items items=new Items();
        items.setName("手机");
        items.setPrice(999f);
        Date date = new Date(1990-10-01);
        items.setCreatetime(date);
        itemsMapper.insert(items);
    }

    //跟新数据
    @Test
    public void testUpdateByPrimaryKey(){
        //对所有字段进行跟新
        Items items=itemsMapper.selectByPrimaryKey(1);
        items.setName("水杯");
        itemsMapper.updateByPrimaryKey(items);
        //如果传入字段不空才跟新,在批量跟新中使用此方法，不需要先查询再跟新
        //itemsMapper.updateByExample();
    }
}
