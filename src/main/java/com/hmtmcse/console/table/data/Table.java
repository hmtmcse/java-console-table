package com.hmtmcse.console.table.data;

import java.util.ArrayList;
import java.util.List;

public class Table {

    public List<TableRow> tableHeaders = new ArrayList<>();
    public List<List<TableRow>> tableRows = new ArrayList<>();
    public Integer column = 0;
    public List<Integer> columnWidth = new ArrayList<>();


    public void addHeader(TableRow row){
        tableHeaders.add(row);
    }

    public List<TableRow> getTableHeaders() {
        return tableHeaders;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public List<Integer> getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidthItem(Integer item) {
        columnWidth.add(item);
    }

    public List<List<TableRow>> getTableRows() {
        return tableRows;
    }

    public void addRowItem(List<TableRow> rowItem) {
        this.tableRows.add(rowItem);
    }
}
