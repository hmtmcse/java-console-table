package com.hmtmcse.console.table.test;

import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableRowData;

public class ConsoleTable {


    public static void withHeader(){
        Table table = new Table();
        table.addHeader("Name", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Designation", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Team", TableConstant.LEFT_ALIGN, TableConstant.BLUE);

        TableRowData rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead");
        rowData.add("System & Research");
        table.addRow(rowData);

        rowData = table.setRowData("Torikul");
        rowData.add("Automation Tester");
        rowData.add("System & Research");
        table.addRow(rowData);

        rowData = table.setRowData("Adeeb");
        rowData.add("Quality Assurance");
        rowData.add("WebCommander");
        table.addRow(rowData);

        table.toTablePrint();
    }


    public static void randomRow(){
        Table table = new Table();
        TableRowData rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead");
        rowData.add("System & Research");
        rowData.add("Dhaka Bangladesh");
        table.addRow(rowData);

        rowData = table.setRowData("Torikul");
        rowData.add("Automation Tester");
        rowData.add("System & Research");
        rowData.add("Dhaka Bangladesh");
        rowData.add("From Khulna");
        table.addRow(rowData);

        rowData = table.setRowData("Adeeb");
        rowData.add("Quality Assurance");
        rowData.add("WebCommander");
        table.addRow(rowData);

        table.toTablePrint();
    }

    public static void colorfulAndAlign(){
        Table table = new Table();
        TableRowData rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead", TableConstant.CENTER_ALIGN, TableConstant.RED);
        rowData.add("System & Research, WebCommander");
        rowData.add("Dhaka Bangladesh");
        table.addRow(rowData);

        rowData = table.setRowData();
        rowData.add("Torikul", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("Automation Tester", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("System & Research", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("Dhaka Bangladesh", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("From Khulna", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        table.addRow(rowData);

        rowData = table.setRowData("Adeeb");
        rowData.add("Quality Assurance");
        rowData.add("WebCommander");
        table.addRow(rowData);

        table.toTablePrint();
    }


    public static void rowMarge(){
        Table table = new Table();
        TableRowData rowData = table.setRowData();
        rowData.add("Team and Member Details", TableConstant.CENTER_ALIGN, TableConstant.RED, 10);
        table.addRow(rowData);

        rowData = table.setRowData("Touhid Mia");
        rowData.add("Team Lead", TableConstant.CENTER_ALIGN, TableConstant.RED);
        rowData.add("System & Research, WebCommander");
        rowData.add("Dhaka Bangladesh");
        table.addRow(rowData);

        rowData = table.setRowData();
        rowData.add("Torikul", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("Automation Tester", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("System & Research", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("Dhaka Bangladesh", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        rowData.add("From Khulna", TableConstant.RIGHT_ALIGN, TableConstant.YALLOW);
        table.addRow(rowData);

        rowData = table.setRowData("Adeeb");
        rowData.add("Quality Assurance");
        rowData.add("WebCommander", TableConstant.CENTER_ALIGN, TableConstant.RED, 2);
        table.addRow(rowData);

        rowData = table.setRowData();
        rowData.add("Software Development");
        rowData.add("Organization", TableConstant.CENTER_ALIGN, TableConstant.RED, 2);
        rowData.add("Since 2008");
        rowData.add("");
        table.addRow(rowData);

        rowData = table.setRowData();
        rowData.add("Mohakhali Dhaka", TableConstant.CENTER_ALIGN, TableConstant.RED, 2);
        rowData.add("Bangladesh", TableConstant.CENTER_ALIGN, TableConstant.RED);
        table.addRow(rowData);

        table.toTablePrint();
    }


    public static void main(String[] args) {

        System.out.println("Team Member Details.");
        withHeader();
        System.out.println();

        System.out.println("Random Data");
        randomRow();
        System.out.println();

        System.out.println("Colorful And Alignment");
        colorfulAndAlign();
        System.out.println();


        System.out.println("Column Span");
        rowMarge();
        System.out.println();


    }

}
