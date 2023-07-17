package com.phw.websocket;

import com.phw.websocket.dto.Greeting;
import com.phw.websocket.dto.HelloMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequestMapping("api")
@Log4j2
public class GreetingController {

    @MessageMapping("hello")
    @SendTo("/topic/greetings")
    public Greeting greeting (HelloMessage helloMessage) throws Exception {
        Thread.sleep(1000);
        log.info("New Message : "+helloMessage.getName());
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName() + "!"));
    }

}
