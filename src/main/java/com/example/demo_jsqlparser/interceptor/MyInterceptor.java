package com.example.demo_jsqlparser.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

@Intercepts( {
        @Signature(method = "query", type = Executor.class, args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class }),
        @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("进入拦截器");
        return null;
    }

    @Override
    public Object plugin(Object o) {
        System.out.println("进入拦截器1");
        return null;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("进入拦截器2");
    }
}
