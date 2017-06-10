package com.wei.you.zhihu.spider.controller.v1;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.wei.you.zhihu.spider.constant.ConstantResult;
import com.wei.you.zhihu.spider.dto.ResultDTO;
import com.wei.you.zhihu.spider.dto.ResultOfQuestion;
import com.wei.you.zhihu.spider.dto.ResultOfQuestionData;
import com.wei.you.zhihu.spider.entity.Question;
import com.wei.you.zhihu.spider.service.IQuestionService;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T20:25:53.736+08:00")

@Controller
public class QuestionApiController implements QuestionApi {

	// 注入知乎问题服务
	@Autowired
	private IQuestionService questionService;

	public ResponseEntity<ResultDTO> questionAddPost(
			@ApiParam(value = "问题对象") @RequestBody(required = true) Question question) {
		// 定义返回值信息
		ResultDTO result = new ResultDTO();
		// 保存知乎问题
		if (questionService.save(question)) {
			// 如果成功，设置保存成功code值
			result.setResult(ConstantResult.CONSRANT_RESULT_SUCCESS_CODE);
			// 设置保存成功message信息
			result.setMessage(ConstantResult.CONSRANT_RESULT_SUCCESS_MESSAGE);
		} else {
			// 如果成功，设置保存失败code值
			result.setResult(ConstantResult.CONSRANT_RESULT_FAILURE_CODE);
			// 设置保存失败message信息
			result.setMessage(ConstantResult.CONSRANT_RESULT_FAILURE_MESSAGE);
		}
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
		return resultDto;
	}

	public ResponseEntity<ResultDTO> questionDeleteDelete(
			@NotNull @ApiParam(value = "问题编号", required = true) @RequestParam(value = "id", required = true) String id) {
		// 定义返回值信息
		ResultDTO result = new ResultDTO();
		// 删除知乎问题
		if (questionService.deleteById(id)) {
			// 如果成功，设置删除成功code值
			result.setResult(ConstantResult.CONSRANT_RESULT_SUCCESS_CODE);
			// 设置删除成功message信息
			result.setMessage(ConstantResult.CONSRANT_RESULT_SUCCESS_MESSAGE);
		} else {
			// 如果成功，设置删除失败code值
			result.setResult(ConstantResult.CONSRANT_RESULT_FAILURE_CODE);
			// 设置删除失败message信息
			result.setMessage(ConstantResult.CONSRANT_RESULT_FAILURE_MESSAGE);
		}
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
		return resultDto;
	}

	public ResponseEntity<ResultDTO> questionListGet(
			@NotNull @ApiParam(value = "起始页", required = true, defaultValue = "1") @RequestParam(value = "start", required = true) int start,
			@NotNull @ApiParam(value = "页展示数", required = true, defaultValue = "6") @RequestParam(value = "size", required = true) int size) {
		List<Question> questionData = questionService.queryAll(start, size);
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(new ResultOfQuestionData()
				.questionData(questionData).result(ConstantResult.CONSRANT_RESULT_SUCCESS_CODE), HttpStatus.OK);
		return resultDto;
	}

	public ResponseEntity<ResultDTO> questionGetGet(
			@NotNull @ApiParam(value = "问题id", required = true, defaultValue = "0213f784cdd9493aab7d44683b0bbb1d") @RequestParam(value = "id", required = true) String id) {
		Question question = questionService.selectById(id);
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(
				new ResultOfQuestion().question(question).result(ConstantResult.CONSRANT_RESULT_SUCCESS_CODE),
				HttpStatus.OK);
		return resultDto;
	}

}
