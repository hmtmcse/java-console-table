package com.hmtmcse.console.table.data;

import java.util.ArrayList;
import java.util.List;

public class TableRowItem {

    public List<TableRow> rowItems = new ArrayList<>();
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
}
