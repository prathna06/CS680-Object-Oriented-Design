package edu.umb.CS680.HW09;

import org.junit.jupiter.api.Test;

public class ModelXYZTest {
    @Test
    public void checkingXYZwithoutloggingin()
    {
        String pwd = "pwd";
        String username = "prathna";
        User user = new User(username, pwd);
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor ModelXYZ= new ModelXYZ();
        ctx.login(pwd);
        PrintJob job = new PrintJob();
        ModelXYZ.execute(job, pwd,ctx);
    }
}
