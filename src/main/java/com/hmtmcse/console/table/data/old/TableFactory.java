package com.hmtmcse.console.table.data.old;

import com.hmtmcse.console.table.common.TableConstant;
import com.hmtmcse.console.table.data.CellSpacing;
import com.hmtmcse.console.table.processor.LengthCalculator;

import java.util.List;

public class TableFactory {

    private LengthCalculator lengthCalculator;

    public TableFactory(){
        lengthCalculator = new LengthCalculator();
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

    public String getTableRowToString(TableRow tableRow, Integer maxColLength){
        lengthCalculator = new LengthCalculator();
        CellSpacing cellSpacing = lengthCalculator.calculateCellSpace(maxColLength, tableRow.name, tableRow.align);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getSpace(cellSpacing.start));
        stringBuilder.append(tableRow.name);
        stringBuilder.append(getSpace(cellSpacing.end));
        return stringBuilder.toString();
    }


    public String xyl(List<TableRow> tableRows, Table table){
        String defaultRowSeparator = getRowSeparatorLine(table.columnWidth);
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append(defaultRowSeparator);
        stringBuilder.append(TableConstant.NEW_LINE);
        for (int i = 0; i < table.getColumnWidth().size(); i++){
            stringBuilder.append("|");
            stringBuilder.append(getTableRowToString(table.getTableHeaders().get(i), table.getColumnWidth().get(i)));
        }
        stringBuilder.append("|");
        stringBuilder.append(TableConstant.NEW_LINE);
        stringBuilder.append(defaultRowSeparator);

        stringBuilder.append(TableConstant.NEW_LINE);
        List<TableRowItem> tableRowItems = table.getTableRows();
        for (int i = 0; i < table.getColumnWidth().size(); i++){
            stringBuilder.append("|");
            stringBuilder.append(getTableRowToString(table.getTableHeaders().get(i), table.getColumnWidth().get(i)));
        }
        stringBuilder.append("|");
        stringBuilder.append(TableConstant.NEW_LINE);
        stringBuilder.append(defaultRowSeparator);


        return stringBuilder.toString();
    }



    public String getTableRows(Table table) {
        table.rowSeparator = getRowSeparatorLine(table.columnWidth);
        StringBuilder stringBuilder = new StringBuilder();








        return "";
    }


    public Table process(Table table){
        table = lengthCalculator.calculate(table);
        return table;
    }


    public void toTable(Table table){
        table = process(table);
        String header = "";
        System.out.println(xyl(table.getTableHeaders(), table));
    }


}
