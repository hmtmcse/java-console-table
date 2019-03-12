package com.hmtmcse.console.table.data;

import java.util.ArrayList;

public class TableRowData extends TableRow {


    public TableRowData(){
        tableDataList = new ArrayList<>();
    }


    public TableRowData add(String data){
        tableDataList.add(new TableData(data));
        return this;
    }

    public TableRowData add(Object data){
        tableDataList.add(new TableData(String.valueOf(data)));
        return this;
    }

    public TableRowData add(Object data, String align){
        tableDataList.add(new TableData(String.valueOf(data)).setAlign(align));
        return this;
    }

    public TableRowData add(String data, String align){
        tableDataList.add(new TableData(data).setAlign(align));
        return this;
    }

    public TableRowData add(String data, String align, String textColor){
        tableDataList.add(new TableData(data).setAlign(align).setTextColor(textColor));
        return this;
    }

    public TableRowData add(Object data, String align, String textColor){
        tableDataList.add(new TableData(String.valueOf(data)).setAlign(align).setTextColor(textColor));
        return this;
    }

    public TableRowData add(String data, String align, String textColor, Integer colSpan){
        tableDataList.add(new TableData(data).setAlign(align).setTextColor(textColor).setColSpan(colSpan));
        return this;
    }

    public TableRowData addWithTextColor(String data, String textColor){
        tableDataList.add(new TableData(data).setTextColor(textColor));
        return this;
    }

    public TableRowData addWithTextColor(Object data, String textColor){
        tableDataList.add(new TableData(String.valueOf(data)).setTextColor(textColor));
        return this;
    }


}
