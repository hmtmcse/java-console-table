package com.hmtmcse.console.table.data;

import java.util.ArrayList;

public class TableHeaderDefinition extends TableRow{

    public TableHeaderDefinition(){
        tableDataList = new ArrayList<>();
    }


    public TableHeaderDefinition add(String data){
        tableDataList.add(new TableData(data));
        return this;
    }


    public TableHeaderDefinition add(String data, String align){
        tableDataList.add(TableData.instance(data).setAlign(align));
        return this;
    }

    public TableHeaderDefinition addWithTextColor(String data, String color){
        tableDataList.add(TableData.instance(data).setTextColor(color));
        return this;
    }

    public TableHeaderDefinition add(String data, String align, String textColor){
        tableDataList.add(TableData.instance(data).setAlign(align).setTextColor(textColor));
        return this;
    }

}
