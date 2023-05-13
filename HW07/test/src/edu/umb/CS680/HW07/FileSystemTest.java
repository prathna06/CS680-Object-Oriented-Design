package edu.umb.CS680.HW07;

import org.junit.jupiter.api.*;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    private Directory root;

    @BeforeEach
    public void setUp() {
  
        root = new Directory(null, "prjRoot", 0, TestFixtureInitializer.ldt);
    }


    private Directory[] LinkedListToArray(LinkedList<Directory> r_List) {
        Directory[] rootArr = new Directory[r_List.size()];
        int i = 0;
        for (Directory root : r_List) {
            rootArr[i++] = root;
        }
        return rootArr;
    }


    @Test
    public void getRootDirectoryTest() {
        var fs = FileSystem.getFileSystem();
        Directory[] expected = {};
      var actual = this.LinkedListToArray(fs.getRootDirs());
        assertArrayEquals(expected, actual);
    }


    @Test
    public void checkGetFileSystemTest() {
        var fileA = FileSystem.getFileSystem();
        var fileB = FileSystem.getFileSystem();
        assertSame(fileA, fileB);
    }

    @Test
    public void addRootDirectoryTest() {
        var fs = FileSystem.getFileSystem();
        fs.appendRootDirs(root);
        LinkedList<Directory> getRootDirc = fs.getRootDirs();

        Directory[] expected = { root };
        Directory[] actual = this.LinkedListToArray(getRootDirc);
        assertArrayEquals(expected, actual);
    }

}
