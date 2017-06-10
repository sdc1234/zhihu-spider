package com.wei.you.zhihu.spider.config.property;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置文件
 * 
 * @author Administrator
 *
 */
@Component
public class AppConfig implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -7192520003314346645L;
	@Value("${constant.match.question.edit-link}")
	private String matchQuestionEditLink;
	
	@Value("${constant.match.question.url-link}")
	private String matchQuestionUrlLink;
	
	@Value("${constant.match.question.deep-url-link}")
	private String matchQuestionDeepUrlLink;
	
	@Value("${constant.match.zhihu.question}")
	private String matchZhihuQuestion;
	
	@Value("${constant.match.zhihu.detail-question}")
	private String matchZhihuDetailQuestion;
	
	@Value("${constant.match.zhihu.answer}")
	private String matchZhihuAnswer;
	
	@Value("${constant.match.real-question-url}")
	private String zhihuUrl;
	
	@Value("${constant.zhihu.url}")
	private String matchRealQuestionURI;
	
	@Value("${constant.zhihu.explore-recommendations-url}")
	private String zhihuExploreRecommendationsUrl;

	public String getMatchQuestionEditLink() {
		return matchQuestionEditLink;
	}

	public void setMatchQuestionEditLink(String matchQuestionEditLink) {
		this.matchQuestionEditLink = matchQuestionEditLink;
	}

	public String getMatchQuestionUrlLink() {
		return matchQuestionUrlLink;
	}

	public void setMatchQuestionUrlLink(String matchQuestionUrlLink) {
		this.matchQuestionUrlLink = matchQuestionUrlLink;
	}

	public String getMatchQuestionDeepUrlLink() {
		return matchQuestionDeepUrlLink;
	}

	public void setMatchQuestionDeepUrlLink(String matchQuestionDeepUrlLink) {
		this.matchQuestionDeepUrlLink = matchQuestionDeepUrlLink;
	}

	public String getMatchZhihuQuestion() {
		return matchZhihuQuestion;
	}

	public void setMatchZhihuQuestion(String matchZhihuQuestion) {
		this.matchZhihuQuestion = matchZhihuQuestion;
	}

	public String getMatchZhihuDetailQuestion() {
		return matchZhihuDetailQuestion;
	}

	public void setMatchZhihuDetailQuestion(String matchZhihuDetailQuestion) {
		this.matchZhihuDetailQuestion = matchZhihuDetailQuestion;
	}

	public String getMatchZhihuAnswer() {
		return matchZhihuAnswer;
	}

	public void setMatchZhihuAnswer(String matchZhihuAnswer) {
		this.matchZhihuAnswer = matchZhihuAnswer;
	}

	public String getZhihuUrl() {
		return zhihuUrl;
	}

	public void setZhihuUrl(String zhihuUrl) {
		this.zhihuUrl = zhihuUrl;
	}

	public String getMatchRealQuestionURI() {
		return matchRealQuestionURI;
	}

	public void setMatchRealQuestionURI(String matchRealQuestionURI) {
		this.matchRealQuestionURI = matchRealQuestionURI;
	}

	public String getZhihuExploreRecommendationsUrl() {
		return zhihuExploreRecommendationsUrl;
	}

	public void setZhihuExploreRecommendationsUrl(String zhihuExploreRecommendationsUrl) {
		this.zhihuExploreRecommendationsUrl = zhihuExploreRecommendationsUrl;
	}

}
