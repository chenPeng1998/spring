package spring.condition;

public class WindowsService implements  ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
