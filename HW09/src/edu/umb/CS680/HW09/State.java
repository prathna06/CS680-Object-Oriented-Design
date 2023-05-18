package edu.umb.CS680.HW09;

public interface State {
    public void login(SecurityContext ctx, String pwd);
    public void logout(SecurityContext ctx);

}
