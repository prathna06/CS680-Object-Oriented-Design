package edu.umb.CS680.HW14;

import edu.umb.CS680.HW14.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        List<FSElement> fse = directory.getChildren((FSElement o1, FSElement o2) -> o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertArrayEquals(expected,fse.toArray() );
    }

    @Test
    public void Test_getFilesTime() {
        var baseDirc = FS.getRootDirs().get(0).getSubDirectories().get(0);
        File[] expected = {baseDirc.getFiles().get(0),
                           baseDirc.getFiles().get(1)};
        List<File> file = baseDirc.getFiles((FSElement o1, FSElement o2) -> o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertArrayEquals(expected,file.toArray());
    }

    @Test
    public void Test_getSubDirectoriesTime() {
        Directory[] expected = {FS.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0)};
        Directory directory = FS.getRootDirs().get(0).getSubDirectories().get(2);
        List<Directory> dir = directory.getSubDirectories((FSElement o1, FSElement o2) -> o2.getCreationTime().compareTo(o1.getCreationTime()));
        assertArrayEquals(expected,dir.toArray() );
    }

    }
