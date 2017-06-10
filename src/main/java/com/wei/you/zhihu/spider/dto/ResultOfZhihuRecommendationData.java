package com.wei.you.zhihu.spider.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultOfhtmlStr
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-23T09:36:17.492+08:00")

public class ResultOfZhihuRecommendationData extends ResultDTO {
	@JsonProperty("htmlStr")
	private String htmlStr = null;

	public ResultOfZhihuRecommendationData htmlStr(String htmlStr) {
		this.htmlStr = htmlStr;
		return this;
	}

	/**
	 * ResultOfhtmlStr实体
	 * 
	 * @return htmlStr
	 **/
	@ApiModelProperty(value = "htmlStr实体")
	public String getHtmlStr() {
		return htmlStr;
	}

	public void setHtmlStr(String htmlStr) {
		this.htmlStr = htmlStr;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultOfZhihuRecommendationData resultOfhtmlStr = (ResultOfZhihuRecommendationData) o;
		return Objects.equals(this.htmlStr, resultOfhtmlStr.htmlStr) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(htmlStr, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultOfhtmlStr {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    htmlStr: ").append(toIndentedString(htmlStr)).append("\n");
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
