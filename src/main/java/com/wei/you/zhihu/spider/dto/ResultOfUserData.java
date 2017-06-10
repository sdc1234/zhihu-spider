package com.wei.you.zhihu.spider.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wei.you.zhihu.spider.entity.User;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultOfUserData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-23T09:36:17.492+08:00")

public class ResultOfUserData extends ResultDTO {
	@JsonProperty("userData")
	private List<User> userData = null;

	public ResultOfUserData userData(List<User> userData) {
		this.userData = userData;
		return this;
	}

	/**
	 * ResultOfUserData实体
	 * 
	 * @return userData
	 **/
	@ApiModelProperty(value = "UserData实体")
	public List<User> getApplicationData() {
		return userData;
	}

	public void setApplicationData(List<User> userData) {
		this.userData = userData;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultOfUserData resultOfuserData = (ResultOfUserData) o;
		return Objects.equals(this.userData, resultOfuserData.userData) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userData, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultOfUserData {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
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
