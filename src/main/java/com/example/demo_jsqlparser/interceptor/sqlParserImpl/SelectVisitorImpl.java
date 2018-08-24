package com.example.demo_jsqlparser.interceptor.sqlParserImpl;

import net.sf.jsqlparser.statement.select.*;

public class SelectVisitorImpl implements SelectVisitor {

    @Override
    public void visit(PlainSelect plainSelect) {

        //访问select  SelectItemVistorImpl
        if(plainSelect.getSelectItems()!=null){
            for (SelectItem item:
                 plainSelect.getSelectItems()) {
                System.out.println(item.toString());
                item.accept(new SelectItemVisitorImpl());
            }
        }

        //访问from    FromItemVisitorImpl
        if (plainSelect.getFromItem()!=null){
            plainSelect.getFromItem().accept(new FromItemVisitorImpl());
        }

        //访问where   ExpressionVisitorImpl
        if(plainSelect.getWhere()!=null){
            plainSelect.getWhere().accept(new ExpressionVisitorImpl());
        }

        //过滤条件增强

        //访问join    FromItemVisitorImpl

        //访问order by ExpressionVisitorImpl

        //访问group having ExpressionVisitorImpl
    }

    @Override
    public void visit(SetOperationList setOperationList) {

    }

    @Override
    public void visit(WithItem withItem) {

    }
}
