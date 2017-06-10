package com.wei.you.zhihu.spider.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wei.you.zhihu.spider.entity.User;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultOfuser
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-23T09:36:17.492+08:00")

public class ResultOfUser extends ResultDTO {
	@JsonProperty("user")
	private User user = null;

	public ResultOfUser user(User user) {
		this.user = user;
		return this;
	}

	/**
	 * ResultOfuser实体
	 * 
	 * @return user
	 **/
	@ApiModelProperty(value = "user实体")
	public User getApplicationData() {
		return user;
	}

	public void setApplicationData(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultOfUser resultOfuser = (ResultOfUser) o;
		return Objects.equals(this.user, resultOfuser.user) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultOfuser {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
