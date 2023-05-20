package edu.umb.CS680.HW14;

import edu.umb.CS680.HW14.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void Test_getChildrenRevAlphabet() {
        FSElement[] expected = {
            ((Link)FS.getRootDirs().get(0).getChildren().get(4)),
            FS.getRootDirs().get(0).getFiles().get(0),
            FS.getRootDirs().get(0).getSubDirectories().get(2),
            FS.getRootDirs().get(0).getSubDirectories().get(0),  
            FS.getRootDirs().get(0).getSubDirectories().get(1),         
           };
           Directory directory = FS.getRootDirs().get(0);
        List<   FSElement> fse = directory.getChildren((FSElement o1, FSElement o2) -> o2.getName().compareTo(o1.getName()));
        assertArrayEquals(expected,fse.toArray() );
    }

    @Test
    public void Test_getFilesRevAlphabet() {
        File[] expected = { 
            FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1),
            FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0),      
           };
        Directory directory = FS.getRootDirs().get(0).getSubDirectories().get(0);
        List<   File> file = directory.getFiles((FSElement o1, FSElement o2) -> o2.getName().compareTo(o1.getName()));
        assertArrayEquals(expected,file.toArray());
    }

    @Test
    public void Test_getSubDirectoriesRevAlphabet() {
        Directory[] expected = {FS.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0)};
        Directory directory = FS.getRootDirs().get(0).getSubDirectories().get(2);
        List<Directory> dir = directory.getSubDirectories((FSElement o1, FSElement o2) -> o2.getName().compareTo(o1.getName()));
        assertArrayEquals(expected,dir.toArray() );
    }




}