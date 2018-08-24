package com.example.demo_jsqlparser.interceptor.sqlParserImpl;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;

public class FromItemVisitorImpl implements FromItemVisitor {
    @Override
    public void visit(Table table) {
        System.out.println("-----FromItemVisitorImpl---Table");
    }

    @Override
    public void visit(SubSelect subSelect) {

    }

    @Override
    public void visit(SubJoin subJoin) {

    }

    @Override
    public void visit(LateralSubSelect lateralSubSelect) {

    }

    @Override
    public void visit(ValuesList valuesList) {

    }

    @Override
    public void visit(TableFunction tableFunction) {

    }
}
