package com.wei.you.zhihu.spider.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wei.you.zhihu.spider.dto.ResultDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T20:25:53.736+08:00")
@RequestMapping(value = "/zhihu/api/v1")
@Api(value = "zhihu-recommendation", description = "the zhihu-recommendation API")
public interface ZhihuRecommendationApi {
	@ApiOperation(value = "获取网页数据", notes = "获取网页数据", response = ResultDTO.class, tags = { "ZhihuRecommendation", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回获取网页数据", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/recomd/zhihu/get", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ResultDTO> anaylicsRecommendationGet();
}
