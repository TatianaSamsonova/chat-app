package com.learning.springwschatapp.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by TatianaSamsonova on 7/12/2020
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //A registration of a websocket endpoint that the clients will use to connect to our websocket server
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //defines that the messages whose destination starts with “/app” should be routed to message-handling methods
        registry.setApplicationDestinationPrefixes("/app");

        //defines that the messages whose destination starts with “/topic” should be routed to the message broker
        registry.enableSimpleBroker("/topic");

    }
}
