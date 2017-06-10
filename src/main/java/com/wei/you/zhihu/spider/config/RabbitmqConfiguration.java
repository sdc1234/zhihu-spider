package com.wei.you.zhihu.spider.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * 
 * @author sunzc
 *
 *         2017年6月10日 上午9:41:26
 */
@Configuration
public class RabbitmqConfiguration {

	/**
	 * 配置RabbitAdmin bean
	 * 
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {

		// 创建并返回RabbitAdmin对象
		return new RabbitAdmin(connectionFactory);
	}

	/**
	 * 配置知乎用户资料队列 bean
	 * 
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	public Queue zhihuUserDataQueue(@Autowired RabbitAdmin rabbitAdmin) {

		// 创建知乎用户资料队列对象
		Queue ubdQueue = new Queue("zhuhu.user.queue");

		// 声明知乎用户资料队列
		rabbitAdmin.declareQueue(ubdQueue);

		// 返回知乎用户资料队列
		return ubdQueue;
	}

	/**
	 * 配置知乎问题队列 bean
	 * 
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	public Queue userBehaviorDataQueue(@Autowired RabbitAdmin rabbitAdmin) {

		// 创建知乎问题队列对象
		Queue ubdQueue = new Queue("zhuhu.question.queue");

		// 声明知乎问题队列
		rabbitAdmin.declareQueue(ubdQueue);

		// 返回知乎问题队列
		return ubdQueue;
	}
}
