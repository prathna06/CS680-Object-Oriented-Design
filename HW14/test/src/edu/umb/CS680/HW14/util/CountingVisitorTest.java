package edu.umb.CS680.HW14.util;
import edu.umb.CS680.HW14.TestFixtureInitializer;
import edu.umb.CS680.HW14.fs.*;
import edu.umb.CS680.HW14.fs.util.CountingVisitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {
    FileSystem FS;
    @BeforeEach
    public void setUp() {
        FS = TestFixtureInitializer.createFS();

    }
   

    @Test
    public void testDirectoriesForRoot() {
        CountingVisitor CV = new CountingVisitor();
        FS.getRootDirs().get(0).accept(CV);
        assertEquals(5,CV.getDirNum());
    }
    @Test
    public void testLinksForRoot() {
        CountingVisitor CV = new CountingVisitor();
        ((Link)FS.getRootDirs().get(0).getChildren().get(4)).accept(CV);
        assertEquals(1,CV.getLinkNum());
    }
    @Test
    public void testFilesForRoot() {
        CountingVisitor CV = new CountingVisitor();
        FS.getRootDirs().get(0).accept(CV);
        assertEquals(5,CV.getFileNum());
    }
    @Test
    public void testFilesForTest() {
        CountingVisitor CV = new CountingVisitor();
        FS.getRootDirs().get(0).getSubDirectories().get(2).accept(CV);
        assertEquals(1,CV.getFileNum());
    }
    @Test
    public void testDirectoriesForLib() {
        CountingVisitor CV = new CountingVisitor();
        FS.getRootDirs().get(0).getSubDirectories().get(1).accept(CV);
        assertEquals(1,CV.getDirNum());
    }
    @Test
    public void testFilesForLib() {
        CountingVisitor CV = new CountingVisitor();
        FS.getRootDirs().get(0).getSubDirectories().get(1).accept(CV);
        assertEquals(1,CV.getFileNum());
    }
}