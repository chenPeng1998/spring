package spring.t2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCaculateService {
    @Autowired
    private CaculateBean caculateBean;
    public int useCacu(int i,int a ,int b){
        switch (i){
            case 0:return caculateBean.add(a,b);

            case 1:return caculateBean.cut(a,b);

            case 2:return caculateBean.max(a,b);

            case 3:return caculateBean.min(a,b);

            default:
                return -1;

        }
    }
}
