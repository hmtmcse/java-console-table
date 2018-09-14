package com.hmtmcse.console.table.processor;

import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.CellSpacing;
import com.hmtmcse.console.table.data.old.Table;
import com.hmtmcse.console.table.data.old.TableRow;
import com.hmtmcse.console.table.data.old.TableRowItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LengthCalculator {


    private Map<Integer, Integer> rowCharacterMaxWidth = new HashMap<>();


    public Table calculateColumn(Table table){
        if (table.getTableHeaders().size() != 0){
            table.setColumn(table.getTableHeaders().size());
        }else if (table.getTableRows().size() != 0){
            table.setColumn(table.getTableRows().size());
        }
        return table;
    }

    public CellSpacing calculateCellSpace(Integer maxColLength, String data, String align){
        Integer length = (maxColLength - data.length());
        CellSpacing cellSpacing = new CellSpacing();
        switch (align){
            case TableConstant.LEFT_ALIGN:
                cellSpacing.end += length;
                break;
            case TableConstant.RIGHT_ALIGN:
                cellSpacing.start += length;
                break;
            case TableConstant.CENTER_ALIGN:
                cellSpacing.start += (int) Math.ceil((double) length / 2);
                cellSpacing.end += (int) Math.floor((double) length / 2);
                break;
        }
        return cellSpacing;
    }

    public Integer colSpanCalculator(Integer rowIndex, List<Integer> columnWidth, Integer span) {
        Integer loop = rowIndex + span;
        if (loop > columnWidth.size()) {
            loop = rowIndex - columnWidth.size();
        }
        Integer length = 0;
        for (int i = 0; i < loop; i++) {
            length += columnWidth.get(rowIndex);
            rowIndex++;
        }
        return length;
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

        Integer tmp, rowItems = 0;
        for (TableRowItem tableRowItem : table.getTableRows()){
            index = 0;
            for (TableRow tableRow: tableRowItem.getRowItems()){
                tableRow.characterLength = (tableRow.name != null ? tableRow.name.length() : 0);
                if (rowCharacterMaxWidth.get(index) != null){
                    tmp = rowCharacterMaxWidth.get(index);
                    if (tmp < tableRow.characterLength){
                        rowCharacterMaxWidth.put(index, tableRow.characterLength);
                    }
                }else{
                    rowCharacterMaxWidth.put(index, tableRow.characterLength);
                }
                tableRowItem.rowItems.set(index, tableRow);
                index++;
            }
            table.getTableRows().set(rowItems, tableRowItem);
            rowItems++;
        }

        table.columnWidth = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : rowCharacterMaxWidth.entrySet())
        {
            table.setColumnWidthItem(entry.getValue());
        }

        return table;
    }



    public Table calculate(Table table){
        table = calculateColumn(table);
        table = calculateColumnWidth(table);
        return table;
    }

}
