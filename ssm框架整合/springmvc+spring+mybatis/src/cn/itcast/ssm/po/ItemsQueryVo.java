package cn.itcast.ssm.po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: ItemsQueryVo</p>
 * <p>Description:商品包装对象 </p>
 * <p>Company: www.itcast.com</p>
 *
 * @version 1.0
 * @author 传智.燕青
 * @date 2015-4-13下午3:22:36
 */
public class ItemsQueryVo {

    //商品信息
    private Items items;

    //为了系统 可扩展性，对原始生成的po进行扩展
    private ItemsCustom itemsCustom;

    //批量商品信息
    private List<ItemsCustom> itemsList;

    private Map<String, Object> itemInfo = new HashMap<String, Object>();

    //用户信息
    //private UserCustom userCustom;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

    public Map<String, Object> getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(Map<String, Object> itemInfo) {
        this.itemInfo = itemInfo;
    }
}
