package com.hmtmcse.console.table.data;

import java.util.ArrayList;
import java.util.List;

public class TableRow extends TableHtmlAttr{


    public List<TableData> tableDataList;

    public TableRow() {
        tableDataList = new ArrayList<>();
    }

    public TableRow(List<TableData> tableDataList) {
        this.tableDataList = tableDataList;
    }

    public List<TableData> getTableDataList() {
        return this.tableDataList;
    }

    public void setTableDataList(List<TableData> tableDataList) {
        this.tableDataList = tableDataList;
    }

    public void addToTableData(TableData tableData) {
        this.tableDataList.add(tableData);
    }


}
