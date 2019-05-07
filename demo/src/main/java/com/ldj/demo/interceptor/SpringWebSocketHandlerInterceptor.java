package com.ldj.demo.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ldj
 * @date 2019/5/5 14:51
 * 创建websocket连接是的拦截器，记录建立连接的用户的session以便根据不同session来通信
 */
public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {
  @Override
  public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                 Map<String, Object> attributes) throws Exception {
    System.out.println("Before Handshake");
    if (request instanceof ServletServerHttpRequest) {
      ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
      HttpSession session = servletRequest.getServletRequest().getSession(false);
      if (session != null) {
        //使用userName区分WebSocketHandler，以便定向发送消息
        String userName = (String) session.getAttribute("SESSION_USERNAME");  //一般直接保存user实体
        if (userName!=null) {
          attributes.put("WEBSOCKET_USERID",userName);
        }

      }
    }
//     System.out.println(response.toString());
    return super.beforeHandshake(request, response, wsHandler, attributes);

  }

  @Override
  public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                             Exception ex) {
    System.out.println("after Handshake");
    super.afterHandshake(request, response, wsHandler, ex);
  }

}
