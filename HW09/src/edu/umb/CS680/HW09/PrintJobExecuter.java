package edu.umb.CS680.HW09;


abstract class PrintJobExecutor {
    public final void execute(PrintJob job, String pwd, SecurityContext ctx) {
        {
            doAuthentication(pwd, ctx);
            doAccessControl();
            doPrint(job, ctx);
            doErrorHandling();
        }
    }
    protected abstract void doAuthentication(String password, SecurityContext ctx);
    protected abstract void doAccessControl();
    protected abstract void doPrint(PrintJob job, SecurityContext ctx);
    protected abstract void doErrorHandling();
}

class ModelXYZ extends PrintJobExecutor {

    @Override
    protected void doAuthentication(String password, SecurityContext ctx) {

    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx) {
        job.printer(job);
    }

    @Override
    protected void doErrorHandling() {

    }
}

class ModelABC extends PrintJobExecutor{

    @Override
    protected void doAuthentication(String password, SecurityContext ctx) {
        if(Authenticator.authenticate(ctx, password)){
            System.out.println("User successfully Authenticated");
        } else{
            try {
                throw new Exception("User Authentication Failed");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx) {
        if(ctx.getState() instanceof LoggedIn){
            System.out.println("User is LoggedIn in the system");
            job.printer(job);
        } else{
            System.out.println("User not LoggedIn in the system");
        }
    }

    @Override
    protected void doErrorHandling() {

    }
}