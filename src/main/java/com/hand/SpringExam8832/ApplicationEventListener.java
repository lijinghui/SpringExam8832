package com.hand.SpringExam8832;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class ApplicationEventListener implements ApplicationListener {

	public void onApplicationEvent(ApplicationEvent event) {

		// 如果是容器刷新事件
		 if (event instanceof ContextStartedEvent) {
			System.out.println("Context Start!");
		} else if (event instanceof ContextStoppedEvent) {
			System.out.println("Context stop!");
		}

	}

}