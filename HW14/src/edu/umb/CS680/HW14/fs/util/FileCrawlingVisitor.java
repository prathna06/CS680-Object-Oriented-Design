package edu.umb.CS680.HW14.fs.util;
import java.util.LinkedList;

import edu.umb.CS680.HW14.fs.Directory;
import edu.umb.CS680.HW14.fs.FSVisitor;
import edu.umb.CS680.HW14.fs.File;
import edu.umb.CS680.HW14.fs.Link;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files = new LinkedList<File>();

    public LinkedList<File> getFile() {
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