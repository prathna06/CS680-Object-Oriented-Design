package edu.umb.CS680.HW08.fs.util;

import edu.umb.CS680.HW08.fs.Directory;
import edu.umb.CS680.HW08.fs.FSVisitor;
import edu.umb.CS680.HW08.fs.File;
import edu.umb.CS680.HW08.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files = new LinkedList<File>();

    public LinkedList<File> getFiles() {
        return files;
    }

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        files.add(file);
    }
}