package sk.stuba.fei.uim.oop.HelloString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello_string")
public class HelloStringController {

    @GetMapping("/{name}")
    public String helloName(@PathVariable(name = "name") String name) {
        return "hello " + name;
    }

    @GetMapping("/param")
    public String helloParam(@RequestParam(name = "name", defaultValue = "world") String name) {
        return "hello " + name;
    }

    @PostMapping("/body")
    public String helloBody(@RequestBody HelloStringRequestBody body) {
        return "hello " + body.getName();
    }

}
