package spring.t3;

public class UserFunctionService {
    FuncService funcService;

    public void setFuncService(FuncService funcService) {
        this.funcService = funcService;
    }
    public  String SayHello(String word){
        return  funcService.sayHello(word);
    }
}
