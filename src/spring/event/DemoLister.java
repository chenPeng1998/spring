package spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 */
@Component
public class DemoLister implements ApplicationListener<DemoEvent>{
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("我 [DemoLister－bean] 接收到了 bean－demoPublish发布的消息 ："+demoEvent.getMsg());
    }
}
