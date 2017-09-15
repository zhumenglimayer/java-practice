package com.mayer.mybatis.crud.dao;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({@Signature(type=StatementHandler.class,method="parameterize",args=java.sql.Statement.class)})
public class MyFirstPlugin implements Interceptor {

	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		System.out.println("MyPlugin...intercept" + arg0.getMethod());
		Object proceed = arg0.proceed();
		return proceed;
	}

	@Override
	public Object plugin(Object arg0) {
		System.out.println("MyPlugin...plugin" + arg0);
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		System.out.println("配置信息为：" + arg0);

	}

}
