package com.example.demo.test.redis.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionExpiredEvent;

/**
 * @Description spring-session监听配置
 * @Date 2020/7/27 14:48
 * @Author cly
 **/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)//使用redis保存session 过期时间设置10秒
public class SpringSessionConfiguration {
    Logger log= LoggerFactory.getLogger(SpringSessionConfiguration.class);
    /**
     * Redis内session过期事件监听
     * @param expiredEvent
     */
    @EventListener
    public void onSessionExpired(SessionExpiredEvent expiredEvent) {
        String sessionId = expiredEvent.getSessionId();
        log.info("Session失效事件:"+sessionId);

    }

    /**
     * Redis内session创建事件监听
     * @param createdEvent
     */
    @EventListener
    public void onSessionCreated(SessionCreatedEvent createdEvent) {
        String sessionId = createdEvent.getSessionId();
        log.info("创建Session事件:"+sessionId);
    }

    /**
     * Redis内session删除事件监听
     * @param deletedEvent
     */
    @EventListener
    public void onSessionDeleted(SessionDeletedEvent deletedEvent) {
        String sessionId = deletedEvent.getSessionId();
        log.info("删除Session事件:"+sessionId);
    }
}

