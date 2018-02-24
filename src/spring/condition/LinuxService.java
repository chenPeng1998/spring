package spring.condition;

public class LinuxService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
