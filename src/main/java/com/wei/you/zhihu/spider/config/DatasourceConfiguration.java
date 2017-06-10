package com.wei.you.zhihu.spider.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.wei.you.zhihu.spider.config.property.DatasourceProperties;

/**
 * 配置数据源
 * 
 * @author sunzc
 *
 *         2017年6月2日 下午8:07:07
 */
@Configuration
public class DatasourceConfiguration {

	private static final Logger log = LoggerFactory.getLogger(DatasourceConfiguration.class);

	@Autowired
	DatasourceProperties property;

	@Bean
	public DatasourceProperties properties() {
		return new DatasourceProperties();
	}

	@Bean
	public DataSource dataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();

		/**
		 * 驱动配置
		 */
		druidDataSource.setDriverClassName(property.getDriverClassName());
		druidDataSource.setUrl(property.getUrl());
		druidDataSource.setUsername(property.getUsername());
		druidDataSource.setPassword(property.getPassword());

		/**
		 * 其它链接池配置自行完成
		 */
		druidDataSource.setConnectionProperties(property.getConnectionProperties());

		try {
			druidDataSource.setFilters(property.getFilters());
		} catch (SQLException e) {
			log.error("druid configuration initialization filter", e);
		}

		return druidDataSource;
	}
}