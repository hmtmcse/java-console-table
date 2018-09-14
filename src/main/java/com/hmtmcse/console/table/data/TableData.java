package com.hmtmcse.console.table.data;

import com.hmtmcse.console.table.common.TableConstant;

public class TableData extends TableHtmlAttr {

    public String data;
    public String textColor = null;
    public String align = TableConstant.LEFT_ALIGN;
    public Integer colSpan = 0;
    public Integer characterLength = 0;
    public Boolean isPrinted = false;

    public TableData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void addData(String data) {
        this.data = data;
    }

    public String getTextColor() {
        return textColor;
    }

    public TableData setTextColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public String getAlign() {
        return align;
    }

    public TableData setAlign(String align) {
        this.align = align;
        return this;
    }

    public Integer getColSpan() {
        return colSpan;
    }

    public TableData setColSpan(Integer colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    public Integer getCharacterLength() {
        return characterLength;
    }

    public void setCharacterLength(Integer characterLength) {
        this.characterLength = characterLength;
    }

    public Boolean getPrinted() {
        return isPrinted;
    }

    public void setPrinted(Boolean printed) {
        isPrinted = printed;
    }

    public static TableData instance(String data){
        return new TableData(data);
    }

}
