package com.hmtmcse.console.table.test;

import com.hmtmcse.console.table.ConsoleTable;
import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableRowData;

public class BasicTable {

    public static void main(String[] args) {


        Table table = new Table();
        table.addHeader("Name", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Designation", TableConstant.LEFT_ALIGN, TableConstant.RED);
        table.addHeader("Team", TableConstant.LEFT_ALIGN, TableConstant.YALLOW);
        TableRowData rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead");
        rowData.add("System & Research");
        table.addRow(rowData);
        table.toTable();



        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("Name");
        consoleTable.addHeader("Designation");
        consoleTable.addHeader("Team");

        consoleTable.addRow(
          consoleTable.addRowItem("Touhid Mia")
                .addItem("Team Lead")
                .addItem("System & Research")
        );

//        consoleTable.toTable();
    }

}
