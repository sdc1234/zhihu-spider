package com.wei.you.zhihu.spider.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.wei.you.zhihu.spider.constant.ConstantResult;
import com.wei.you.zhihu.spider.dto.ResultDTO;
import com.wei.you.zhihu.spider.dto.ResultOfZhihuRecommendationData;
import com.wei.you.zhihu.spider.service.IZhihuRecommendationService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T20:25:53.736+08:00")

@Controller
public class ZhihuRecommendationApiController implements ZhihuRecommendationApi {
	// 注入分析知乎Recommendation获取的网页数据服务
	@Autowired
	private IZhihuRecommendationService zhihuRecommendationService;

	public ResponseEntity<ResultDTO> anaylicsRecommendationGet() {
		String htmlStr = zhihuRecommendationService.anaylicsRecommendation();
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(new ResultOfZhihuRecommendationData()
				.htmlStr(htmlStr).result(ConstantResult.CONSRANT_RESULT_SUCCESS_CODE), HttpStatus.OK);
		return resultDto;
	}

}
