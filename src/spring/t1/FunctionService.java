package spring.t1;

import org.springframework.stereotype.Service;
@Service
public class FunctionService {
    //编写功能性的bean

    public String sayHello(String word){
        return "hello , "+word;
    }
}
