package com.hmtmcse.console.table.data;


import com.hmtmcse.console.table.processor.TableFactory;
import java.util.ArrayList;
import java.util.List;

public class Table extends TableHtmlAttr {

    public TableHeaderDefinition headerDefinition;
    public List<TableRow> rows;
    public TableFactory tableFactory;
    public Integer column = 0;
    public List<Integer> columnWidth = new ArrayList<>();
    public String commonRowSeparator = "";

    public Table() {
        headerDefinition = new TableHeaderDefinition();
        rows = new ArrayList<>();
        tableFactory = new TableFactory();
    }

    public TableHeaderDefinition addHeader(String data) {
        return this.headerDefinition.add(data);
    }

    public TableHeaderDefinition addHeader(String data, String align) {
        return this.headerDefinition.add(data, align);
    }

    public TableHeaderDefinition addHeader(String data, String align, String textColor) {
        return this.headerDefinition.add(data, align, textColor);
    }

    public TableRowData setRowData(String data) {
        return new TableRowData().add(data);
    }

    public TableRowData setRowData() {
        return new TableRowData();
    }

    public TableRowData setRowData(String data, String align) {
        return new TableRowData().add(data, align);
    }

    public TableRowData setRowData(String data, String align, String textColor) {
        return new TableRowData().add(data, align, textColor);
    }

    public Table addRow(TableRowData rowData) {
        rows.add(rowData);
        return this;
    }

    public Table toTable(){
        tableFactory.toTable(this);
        return this;
    }

    public void setColumnWidthItem(Integer item) {
        columnWidth.add(item);
    }

    public List<TableRow> getRows() {
        return rows;
    }

    public List<Integer> getColumnWidth() {
        return columnWidth;
    }
}
