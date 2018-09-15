package com.hmtmcse.console.table.structure;

import com.hmtmcse.console.table.data.Table;

public interface TableBuilder {

    public String header(Table table);
    public String body(Table table);
    public String build(Table table);

}
