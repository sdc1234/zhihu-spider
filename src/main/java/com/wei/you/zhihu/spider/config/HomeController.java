package com.wei.you.zhihu.spider.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:41:13
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("swagger-ui.html");
		return "redirect:swagger-ui.html";
	}
}
