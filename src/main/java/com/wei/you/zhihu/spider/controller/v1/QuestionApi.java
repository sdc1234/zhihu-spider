package com.wei.you.zhihu.spider.controller.v1;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wei.you.zhihu.spider.dto.ResultDTO;
import com.wei.you.zhihu.spider.entity.Question;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T20:25:53.736+08:00")
@RequestMapping(value = "/zhihu/api/v1")
@Api(value = "question", description = "the question API")
public interface QuestionApi {

	@ApiOperation(value = "知乎问题新增", notes = "知乎问题新增", response = ResultDTO.class, tags = { "ZhihuQuestion", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "知乎问题新增结果", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/question/add", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<ResultDTO> questionAddPost(
			@ApiParam(value = "问题对象") @RequestBody(required = true) Question question);

	@ApiOperation(value = "知乎问题删除", notes = "知乎问题删除", response = ResultDTO.class, tags = { "ZhihuQuestion", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求删除结果", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/question/delete", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<ResultDTO> questionDeleteDelete(
			@NotNull @ApiParam(value = "问题编号", required = true) @RequestParam(value = "id", required = true) String id);

	@ApiOperation(value = "知乎问题", notes = "知乎问题列表", response = ResultDTO.class, tags = { "ZhihuQuestion", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回知乎问题信息列表", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/question/list", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<ResultDTO> questionListGet(
			@NotNull @ApiParam(value = "起始页", required = true, defaultValue = "1") @RequestParam(value = "start", required = true) int start,
			@NotNull @ApiParam(value = "页展示数", required = true, defaultValue = "6") @RequestParam(value = "size", required = true) int size);

	@ApiOperation(value = "问题获取", notes = "问题获取", response = ResultDTO.class, tags = { "ZhihuQuestion", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回问题对象", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/question/get", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ResultDTO> questionGetGet(
			@NotNull @ApiParam(value = "问题id", required = true, defaultValue = "0213f784cdd9493aab7d44683b0bbb1d") @RequestParam(value = "id", required = true) String id);

}
