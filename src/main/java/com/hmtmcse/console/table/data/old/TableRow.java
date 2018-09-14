package com.hmtmcse.console.table.data.old;

import com.hmtmcse.console.table.common.TableConstant;

public class TableRow {

    public String name;
    public String align = TableConstant.CENTER_ALIGN;
    public Integer colSpan = 0;
    public String textColor;
    public String type = TableConstant.TABLE_ROW;
    public Integer characterLength = 0;


    public TableRow(String name) {
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

    public Integer getCharacterLength() {
        return characterLength;
    }

    public void setCharacterLength(Integer characterLength) {
        this.characterLength = characterLength;
    }
}
