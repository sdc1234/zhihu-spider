package com.wei.you.zhihu.spider.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T20:25:53.736+08:00")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "ResultDTOType", visible = true)
@JsonSubTypes({})

public class ResultDTO {
	@JsonProperty("result")
	private String result = null;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("errorMsg")
	private String errorMsg = null;

	public ResultDTO result(String result) {
		this.result = result;
		return this;
	}

	/**
	 * 返回编码
	 * 
	 * @return result
	 **/
	@ApiModelProperty(value = "返回编码")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@ApiModelProperty(value = "返回信息")
	public String getMessage() {
		return message;
	}
	
	public ResultDTO message(String message) {
		this.message = message;
		return this;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultDTO errorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}

	/**
	 * 返回错误信息
	 * 
	 * @return errorMsg
	 **/
	@ApiModelProperty(value = "返回错误信息")
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultDTO resultDTO = (ResultDTO) o;
		return Objects.equals(this.result, resultDTO.result) && Objects.equals(this.errorMsg, resultDTO.errorMsg);
	}

	@Override
	public int hashCode() {
		return Objects.hash(result, errorMsg);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultDTO {\n");

		sb.append("    result: ").append(toIndentedString(result)).append("\n");
		sb.append("    errorMsg: ").append(toIndentedString(errorMsg)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
