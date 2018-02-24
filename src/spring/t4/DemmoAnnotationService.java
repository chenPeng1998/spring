package spring.t4;

import org.springframework.stereotype.Service;

/**
 * 编写使用注解的被拦截类
 */
@Service
public class DemmoAnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add(){}
}
