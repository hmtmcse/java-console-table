package com.hmtmcse.console.table.processor;

import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.CellSpacing;
import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableData;
import com.hmtmcse.console.table.data.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {



    public Table column(Table table) {
        Map<Integer, Integer> columnCharacterMaxWidth = new HashMap<>();
        Integer index = 0;
        for (TableData tableData : table.headerDefinition.getTableDataList()) {
            tableData.characterLength = (tableData.data != null ? tableData.data.length() : 0);
            columnCharacterMaxWidth.put(index, tableData.characterLength);
            table.headerDefinition.getTableDataList().set(index, tableData);
            index++;
        }


        Integer tmp, rowItems = 0;
        for (TableRow tableRow : table.getRows()) {
            index = 0;
            for (TableData tableData : tableRow.getTableDataList()) {
                tableData.characterLength = (tableData.data != null ? tableData.data.length() : 0);
                if (columnCharacterMaxWidth.get(index) != null) {
                    tmp = columnCharacterMaxWidth.get(index);
                    if (tmp < tableData.characterLength) {
                        columnCharacterMaxWidth.put(index, tableData.characterLength);
                    }
                } else {
                    columnCharacterMaxWidth.put(index, tableData.characterLength);
                }
                tableRow.tableDataList.set(index, tableData);
                index++;
            }
            table.getRows().set(rowItems, tableRow);
            rowItems++;
        }


        table.columnWidth = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : columnCharacterMaxWidth.entrySet()) {
            table.setColumnWidthItem(entry.getValue());
        }
        table.column = table.columnWidth.size();
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
            span = columnWidth.size() - rowIndex;
        }
        Integer length = 0;
        for (int i = 0; i < span; i++) {
            length += columnWidth.get(rowIndex) + 3;
            rowIndex++;
        }
        length -= 3;
        return length;
    }

}
