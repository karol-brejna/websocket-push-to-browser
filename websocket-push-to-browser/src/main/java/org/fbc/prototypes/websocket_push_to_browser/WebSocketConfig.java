package org.fbc.prototypes.websocket_push_to_browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	/**
	 * exposing a STOMP WebSocket/SockJS endpoint at the URL path /events
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/events").withSockJS();
	}

	/**
	 * messages whose destination starts with "/app" are routed to
	 * message-handling methods (i.e. application work) and messages whose
	 * destinations start with "/topic" or "/queue" will be routed to the
	 * message broker (i.e. broadcasting to other connected clients)
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/topic", "/queue");
	}
}