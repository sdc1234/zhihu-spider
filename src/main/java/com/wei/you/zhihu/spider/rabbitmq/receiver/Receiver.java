package com.wei.you.zhihu.spider.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wei.you.zhihu.spider.entity.Question;
import com.wei.you.zhihu.spider.entity.User;
import com.wei.you.zhihu.spider.service.IQuestionService;
import com.wei.you.zhihu.spider.service.IUserService;

/**
 * 消息消费者
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:07:58
 */
@Component
public class Receiver {
	// 注入知乎用户资料服务
	@Autowired
	private IUserService userService;

	// 注入知乎问题服务
	@Autowired
	private IQuestionService questionService;

	/**
	 * 监听知乎用户资料消息队列
	 * 
	 * @param user
	 */
	@RabbitListener(queues = "zhuhu.user.queue")
	public void processZhihuUser(User user) {
		// 保存知乎用户
		userService.save(user);
	}

	/**
	 * 监听知乎问题消息队列
	 * 
	 * @param user
	 */
	@RabbitListener(queues = "zhuhu.question.queue")
	public void processZhihuQuestion(Question question) {
		// 保存知乎用户
		questionService.save(question);
	}
}
