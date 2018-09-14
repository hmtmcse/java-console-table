package com.hmtmcse.console.table.processor;

import com.hmtmcse.console.table.data.Table;

public class TableFactory {

    private LengthCalculator lengthCalculator;

    public TableFactory(){

    }

    public void process(Table table){
        lengthCalculator = new LengthCalculator(table);
        table = lengthCalculator.calculate();
        System.out.print("");
    }


    public void toTable(Table table){
        process(table);
    }


}
