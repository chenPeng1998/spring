package spring.t4;

import java.lang.annotation.*;

/**
 * 编写拦截规则的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
