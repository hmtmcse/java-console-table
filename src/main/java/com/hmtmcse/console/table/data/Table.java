package com.hmtmcse.console.table.data;

import java.util.ArrayList;
import java.util.List;

public class Table {

    public List<TableRow> tableHeaders = new ArrayList<>();
    public List<TableRow> tableRows = new ArrayList<>();
    public Integer column = 0;
    public List<Integer> columnWidth = new ArrayList<>();


    public void addHeader(TableRow row){
        tableHeaders.add(row);
    }

    public void addRow(TableRow tableRow){
        tableRows.add(tableRow);
    }

    public List<TableRow> getTableHeaders() {
        return tableHeaders;
    }

    public List<TableRow> getTableRows() {
        return tableRows;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }



    public void setTableRows(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }

    public List<Integer> getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidthItem(Integer item) {
        columnWidth.add(item);
    }
}
