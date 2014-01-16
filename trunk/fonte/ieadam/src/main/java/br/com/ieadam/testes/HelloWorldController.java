package br.com.ieadam.testes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class HelloWorldController {
 
    @Autowired
    private HelloWorld helloWorld;
     
    @RequestMapping(value="/helloWorld", method=RequestMethod.GET)
    public void helloWorld() {
        helloWorld.setMessage("Hello World from Spring MVC to JSF");
    }
    @RequestMapping(value="/helloWorld", method=RequestMethod.POST)
    public void helloWorldPost(@RequestParam String msg) {
        helloWorld.setMessage(msg);
    }
}
