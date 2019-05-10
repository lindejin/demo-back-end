package com.ldj.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.ldj.demo.springwebsocket.SpringWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);
    @Bean//这个注解会从Spring容器拿出Bean
    public SpringWebSocketHandler infoHandler() {

        return new SpringWebSocketHandler();
    }
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/01", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "send";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "send";
    }
    @RequestMapping("/login01")
    public String login01(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        System.out.println(name+"登录");
        HttpSession session = request.getSession();
        // String name = "天才曾斌琪";
        session.setAttribute("name", name); //一般直接保存user实体
        return "/send02";
    }
    @RequestMapping("/send02")
    @ResponseBody
    public String send(HttpServletRequest request) {
        String username = request.getParameter("username");
        infoHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        return null;
    }
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(Locale locale, Model model) {
        return "login";
    }

}
