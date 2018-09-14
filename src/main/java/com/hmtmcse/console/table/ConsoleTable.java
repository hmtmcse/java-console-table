package com.hmtmcse.console.table;

import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableRow;
import com.hmtmcse.console.table.processor.TableFactory;

public class ConsoleTable {

    private Table table;
    private TableFactory tableFactory;

    public ConsoleTable(){
        table = new Table();
        tableFactory = new TableFactory();
    }

    public ConsoleTable addRow(String name){
        return this;
    }

    public ConsoleTable addHeader(String name){
        table.addHeader(new TableRow(name));
        return this;
    }


    public ConsoleTable toTable(){
        tableFactory.toTable(table);
        return this;
    }

}
