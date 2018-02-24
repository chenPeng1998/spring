package spring.t2;

import org.springframework.stereotype.Service;

@Service
public class CaculateBean {
    public int add(int a,int b){
        return a+b;
    }
    public int cut(int a,int b){
        return a-b;
    }
    public int min(int a,int b){
       return a<b?a:b;
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
}
