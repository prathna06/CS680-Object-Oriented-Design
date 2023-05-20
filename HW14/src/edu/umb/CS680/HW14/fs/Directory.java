package edu.umb.CS680.HW14.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

// import edu.umb.CS680.HW12.AlphabeticalCamparator;

public class Directory extends FSElement {

    public LinkedList<FSElement> children = new LinkedList<FSElement>();
    public int totalSize;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) { //constructor
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren() { //getter
        System.out.println(this.children);
        return this.children;
    }
    
    public LinkedList<Directory> getSubDirectories() { //getter
        LinkedList<Directory> SubDirectories = new LinkedList<Directory>();
        for (FSElement fs : children) {
            if (fs.isDirectory()) {
                SubDirectories.add((Directory) fs);
            }
        }
        return SubDirectories;
    }
    
    public LinkedList<File> getFiles() { //getter
        LinkedList<File> Files = new LinkedList<File>();
        for (FSElement fs : children) {
            if (fs.isFile()) {
                Files.add((File) fs);
            }
        }
        return Files;
    }
    
    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator){
        children = getChildren();
        Collections.sort(children, comparator);
        return children;
    }
    
    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator){
      var  SubDirectories = getSubDirectories();
        Collections.sort(SubDirectories, comparator);
        return SubDirectories;
    
    }
    
    public LinkedList<File> getFiles(Comparator<FSElement> comparator){
       var Files = getFiles();
        Collections.sort(Files, comparator);
        return Files;
    
    }
    
    public void appendChild(FSElement child){ //public method
            this.children.add(child);
    }

    public int countChildren(){ //public method
        return this.children.size();
    }

    public int getTotalSize() { //public method
        totalSize=0;
        for (FSElement fse : children) {
            if (fse.isDirectory()) {
                totalSize = totalSize + ((Directory) fse).getTotalSize();
            } else {
                totalSize = totalSize + fse.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() { //public method

        return true;
    }

    @Override
    public boolean isFile() { //public method

        return false;
    }

    @Override
    public boolean isLink() { //public method

        return false;
    }
    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement fse: children){
            fse.accept(v);
        }
    }




}