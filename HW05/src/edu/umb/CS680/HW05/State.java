package edu.umb.CS680.HW05;

public interface State {
    public void login(SecurityContext ctx, String pwd);
    public void logout(SecurityContext ctx);

}
