package spring.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 需要注入的bean
 */
@Service
public class DemoService {
    @Value("其他属性")//注入其他字符串
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
