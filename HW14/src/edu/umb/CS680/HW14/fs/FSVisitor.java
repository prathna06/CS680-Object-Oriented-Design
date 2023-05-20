package edu.umb.CS680.HW14.fs;
public interface FSVisitor {

    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);

}

