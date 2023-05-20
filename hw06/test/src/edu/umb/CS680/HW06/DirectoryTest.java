package edu.umb.CS680.HW06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DirectoryTest {

FileSystem FS;
    @BeforeEach
    public void setUp() {
  FS=  TestFixtureInitializer.createFS();

    }

    private String[] dirToStringArray(Directory d){
        String[] dirInfo = {
                String.valueOf(d.isFile()),
                d.getName(),
                String.valueOf(d.getSize()),
                (d.getParent() != null)? String.valueOf(d.getParent().getName()) : null,
                String.valueOf(d.getCreationTime()),
                String.valueOf(d.countChildren()),
                String.valueOf(d.getTotalSize()),
        };
        return dirInfo;
    }

    @Test
    public void verifyEqualityForDirectoryRoot(){
        String[] expected = new String[]{"false","prjRoot", "0",null,String.valueOf(TestFixtureInitializer.ldt),"4","5"};
        Directory actual = FS.getRootDirs().get(0);
        assertArrayEquals(expected, dirToStringArray(actual));
    }
  
    @Test
    public void verifyEqualityForDirectorySrc () {
        String[] expected = new String[]{"false","src", "0","prjRoot",String.valueOf(TestFixtureInitializer.ldt),"2","2"};
        System.out.println(FS.getRootDirs().get(0).getSubDirectories());
        Directory actual = FS.getRootDirs().get(0).getSubDirectories().get(0);
       
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryLib (){
        String[] expected = new String[]{"false","lib", "0","prjRoot",String.valueOf(TestFixtureInitializer.ldt),"1","1"};
        Directory actual =FS.getRootDirs().get(0).getSubDirectories().get(1);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryTest (){
        String[] expected = new String[]{"false","test", "0","prjRoot",String.valueOf(TestFixtureInitializer.ldt),"1","1"};
        Directory actual = FS.getRootDirs().get(0).getSubDirectories().get(2);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectorytestSrc (){
        String[] expected = new String[]{"false","src", "0","test",String.valueOf(TestFixtureInitializer.ldt),"1","1"};
        Directory actual =FS.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0);
        assertArrayEquals(expected, dirToStringArray(actual));
    }
}
