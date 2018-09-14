package com.hmtmcse.console.table.test;

import com.hmtmcse.console.table.ConsoleTable;

public class BasicTable {

    public static void main(String[] args) {
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("Name");
        consoleTable.addHeader("Designation");
        consoleTable.addHeader("Team");
    }

}
