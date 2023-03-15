package edu.umb.CS680.HW04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {
    @Test
    public void verifyLoggedIn(){
        String user = "Prathna06";
        String password = "password#0123";
        User user1 = new User(user,password);
        SecurityContext ctx=new SecurityContext(user1);
        assertTrue(ctx.getState() instanceof LoggedOut);
        ctx.login(password);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void verifyLoggedOut(){
        String user = "Prathna06";
        String password = "password#0123";
        User user1 = new User(user,password);
        SecurityContext ctx=new SecurityContext(user1);
        ctx.login(password);
        assertEquals(true,ctx.getState() instanceof LoggedIn);
    }
}
