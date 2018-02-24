package spring.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 执行类
 */
@Service
public class AsyncService {
    @Async
    public  void executeTask(Integer i){
        System.out.println("执行异步："+ i);
    }
    @Async
    public  void executeTaskPius(Integer i){
        System.out.println("执行异步任务＋1:"+i);
    }
}
