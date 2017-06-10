/**
 * 
 */
package com.wei.you.zhihu.spider.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

import com.wei.you.zhihu.spider.dto.ResultDTO;
import com.wei.you.zhihu.spider.exception.ZhihuOptException;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理
 * 
 * @author sunzc
 *
 *         2017年6月7日 下午8:59:30
 */
@Slf4j
public class BaseApiController {
	protected ResponseEntity<ResultDTO> defaultFallback(Throwable e) {
		String errorMsg;
		String code = "300";
		if (e instanceof ZhihuOptException) {
			errorMsg = e.getMessage();
		} else if (e instanceof ResourceAccessException) {
			errorMsg = "节点连接失败";
			code = "500";
		} else {
			errorMsg = "服务发生错误";
			code = "500";
		}
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(
				new ResultDTO().result(code).errorMsg(errorMsg), HttpStatus.OK);
		log.error("**** 发生异常 ****", e);
		return resultDto;
	}
}
