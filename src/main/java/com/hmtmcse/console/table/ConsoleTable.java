package com.hmtmcse.console.table;

import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableRow;
import com.hmtmcse.console.table.data.TableRowItem;
import com.hmtmcse.console.table.processor.TableFactory;

import java.util.ArrayList;
import java.util.List;

public class ConsoleTable {

    private Table table;
    private TableFactory tableFactory;

    public ConsoleTable(){
        table = new Table();
        tableFactory = new TableFactory();
    }

    public TableRowItem addRowItem(String item){
        return new TableRowItem().addItem(item);
    }


    public ConsoleTable addRow(TableRowItem rowItem){
        table.addRowItem(rowItem.getRowItems());
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
