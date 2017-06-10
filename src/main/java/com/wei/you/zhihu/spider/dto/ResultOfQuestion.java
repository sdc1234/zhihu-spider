package com.wei.you.zhihu.spider.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wei.you.zhihu.spider.entity.Question;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultOfquestion
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-23T09:36:17.492+08:00")

public class ResultOfQuestion extends ResultDTO {
	@JsonProperty("question")
	private Question question = null;

	public ResultOfQuestion question(Question question) {
		this.question = question;
		return this;
	}

	/**
	 * ResultOfquestion实体
	 * 
	 * @return question
	 **/
	@ApiModelProperty(value = "question实体")
	public Question getApplicationData() {
		return question;
	}

	public void setApplicationData(Question question) {
		this.question = question;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultOfQuestion resultOfquestion = (ResultOfQuestion) o;
		return Objects.equals(this.question, resultOfquestion.question) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultOfquestion {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    question: ").append(toIndentedString(question)).append("\n");
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
