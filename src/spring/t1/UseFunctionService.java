package spring.t1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
    //使用功能性的bean
    @Autowired
    private FunctionService fs;
    public String sayHello(String word){
        return fs.sayHello(word);
    }
}
