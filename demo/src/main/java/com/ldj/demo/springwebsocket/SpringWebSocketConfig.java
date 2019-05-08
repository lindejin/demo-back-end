package com.ldj.demo.springwebsocket;

import com.ldj.demo.interceptor.SpringWebSocketHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author ldj
 * @date 2019/5/5 14:49
 * 编辑SpringWebSocketConfig，根据spring文档，编写websocketConfig，这里可参看文档，xml配置和使用注解两种方式，我选择注解方式
 *
 * registerWebSocketHandlers：这个方法是向spring容器注册一个handler地址，我把他理解成requestMapping
 *
 * addInterceptors：拦截器，当建立websocket连接的时候，我们可以通过继承spring的HttpSessionHandshakeInterceptor来搞事情。
 *
 * setAllowedOrigins：跨域设置，*表示所有域名都可以，不限制， 域包括ip：port, 指定*可以是任意的域名，不加的话默认localhost+本服务端口
 *
 * withSockJS： 这个是应对浏览器不支持websocket协议的时候降级为轮询的处理。
 */

@Configuration
@EnableWebSocket
public class SpringWebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("555");
        registry.addHandler(webSocketHandler(), "/websocket/socketServer")
                .addInterceptors(new SpringWebSocketHandlerInterceptor()).setAllowedOrigins("*");

        registry.addHandler(webSocketHandler(), "/sockjs/socketServer").setAllowedOrigins("*")
                .addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
    }

    @Bean
    public SpringWebSocketHandler webSocketHandler() {

        return new SpringWebSocketHandler();
    }
}
