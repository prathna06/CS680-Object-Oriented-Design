package edu.umb.CS680.HW05;

import org.junit.jupiter.api.Test;

public class ModelABCTest {


    @Test
    public void verifyingABCwithoutLogginIn(){
        String pwd = "pwd";
        String username = "prathna06";
        User user = new User(username, pwd);
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor ModelABC= new ModelABC();
        PrintJob job = new PrintJob();
        ModelABC.execute(job, pwd,ctx);
    }
    @Test
    public void verifyingABCWithLogginIn(){
        String pwd = "pwd";
        String username = "prathna06";
        User user = new User(username, pwd);
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd);
        PrintJobExecutor ModelABC= new ModelABC();
        PrintJob job = new PrintJob();
        ModelABC.execute(job, pwd,ctx);
    }

}

