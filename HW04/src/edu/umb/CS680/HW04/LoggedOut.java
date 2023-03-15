package edu.umb.CS680.HW04;

public class LoggedOut implements State {

    private SecurityContext ctx;
   private static LoggedOut single_instance = null;
    public LoggedOut(SecurityContext ctx){
        this.ctx = ctx;
    }

    private LoggedOut(){};

    public static LoggedOut getInstance()
    {
        if (single_instance == null)
            single_instance = new LoggedOut();

        return single_instance;
    }

    @Override
    public void login(SecurityContext ctx,String password) {
        if ( Authenticator.authenticate(ctx, password)){
            ctx.changeState(LoggedIn.getInstance());
        }
        else{
            System.out.println("Authentication Failed");
        }
    }

    @Override
    public void logout(SecurityContext ctx) {

    }
}
