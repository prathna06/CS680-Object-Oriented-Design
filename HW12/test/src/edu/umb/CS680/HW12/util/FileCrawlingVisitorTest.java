package edu.umb.CS680.HW12.util;

import edu.umb.CS680.HW12.*;
import edu.umb.CS680.HW12.TestFixtureInitializer;
import edu.umb.CS680.HW12.fs.File;
import edu.umb.CS680.HW12.fs.FileSystem;
import edu.umb.CS680.HW12.fs.util.FileCrawlingVisitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {
    FileSystem FS;
    @BeforeEach
    public void setUp() {
        FS = TestFixtureInitializer.createFS();

    }

    @Test
    public void testFilesInRoot() {
        LinkedList<File> expected = new LinkedList<File>();
        expected.add(FS.getRootDirs().get(0).getFiles().get(0));
       /*  expected.add(FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0));
        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1));
        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0));
        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0).getFiles().get(0));  */
        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        FS.getRootDirs().get(0).accept(visitor);
        LinkedList<File> actual = visitor.getFile();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInSrc() {
        LinkedList<File> expected = new LinkedList<File>();

        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0));
        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1));

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        FS.getRootDirs().get(0).getSubDirectories().get(0).accept(visitor);
        LinkedList<File> actual = visitor.getFile();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInLib() {
        LinkedList<File> expected = new LinkedList<File>();

        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0));

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        FS.getRootDirs().get(0).getSubDirectories().get(1).accept(visitor);
        LinkedList<File> actual = visitor.getFile();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

}