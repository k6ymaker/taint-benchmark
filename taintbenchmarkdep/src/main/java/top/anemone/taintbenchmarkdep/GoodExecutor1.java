package top.anemone.taintbenchmarkdep;

import java.io.IOException;

public class GoodExecutor1 implements Executor {
    private String cmd;
    public void setcmd(String s) {
        cmd=s;
    }

    public String getcmd() {
        return cmd;
    }

    public Process exe(String exe) throws IOException {
        return Runtime.getRuntime().exec("ls");
    }
}
