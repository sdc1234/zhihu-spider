package com.wei.you.zhihu.spider.controller.v1;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wei.you.zhihu.spider.dto.ResultDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T20:25:53.736+08:00")
@RequestMapping(value = "/zhihu/api/v1")
@Api(value = "user", description = "the user API")
public interface UserApi {

	@ApiOperation(value = "用户新增", notes = "用户新增", response = ResultDTO.class, tags = { "ZhihuUser", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回应用服务器的请求列表", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/user/add", produces = { "application/json" }, method = RequestMethod.POST)
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
			@NotNull @ApiParam(value = "用户唯一标识", required = false, defaultValue = "88fb5d79df5a332cf16c8f8ad659dcf4") @RequestParam(value = "hashId", required = false) String hashId);

	@ApiOperation(value = "用户删除", notes = "用户删除", response = ResultDTO.class, tags = { "ZhihuUser", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回应用服务器的请求列表", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/user/delete", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<ResultDTO> userDeleteDelete(
			@NotNull @ApiParam(value = "用户id", required = true) @RequestParam(value = "id", required = true) String id);

	@ApiOperation(value = "用户获取", notes = "用户获取", response = ResultDTO.class, tags = { "ZhihuUser", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回应用服务器的请求列表", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/user/get", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ResultDTO> userGetGet(
			@NotNull @ApiParam(value = "用户id", required = true, defaultValue = "8619") @RequestParam(value = "id", required = true) String id);

	@ApiOperation(value = "用户修改", notes = "用户修改", response = ResultDTO.class, tags = { "ZhihuUser", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回应用服务器的请求列表", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/user/edit", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<ResultDTO> userEditPut(
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
			@NotNull @ApiParam(value = "用户唯一标识", required = false, defaultValue = "88fb5d79df5a332cf16c8f8ad659dcf4") @RequestParam(value = "hashId", required = false) String hashId);

	@ApiOperation(value = "用户展示", notes = "知乎用户列表", response = ResultDTO.class, tags = { "ZhihuUser", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "返回应用服务器的请求列表", response = ResultDTO.class),
			@ApiResponse(code = 200, message = "返回错误信息", response = ResultDTO.class) })

	@RequestMapping(value = "/user/list", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<ResultDTO> userListGet(
			@NotNull @ApiParam(value = "起始页", required = true) @RequestParam(value = "start", required = true, defaultValue = "1") int start,
			@NotNull @ApiParam(value = "页展示数", required = true) @RequestParam(value = "size", required = true, defaultValue = "6") int size);

}
