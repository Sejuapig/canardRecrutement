package canard.esport.recrutement.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainService {
    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public void greeting() {
        System.out.println(template);
    }

    public int calculStats(){
        return 0;
    }
}
