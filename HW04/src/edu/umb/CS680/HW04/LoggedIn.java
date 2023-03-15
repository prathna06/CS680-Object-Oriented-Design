package edu.umb.CS680.HW04;

public class LoggedIn implements State {

    private SecurityContext ctx;

    private static LoggedIn single_instance = null;
    public LoggedIn(SecurityContext ctx){
        this.ctx = ctx;
    }

    private LoggedIn(){};

    public static LoggedIn getInstance()
    {
        if (single_instance == null)
            single_instance = new LoggedIn();

        return single_instance;
    }
    @Override
    public void login(SecurityContext ctx, String password) {
        if (!ctx.isActive()){
            ctx.changeState( LoggedOut.getInstance());
            ctx.login(password);
        }

    }


    @Override
    public void logout(SecurityContext ctx) {
        ctx.changeState(LoggedOut.getInstance());
    }
}
