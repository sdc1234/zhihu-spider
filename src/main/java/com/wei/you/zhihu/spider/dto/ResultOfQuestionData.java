package com.wei.you.zhihu.spider.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wei.you.zhihu.spider.entity.Question;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultOfQuestionData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-23T09:36:17.492+08:00")

public class ResultOfQuestionData extends ResultDTO {
	@JsonProperty("questionData")
	private List<Question> questionData = null;

	public ResultOfQuestionData questionData(List<Question> questionData) {
		this.questionData = questionData;
		return this;
	}

	/**
	 * ResultOfQuestionData实体
	 * 
	 * @return questionData
	 **/
	@ApiModelProperty(value = "questionData实体")
	public List<Question> getApplicationData() {
		return questionData;
	}

	public void setApplicationData(List<Question> questionData) {
		this.questionData = questionData;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultOfQuestionData resultOfQuestionData = (ResultOfQuestionData) o;
		return Objects.equals(this.questionData, resultOfQuestionData.questionData) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(questionData, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultOfQuestionData {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    questionData: ").append(toIndentedString(questionData)).append("\n");
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
