
package edu.umb.CS680.HW08.fs.util;

import edu.umb.CS680.HW08.TestFixtureInitializer;

import edu.umb.CS680.HW08.fs.File;
import edu.umb.CS680.HW08.fs.FileSystem;

import edu.umb.CS680.HW08.fs.util.FileSearchVisitor;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class FileSearchVisitorTest {
    FileSystem FS;
    @BeforeEach
    public void setUp() {
        FS = TestFixtureInitializer.createFS();

    }

    @Test
    public void acceptForSizeTest() {
        FileSearchVisitor visitor = new FileSearchVisitor("a");

        FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).accept(visitor);
        visitor.setFileName("b");
        FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1).accept(visitor);
        visitor.setFileName("c");
        FS.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0).accept(visitor);
        assertSame(3, visitor.getFoundFiles().size());
    }

}
/* /* 
    @Test
    public void acceptToLocateMultipleFileTest() {

        LinkedList<File> expected = new LinkedList<File>();
        expected.add(FS.getRootDirs().get(0).getFiles().get(0));
       // expected.add(FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1));

        Object[] exp = expected.toArray();

        FileSearchVisitor visitor = new FileSearchVisitor("x");
        FS.getRootDirs().get(0).accept(visitor);
  /*       visitor.setFileName("b");
        FS.getRootDirs().get(0).accept(visitor); */
      /*   LinkedList<File> actual = visitor.getFoundFiles();

        Object[] act = actual.toArray();
        assertEquals(exp, act);
     } */

