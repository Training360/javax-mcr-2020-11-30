package training.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private HelloService helloService;

    // constructor injection
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        String message = helloService.sayHello();
        if (message != null) {
            System.out.println(message);
            return message.toUpperCase();
        }
        else {
            return "";
        }
    }

}
