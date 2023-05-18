package edu.umb.CS680.HW09;

import org.junit.jupiter.api.Test;

public class ModelABCTest {


    @Test
    public void checkABCwithoutLogginIn(){
        String pwd = "pwd";
        String username = "prathana6";
        User user = new User(username, pwd);
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor ModelABC= new ModelABC();
        PrintJob job = new PrintJob();
        ModelABC.execute(job, pwd,ctx);
    }
    @Test
    public void checkABCWithLogginIn(){
        String pwd = "pwd";
        String username = "prathana6";
        User user = new User(username, pwd);
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd);
        PrintJobExecutor ModelABC= new ModelABC();
        PrintJob job = new PrintJob();
        ModelABC.execute(job, pwd,ctx);
    }

}

