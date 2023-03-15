package edu.umb.CS680.HW05;

public class SecurityContext {

    private User user;

    private static State state;

    private Boolean isActive;

    public SecurityContext(User user){
        this.user = user;
        this.isActive = false;
        this.state = LoggedOut.getInstance();
    }

    public void changeState(State new_state){
        SecurityContext.state = new_state;
    }

    public void login(String pwd) {
        try {
            state.login(this, pwd);
//        return false;
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void logout(){
        state.logout(this);
    }

    public Boolean getIsActive(){
        return this.isActive;
    }

    public static State getState() {
        return state;
    }

    public User getUser(){
        return user;
    }

    public static void main(String[] args){
        String user = "abc";
        String pwd = "asasd";
        User userObj = new User(user, pwd);
        SecurityContext ctx = new SecurityContext(userObj);
        ctx.login("asasd");
        System.out.println(ctx.getState() instanceof LoggedIn);
        ctx.logout();
        System.out.println(ctx.getState() instanceof  LoggedIn);
    }

}