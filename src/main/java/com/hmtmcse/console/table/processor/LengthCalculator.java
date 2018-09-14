package com.hmtmcse.console.table.processor;

import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LengthCalculator {

    private Table table;
    private Map<Integer, Integer> rowCharacterMaxWidth = new HashMap<>();

    public LengthCalculator(Table table){
        this.table = table;
    }


    public Table calculateColumn(Table table){
        if (table.getTableHeaders().size() != 0){
            table.setColumn(table.getTableHeaders().size());
        }else if (table.getTableRows().size() != 0){
            table.setColumn(table.getTableRows().size());
        }
        return table;
    }


    public Table calculateColumnWidth(Table table){
        rowCharacterMaxWidth = new HashMap<>();
        Integer index = 0;
        for (TableRow tableRow: table.getTableHeaders()){
            tableRow.characterLength = (tableRow.name != null ? tableRow.name.length() : 0);
            rowCharacterMaxWidth.put(index, tableRow.characterLength);
            table.tableHeaders.set(index, tableRow);
            index++;
        }

        Integer tmp;
        index = 0;
        for (TableRow tableRow: table.getTableRows()){
            tableRow.characterLength = (tableRow.name != null ? tableRow.name.length() : 0);
            if (rowCharacterMaxWidth.get(index) != null){
                tmp = rowCharacterMaxWidth.get(index);
                if (tmp < tableRow.characterLength){
                    rowCharacterMaxWidth.put(index, tableRow.characterLength);
                }
            }else{
                rowCharacterMaxWidth.put(index, tableRow.characterLength);
            }
            table.tableHeaders.set(index, tableRow);
            index++;
        }

        table.columnWidth = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : rowCharacterMaxWidth.entrySet())
        {
            table.setColumnWidthItem(entry.getValue());
        }

        return table;
    }



    public Table calculate(){
        table = calculateColumn(table);
        table = calculateColumnWidth(table);
        return table;
    }

}
