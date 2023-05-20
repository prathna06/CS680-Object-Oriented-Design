package edu.umb.CS680.HW12;

import edu.umb.CS680.HW12.TimeStampComparator;
import edu.umb.CS680.HW12.fs.Directory;
import edu.umb.CS680.HW12.fs.FSElement;
import edu.umb.CS680.HW12.fs.File;
import edu.umb.CS680.HW12.fs.FileSystem;
import edu.umb.CS680.HW12.fs.Link;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampComparatorTest {

    FileSystem FS;

    @BeforeEach
    public void setUp() {
        FS = TestFixtureInitializer.createFS();
    }


    @Test
    public void Test_getChildren() {
        FSElement[] expected = {FS.getRootDirs().get(0).getSubDirectories().get(0),
            FS.getRootDirs().get(0).getSubDirectories().get(1),
            FS.getRootDirs().get(0).getSubDirectories().get(2),
            FS.getRootDirs().get(0).getFiles().get(0),
            ((Link)FS.getRootDirs().get(0).getChildren().get(4))};
        Directory directory = FS.getRootDirs().get(0);
        List<FSElement> fse = directory.getChildren(new TimeStampComparator());
        assertArrayEquals(expected,fse.toArray() );
    }

    @Test
    public void Test_getFiles() {
        var baseDirc = FS.getRootDirs().get(0).getSubDirectories().get(0);
        File[] expected = {baseDirc.getFiles().get(0),
                           baseDirc.getFiles().get(1)};
        List<File> file = baseDirc.getFiles(new TimeStampComparator());
        assertArrayEquals(expected,file.toArray());
    }

  @Test
    public void Test_getSubDirectories() {
        Directory[] expected = {FS.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0)};
        Directory directory = FS.getRootDirs().get(0).getSubDirectories().get(2);
        List<Directory> dir = directory.getSubDirectories(new TimeStampComparator());
        assertArrayEquals(expected,dir.toArray() );
    } 

}