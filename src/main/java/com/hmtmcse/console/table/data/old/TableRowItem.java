package com.hmtmcse.console.table.data.old;

import java.util.ArrayList;
import java.util.List;

public class TableRowItem {

    public List<TableRow> rowItems = new ArrayList<>();
    public String rowString = "";

    public TableRowItem() {
        rowItems = new ArrayList<>();
    }

    public TableRowItem addItem(String item){
        rowItems.add(new TableRow(item));
        return this;
    }

    public List<TableRow> getRowItems() {
        return rowItems;
    }

    public void setRowItems(List<TableRow> rowItems) {
        this.rowItems = rowItems;
    }

    public String getRowString() {
        return rowString;
    }

    public void setRowString(String rowString) {
        this.rowString = rowString;
    }
}
