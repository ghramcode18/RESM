package The.Geeks.RESM.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import The.Geeks.RESM.dto.Greeting;
import The.Geeks.RESM.dto.HelloMessage;

@Controller
public class GreetingController {

    @MessageMapping("/hello/{username}")
    @SendTo("/topic/greetings/{username}")
    public Greeting greeting(HelloMessage message, @DestinationVariable String username) throws Exception {
        System.out.println(username);
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
