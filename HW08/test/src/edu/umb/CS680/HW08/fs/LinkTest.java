package edu.umb.CS680.HW08.fs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.CS680.HW08.TestFixtureInitializer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;

class LinkTest {

    FileSystem FS;

    @BeforeEach
    public void setUp() {
  FS = TestFixtureInitializer.createFS();


    }
    @Test
    public void verifyEqualityForLinkY() {
        Directory expected = TestFixtureInitializer.testSrc;
        FSElement actual = ((Link)FS.getRootDirs().get(0).getChildren().get(4)).getTarget();
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCreationTime(), actual.getCreationTime());
    }


    @Test
    public void testTargetSizeforlinkY(){
        assertEquals(0,((Link)FS.getRootDirs().get(0).getChildren().get(4)).TargetSize());
    }
    @AfterEach
    public void tearDown(){
        FS.resetFileSystem();
    }

}
