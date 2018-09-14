package com.hmtmcse.console.table.processor;


import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.CellSpacing;
import com.hmtmcse.console.table.data.Table;
import com.hmtmcse.console.table.data.TableData;
import com.hmtmcse.console.table.data.TableRow;

import java.util.List;

public class TableFactory {

    private Calculator calculator;

    public TableFactory(){
        calculator = new Calculator();
    }


    public String getRowSeparatorLine(List<Integer> columns){
        return getRowSeparatorLine(columns, "+", "-");
    }

    public String getRowSeparatorLine(List<Integer> columns, String corner, String middle){
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer characters : columns){
            stringBuilder.append(corner + middle + middle);
            for (int i = 0; i < characters; i++){
                stringBuilder.append(middle);
            }
        }
        stringBuilder.append(corner);
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
            stringBuilder.append(getTableRowToString(getTableData(tableDataList, i), columnWidth, i));
        }
        stringBuilder.append("|");
        stringBuilder.append(TableConstant.NEW_LINE);
        return stringBuilder.toString();
    }

    public TableData getTableData(List<TableData> tableDataList, Integer integer){
        try{
            return tableDataList.get(integer);
        }catch (Exception e){
            return new TableData("");
        }
    }


    public String consoleTableHeader(Table table){
        return consoleTableRowString(table.getColumnWidth(), table.headerDefinition.getTableDataList());
    }

    public String consoleTableRow(Table table){
        StringBuilder stringBuilder = new StringBuilder();
        for (TableRow tableRow: table.getRows()){
           stringBuilder.append(consoleTableRowString(table.getColumnWidth(), tableRow.getTableDataList()));
        }
        return stringBuilder.toString();
    }



    public String consoleTable(Table table){
        table.commonRowSeparator = getRowSeparatorLine(table.columnWidth);
        String tableString = consoleTableHeader(table);
        tableString += consoleTableRow(table);
        tableString += table.commonRowSeparator;
        return tableString;
    }

    public void toTable(Table table){
        table = process(table);
        System.out.println(consoleTable(table));
    }

}
