package com.hmtmcse.console.table.test;

import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableRowData;

public class BasicTable {

    public static void main(String[] args) {


        Table table = new Table();
        table.addHeader("Name", TableConstant.RIGHT_ALIGN, TableConstant.BLUE);
        table.addHeader("Designation", TableConstant.LEFT_ALIGN, TableConstant.RED);
        table.addHeader("Team", TableConstant.CENTER_ALIGN, TableConstant.YALLOW);
        TableRowData rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead", TableConstant.CENTER_ALIGN, TableConstant.YALLOW);
        rowData.add("System & Research");
        table.addRow(rowData);

        rowData = table.setRowData("Touhid Mia Touhid");
        rowData.add("Team Lead");
        rowData.add("System & Research Touhid");
        table.addRow(rowData);

        rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead System System System", TableConstant.CENTER_ALIGN, TableConstant.YALLOW);
        rowData.add("Touhid System & Research");
        table.addRow(rowData);

        rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead");
        rowData.add("System & Research");
//        rowData.add("System & Research");
        table.addRow(rowData);
        table.toTable();



//        consoleTable.toTable();
    }

}
