package com.example.demo_jsqlparser.interceptor;

import com.example.demo_jsqlparser.interceptor.sqlParserImpl.SelectVisitorImpl;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.sql.Connection;
import java.util.Properties;

@Intercepts( {
//        @Signature(method = "query", type = Executor.class, args = {
//                MappedStatement.class, Object.class, RowBounds.class,
//                ResultHandler.class , Integer.class}),
        @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class , Integer.class}) })
@Component
public class MyInterceptor implements Interceptor {

    CCJSqlParserManager parserManager = new CCJSqlParserManager();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("进入拦截器");
        StatementHandler handler = (StatementHandler) invocation.getTarget();

        MetaObject statementHandler = SystemMetaObject.forObject(handler);

        MappedStatement mappedStatement = (MappedStatement) statementHandler.getValue("delegate.mappedStatement");

        BoundSql boundSql = handler.getBoundSql();

        String sql = boundSql.getSql();
        String id = mappedStatement.getId();

        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        if ("SELECT".equals(sqlCommandType.name())){
            Select select = (Select) parserManager.parse(new StringReader(sql));
            select.getSelectBody().accept(new SelectVisitorImpl());
            statementHandler.setValue("delegate.boundSql.sql",select.toString());
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        System.out.println("进入拦截器1");
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("进入拦截器2");
    }
}
