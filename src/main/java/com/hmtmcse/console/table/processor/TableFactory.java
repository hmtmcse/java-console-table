package com.hmtmcse.console.table.processor;


import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.CellSpacing;
import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableData;
import com.hmtmcse.console.table.data.old.TableRow;

import java.util.List;

public class TableFactory {

    private Calculator calculator;

    public TableFactory(){
        calculator = new Calculator();
    }


    public String getRowSeparatorLine(List<Integer> columns){
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer characters : columns){
            stringBuilder.append("+--");
            for (int i = 0; i < characters; i++){
                stringBuilder.append("-");
            }
        }
        stringBuilder.append("+");
        return stringBuilder.toString();
    }


    public String getSpace(Integer numberOfSpace) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < numberOfSpace; i++) {
            space.append(" ");
        }
        return space.toString();
    }


    public Table process(Table table){
        table = calculator.column(table);
        return table;
    }


    public String getTableRowToString(TableData tableData, List<Integer> columnWidth, Integer index) {
        calculator = new Calculator();
        if (tableData.colSpan != 0){
            calculator.colSpanCalculator(index, columnWidth, tableData.colSpan);
        }
        CellSpacing cellSpacing = calculator.calculateCellSpace(columnWidth.get(index), tableData.data, tableData.align);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getSpace(cellSpacing.start));
        if (tableData.textColor != null) {
            stringBuilder.append(String.format(tableData.textColor, tableData.data));
        } else {
            stringBuilder.append(tableData.data);
        }
        stringBuilder.append(getSpace(cellSpacing.end));
        return stringBuilder.toString();
    }



    public String consoleTableRowString(List<Integer> columnWidth,  List<TableData> tableDataList){
        String defaultRowSeparator = getRowSeparatorLine(columnWidth);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(defaultRowSeparator);
        stringBuilder.append(TableConstant.NEW_LINE);
        for (int i = 0; i < columnWidth.size(); i++){
            stringBuilder.append("|");
            stringBuilder.append(getTableRowToString(tableDataList.get(i), columnWidth, i));
        }
        stringBuilder.append("|");
        stringBuilder.append(TableConstant.NEW_LINE);
        stringBuilder.append(defaultRowSeparator);
        return stringBuilder.toString();
    }

    public String consoleTableHeader(Table table){
        return consoleTableRowString(table.getColumnWidth(), table.headerDefinition.getTableDataList());
    }

    public void consoleTable(Table table){

    }

    public void toTable(Table table){
        table = process(table);
        String header = consoleTableHeader(table);
        System.out.println(header);
    }

}
