package spring.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduleTaskService {
    private static final SimpleDateFormat data=new
            SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 5000)
    public  void reportCurrentTime(){
        System.out.println("每5秒执行一次:"+data.format(new Date()));
    }
    @Scheduled(cron =  "0 24 14 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间"+data.format(new Date()));
    }
}
