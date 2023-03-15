package edu.umb.CS680.HW04;

public interface State {
    public void login(SecurityContext ctx, String password);
    public void logout(SecurityContext ctx);
}
