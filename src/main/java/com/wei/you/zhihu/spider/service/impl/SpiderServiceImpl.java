package com.wei.you.zhihu.spider.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wei.you.zhihu.spider.config.property.AppConfig;
import com.wei.you.zhihu.spider.constant.ConstantField;
import com.wei.you.zhihu.spider.entity.Question;
import com.wei.you.zhihu.spider.init.InitStartupRunner;
import com.wei.you.zhihu.spider.service.IQuestionService;
import com.wei.you.zhihu.spider.service.ISpiderService;
import com.wei.you.zhihu.spider.utils.SpiderQueue;

/**
 * 爬虫服务接口实现
 * 
 * @author sunzc
 *
 *         2017年6月10日 下午7:17:33
 */
@Component
public class SpiderServiceImpl implements ISpiderService {
	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(InitStartupRunner.class);

	// 注入配置信息服务
	@Autowired
	private AppConfig config;
	/**
	 * 注入知乎问题服务
	 */
	@Autowired
	private IQuestionService questionService;

	/**
	 * 发送get请求，获取整个页面html
	 * 
	 * @param url
	 * @return
	 */
	@Override
	public String SendGet(String url) {
		// 构建返回值页面内容
		String result = "";
		logger.info("SendGet正在抓取：" + url);
		// 定义读取缓冲区
		BufferedReader in = null;
		try {
			// 定义URL
			URL realUrl = new URL(url);
			// 进行url链接
			URLConnection connection = realUrl.openConnection();
			connection.connect();
			// 获取URL链接后的读入流
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			// 当读到的信息不为null时
			while ((line = in.readLine()) != null) {
				// 将读取到的内容连接到返回的页面字符串上
				result += line;
			}
		} catch (Exception e) {
			logger.info("Spider get error:" + url, e);
		} finally {
			try {
				if (in != null) {
					// 关闭读入流
					in.close();
				}
			} catch (Exception e) {
				logger.info("读入流关闭出现异常:" + url, e);
			}

		}
		return result;
	}

	/**
	 * 根据爬取的页面内容构建知乎问题列表
	 * 
	 * @param content
	 * @return
	 */
	@Override
	public List<Question> getRec(String content) {
		// 构建返回的知乎问题列表
		List<Question> result = new ArrayList<Question>();
		// 获取知乎问题链接的uri的正则表达式的匹配字符串
		Pattern pattern = Pattern.compile(config.getMatchQuestionUrlLink());
		// 进行正则匹配
		Matcher matcher = pattern.matcher(content);
		// 循环遍历匹配得到的uri字符串数组
		while (matcher.find()) {
			// 构建知乎问题
			Question zhihuQuestion = questionService.initQuestion(matcher.group(1));
			// 将知乎问题加入知乎问题列表
			result.add(zhihuQuestion);
		}
		return result;
	}

	/**
	 * 根据爬取的uri获取真实可访问的url
	 * 
	 * @param url
	 * @return
	 */
	@Override
	public String getRealUrl(String url) {
		String ret = config.getZhihuExploreRecommendationsUrl();
		Pattern pattern = Pattern.compile(config.getMatchRealQuestionURI());
		Matcher matcher = pattern.matcher(url);
		if (matcher.find())
			ret = config.getZhihuUrl() + ConstantField.URL_SPERATOR_FLAG + ConstantField.QUESTION_CONSTANT_FIELD
					+ ConstantField.URL_SPERATOR_FLAG + matcher.group(1);
		else if (url.length() < 25) {
			ret = config.getZhihuUrl() + url;
		}
		return ret;
	}

	/**
	 * 将爬取的问题列表入库
	 * 
	 * @param content
	 * @return
	 */
	@Override
	public void getTarget(String content) {
		SpiderQueue queue = new SpiderQueue();
		Pattern pattern = Pattern.compile(config.getMatchQuestionUrlLink());
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			queue.addUnvisitedUrl(matcher.group(1));
			logger.info("from recommendations:" + matcher.group(1));
		}
		while (!queue.unVisitedUrlsEmpty()) {
			logger.info("queue is empty" + queue.getVisitedUrlNum());
			String url = (String) queue.unVisitedUrlDequeue();
			queue.addVisitedUrl(url);
			Question zhihuQuestion = questionService.initQuestion(url);
			url = getRealUrl(url);
			String c = SendGet(url);
			Pattern p = Pattern.compile(config.getMatchQuestionDeepUrlLink());
			Matcher m = p.matcher(c);
			if (queue.getUnVisitedUrlNum() <= 1000)
				while (m.find()) {
					logger.info("get url from:" + m.group(1) + " number:" + queue.getUnVisitedUrlNum());
					queue.addUnvisitedUrl(m.group(1));
				}

			logger.info("the loop :" + url);

			questionService.save(zhihuQuestion);

			// FileReaderWriter.writeIntoFile(tmp.writeString(),
			// "E:/test/zhihu-" + LocalDate.now().toString() + ".txt",
			// true); // 将获得的数据写入文件中
		}

	}

}
