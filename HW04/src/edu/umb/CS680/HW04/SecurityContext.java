package edu.umb.CS680.HW04;

public class SecurityContext {
    private State currentState;

    public SecurityContext(User user) {
        this.currentState = new LoggedOut(this);
    }

    public void changeState(State newState){
        this.currentState = newState;
    }

    public void login(String password){
        this.currentState.login(this, password);
    }

    public void logout(){
        this.currentState.logout(this);
    }

    public boolean isActive(){
        if (this.currentState instanceof LoggedIn){
            return true;
        }
        return false;
    }

    public State getState() {
        return this.currentState;
    }

    public static void main(String[] args) {
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


