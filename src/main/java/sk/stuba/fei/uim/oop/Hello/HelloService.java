package sk.stuba.fei.uim.oop.Hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public HelloResponse createResponse(HelloRequestBody body) {
        return new HelloResponse("Hello " + body.getName());
    }
}
