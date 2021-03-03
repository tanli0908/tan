package com.tan.tools.test;

/**
 * @ClassName ItemVO
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-12-02
 * @Since 1.0
 */
public class ItemVO {

    Integer itemCode;

    String itemName;

    public ItemVO(Integer itemCode, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
