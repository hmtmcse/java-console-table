package com.hmtmcse.console.table.data;

import com.hmtmcse.console.table.common.TableConstant;

public class TableColumn {

    public String name;
    public String align;
    public String textColor;
    public String type = TableConstant.TABLE_ROW;


    public TableColumn(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
