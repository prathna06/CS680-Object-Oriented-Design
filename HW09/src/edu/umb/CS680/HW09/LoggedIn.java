package edu.umb.CS680.HW09;

public class LoggedIn implements State {

    private static LoggedIn instance = null;
    private LoggedIn() { }

    public static LoggedIn getInstance() {
        if(instance == null) {
            instance = new LoggedIn();
        }
        return instance;
    }

    @Override
    public void login(SecurityContext ctx, String pwd) {
        boolean isActive = ctx.getIsActive();
        if (!isActive){
            ctx.logout();
            ctx.login(pwd);
        }
    }

    @Override
    public void logout(SecurityContext ctx){
        ctx.changeState(LoggedOut.getInstance());
    }
}
