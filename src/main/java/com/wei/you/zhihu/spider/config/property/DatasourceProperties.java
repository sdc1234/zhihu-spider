/** 
 * Project Name:titan-demo 
 * File Name:DatasourceProperties.java 
 * Package Name:com.changan.titan.property 
 * Date:2016年10月31日下午3:27:56 
 * Copyright (c) 2016, zengjing All Rights Reserved. 
 * 
 */  
package com.wei.you.zhihu.spider.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** 
 * ClassName: DatasourceProperties <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年10月31日 下午3:27:56 <br/> 
 * 
 * @author zengjing
 * @version  
 * @since JDK 1.8
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DatasourceProperties {
	
	private String driverClassName;
	
	private String url;
	
	private String username;
	
	private String password;
	
	private String filters;

	private String connectionProperties;
	
	/**
	 * @return the driverClassName
	 */
	public String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * @param driverClassName the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the filters
	 */
	public String getFilters() {
		return filters;
	}

	/**
	 * @param filters the filters to set
	 */
	public void setFilters(String filters) {
		this.filters = filters;
	}

	/**
	 * @return the connectionProperties
	 */
	public String getConnectionProperties() {
		return connectionProperties;
	}

	/**
	 * @param connectionProperties the connectionProperties to set
	 */
	public void setConnectionProperties(String connectionProperties) {
		this.connectionProperties = connectionProperties;
	}
}
