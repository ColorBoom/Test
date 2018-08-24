package com.example.demo_jsqlparser.interceptor.sqlParserImpl;

import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItemVisitor;

public class SelectItemVisitorImpl implements SelectItemVisitor {
    @Override
    public void visit(AllColumns allColumns) {
        System.out.println("-----SelectItemVisitorImpl---AllColumns");

    }

    @Override
    public void visit(AllTableColumns allTableColumns) {
        System.out.println("-----SelectItemVisitorImpl---AllTableColumns");
    }

    @Override
    public void visit(SelectExpressionItem selectExpressionItem) {
        System.out.println("-----SelectItemVisitorImpl---SelectExpressionItem");
        selectExpressionItem.getExpression().accept(new ExpressionVisitorImpl());
    }
}
