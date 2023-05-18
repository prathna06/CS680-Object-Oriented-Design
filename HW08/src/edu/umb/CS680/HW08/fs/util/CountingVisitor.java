package edu.umb.CS680.HW08.fs.util;

import edu.umb.CS680.HW08.fs.Directory;
import edu.umb.CS680.HW08.fs.FSVisitor;
import edu.umb.CS680.HW08.fs.File;
import edu.umb.CS680.HW08.fs.Link;

public class CountingVisitor implements FSVisitor{

    int fileNum = 0;
    int linkNum = 0;
    int dirNum = 0;

    @Override
    public void visit(Link link) {
        linkNum = linkNum + 1;
    }

    @Override
    public void visit(Directory dir) {
        dirNum = dirNum + 1;
    }

    @Override
    public void visit(File file) {
        fileNum = fileNum + 1;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }

    public int getDirNum() {
        return dirNum;
    }

}