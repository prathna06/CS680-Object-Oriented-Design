package edu.umb.CS680.HW06;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size; //Should be zero for a directory
    protected LocalDateTime creationTime;
    public Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent(){
        return this.parent;
    }
    public String getName() {
        return this.name;
    }
    public int getSize() {
        return this.size;
    }
    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
            this.size = size;

    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();

        Directory root = new Directory(null,"root", 0, ldt);
        Directory Apps = new Directory(root,"Apps", 0, ldt);
        Directory lib = new Directory(root,"lib", 0, ldt);
        Directory home = new Directory(root,"home", 0, ldt);

        root.appendChild(Apps);
        root.appendChild(lib);
        root.appendChild(home);

        int count = root.countChildren();
        System.out.println("Children count:"+count);
    }


}