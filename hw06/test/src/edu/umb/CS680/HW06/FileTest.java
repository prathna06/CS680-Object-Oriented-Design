package edu.umb.CS680.HW06;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    FileSystem FS;
    @BeforeEach
    public void setUp() {
  FS = TestFixtureInitializer.createFS();

    }
   

    private String[] fileToStringArray(File file){
        String[] file_Info = {
            String.valueOf(file.isFile()),
            file.getName(),
            String.valueOf(file.getSize()),
            (file.getParent() != null)? String.valueOf(file.getParent().getName()) : null,
            String.valueOf(file.getCreationTime())
        };
        return file_Info;
    }
    @Test
    public void verifyEqualityForFileX(){
        String[] expected = new String[]{"true", "x", "1", "prjRoot", String.valueOf(TestFixtureInitializer.ldt)};
        File actual = FS.getRootDirs().get(0).getFiles().get(0);
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileA(){
        String[] expected = new String[]{"true", "a", "1", "src", String.valueOf(TestFixtureInitializer.ldt)};
        File actual = FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0);
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileB() {
        String[] expected = new String[]{"true", "b", "1", "src", String.valueOf(TestFixtureInitializer.ldt)};
        File actual = FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1);
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileC(){
        String[] expected = new String[]{"true", "c", "1", "lib", String.valueOf(TestFixtureInitializer.ldt)};
        File actual = FS.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0);
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileD(){
        String[] expected = new String[]{"true", "d", "1", "src", String.valueOf(TestFixtureInitializer.ldt)};
        File actual = FS.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0).getFiles().get(0);
        assertArrayEquals(expected, fileToStringArray(actual));
    }
    

}
