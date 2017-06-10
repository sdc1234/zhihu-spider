package com.wei.you.zhihu.spider.controller.v1;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.wei.you.zhihu.spider.constant.ConstantResult;
import com.wei.you.zhihu.spider.dto.ResultDTO;
import com.wei.you.zhihu.spider.dto.ResultOfUser;
import com.wei.you.zhihu.spider.dto.ResultOfUserData;
import com.wei.you.zhihu.spider.entity.User;
import com.wei.you.zhihu.spider.service.IUserService;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T20:25:53.736+08:00")

@Controller
public class UserApiController implements UserApi {
	// 注入知乎用户资料服务
	@Autowired
	private IUserService userService;

	public ResponseEntity<ResultDTO> userAddPost(
			@NotNull @ApiParam(value = "用户名", required = false, defaultValue = "夕阳晚晴") @RequestParam(value = "username", required = false) String username,
			@NotNull @ApiParam(value = "user token", required = false, defaultValue = "xi-yang-wan-qing-30") @RequestParam(value = "userToken", required = false) String userToken,
			@NotNull @ApiParam(value = "位置", required = false) @RequestParam(value = "location", required = false) String location,
			@NotNull @ApiParam(value = "行业", required = false, defaultValue = "互联网") @RequestParam(value = "business", required = false) String business,
			@NotNull @ApiParam(value = "性别", required = false, defaultValue = "male") @RequestParam(value = "sex", required = false) String sex,
			@NotNull @ApiParam(value = "企业", required = false) @RequestParam(value = "employment", required = false) String employment,
			@NotNull @ApiParam(value = "教育", required = false) @RequestParam(value = "education", required = false) String education,
			@NotNull @ApiParam(value = "用户首页url", required = false, defaultValue = "https://www.zhihu.com/people/xi-yang-wan-qing-30/activities") @RequestParam(value = "url", required = false) String url,
			@NotNull @ApiParam(value = "答案赞同数", required = false, defaultValue = "0") @RequestParam(value = "agrees", required = false) Integer agrees,
			@NotNull @ApiParam(value = "感谢数", required = false, defaultValue = "0") @RequestParam(value = "thanks", required = false) Integer thanks,
			@NotNull @ApiParam(value = "提问数", required = false, defaultValue = "0") @RequestParam(value = "asks", required = false) Integer asks,
			@NotNull @ApiParam(value = "回答数", required = false, defaultValue = "0") @RequestParam(value = "answers", required = false) Integer answers,
			@NotNull @ApiParam(value = "文章数", required = false, defaultValue = "0") @RequestParam(value = "posts", required = false) Integer posts,
			@NotNull @ApiParam(value = "关注人数", required = false, defaultValue = "1") @RequestParam(value = "followees", required = false) Integer followees,
			@NotNull @ApiParam(value = "粉丝数量", required = false, defaultValue = "0") @RequestParam(value = "followers", required = false) Integer followers,
			@NotNull @ApiParam(value = "用户唯一标识", required = false, defaultValue = "88fb5d79df5a332cf16c8f8ad659dcf4") @RequestParam(value = "hashId", required = false) String hashId) {
		// 定义返回值信息
		ResultDTO result = new ResultDTO();
		// 定义保存用户资料对象
		User user = new User(username, userToken, location, business, sex, employment, education, url,
				agrees == null ? 0 : agrees, thanks == null ? 0 : thanks, asks == null ? 0 : asks,
				answers == null ? 0 : answers, posts == null ? 0 : posts, followees == null ? 0 : followees,
				followers == null ? 0 : followers, hashId);
		// 保存知乎用户资料
		if (userService.save(user)) {
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

	public ResponseEntity<ResultDTO> userDeleteDelete(
			@NotNull @ApiParam(value = "用户id", required = true) @RequestParam(value = "id", required = true) String id) {
		// 定义返回值信息
		ResultDTO result = new ResultDTO();
		// 删除用户资料信息
		if (userService.deleteById(id)) {
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

	public ResponseEntity<ResultDTO> userEditPut(
			@NotNull @ApiParam(value = "用户id", required = true) @RequestParam(value = "id", required = true) String id,
			@NotNull @ApiParam(value = "用户名", required = false, defaultValue = "夕阳晚晴") @RequestParam(value = "username", required = false) String username,
			@NotNull @ApiParam(value = "user token", required = false, defaultValue = "xi-yang-wan-qing-30") @RequestParam(value = "userToken", required = false) String userToken,
			@NotNull @ApiParam(value = "位置", required = false) @RequestParam(value = "location", required = false) String location,
			@NotNull @ApiParam(value = "行业", required = false, defaultValue = "互联网") @RequestParam(value = "business", required = false) String business,
			@NotNull @ApiParam(value = "性别", required = false, defaultValue = "male") @RequestParam(value = "sex", required = false) String sex,
			@NotNull @ApiParam(value = "企业", required = false) @RequestParam(value = "employment", required = false) String employment,
			@NotNull @ApiParam(value = "教育", required = false) @RequestParam(value = "education", required = false) String education,
			@NotNull @ApiParam(value = "用户首页url", required = false, defaultValue = "https://www.zhihu.com/people/xi-yang-wan-qing-30/activities") @RequestParam(value = "url", required = false) String url,
			@NotNull @ApiParam(value = "答案赞同数", required = false, defaultValue = "0") @RequestParam(value = "agrees", required = false) Integer agrees,
			@NotNull @ApiParam(value = "感谢数", required = false, defaultValue = "0") @RequestParam(value = "thanks", required = false) Integer thanks,
			@NotNull @ApiParam(value = "提问数", required = false, defaultValue = "0") @RequestParam(value = "asks", required = false) Integer asks,
			@NotNull @ApiParam(value = "回答数", required = false, defaultValue = "0") @RequestParam(value = "answers", required = false) Integer answers,
			@NotNull @ApiParam(value = "文章数", required = false, defaultValue = "0") @RequestParam(value = "posts", required = false) Integer posts,
			@NotNull @ApiParam(value = "关注人数", required = false, defaultValue = "1") @RequestParam(value = "followees", required = false) Integer followees,
			@NotNull @ApiParam(value = "粉丝数量", required = false, defaultValue = "0") @RequestParam(value = "followers", required = false) Integer followers,
			@NotNull @ApiParam(value = "用户唯一标识", required = false, defaultValue = "88fb5d79df5a332cf16c8f8ad659dcf4") @RequestParam(value = "hashId", required = false) String hashId) {
		// 定义返回值信息
		ResultDTO result = new ResultDTO();
		// 定义保存用户资料对象
		User user = new User(username, userToken, location, business, sex, employment, education, url,
				agrees == null ? 0 : agrees, thanks == null ? 0 : thanks, asks == null ? 0 : asks,
				answers == null ? 0 : answers, posts == null ? 0 : posts, followees == null ? 0 : followees,
				followers == null ? 0 : followers, hashId);
		user.setId(id);
		// 保存知乎用户资料
		if (userService.updateById(user)) {
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

	public ResponseEntity<ResultDTO> userListGet(
			@NotNull @ApiParam(value = "起始页", required = true) @RequestParam(value = "start", required = true, defaultValue = "1") int start,
			@NotNull @ApiParam(value = "页展示数", required = true) @RequestParam(value = "size", required = true, defaultValue = "6") int size) {
		List<User> userData = userService.queryAll(start, size);
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(
				new ResultOfUserData().userData(userData).result(ConstantResult.CONSRANT_RESULT_SUCCESS_CODE),
				HttpStatus.OK);
		return resultDto;
	}

	public ResponseEntity<ResultDTO> userGetGet(
			@NotNull @ApiParam(value = "用户id", required = true, defaultValue = "8619") @RequestParam(value = "id", required = true) String id) {
		User user = userService.selectById(id);
		ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(
				new ResultOfUser().user(user).result(ConstantResult.CONSRANT_RESULT_SUCCESS_CODE), HttpStatus.OK);
		return resultDto;
	}

}
