package edu.umb.CS680.HW12;

import edu.umb.CS680.HW12.fs.Directory;
import edu.umb.CS680.HW12.fs.FSElement;
import edu.umb.CS680.HW12.fs.File;
import edu.umb.CS680.HW12.fs.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.umb.CS680.HW12.fs.Link;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseAlphabeticalComparatorTest {
    FileSystem FS;

    @BeforeEach
    public void setUp() {
        FS = TestFixtureInitializer.createFS();
    }
   @Test
     public void Test_getChildren() {
        FSElement[] expected = {
            ((Link)FS.getRootDirs().get(0).getChildren().get(4)),
            FS.getRootDirs().get(0).getFiles().get(0),
            FS.getRootDirs().get(0).getSubDirectories().get(2),
            FS.getRootDirs().get(0).getSubDirectories().get(0),  
            FS.getRootDirs().get(0).getSubDirectories().get(1),         
           };
           Directory directory = FS.getRootDirs().get(0);
        List<FSElement> fse = directory.getChildren(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,fse.toArray() );
    }

    @Test
    public void Test_getFiles() {
       File[] expected = { 
            FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1),
            FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0),      
           };
        Directory directory = FS.getRootDirs().get(0).getSubDirectories().get(0);
        List<File> file = directory.getFiles(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,file.toArray());
    }

    @Test
    public void Test_getSubDirectories() {
        Directory[] expected = {FS.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0)};
        Directory directory = FS.getRootDirs().get(0).getSubDirectories().get(2);
        List<Directory> dir = directory.getSubDirectories(new ReverseAlphabeticalComparator());
        assertArrayEquals(expected,dir.toArray() );
    }





}