package com.wei.you.zhihu.spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring boot项目启动类
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:21:38
 */
@SpringBootApplication
@ServletComponentScan(value = { "com.wei.you.zhihu.spider" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
