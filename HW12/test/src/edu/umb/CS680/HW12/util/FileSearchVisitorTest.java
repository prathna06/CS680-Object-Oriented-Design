
package edu.umb.CS680.HW12.util;

import edu.umb.CS680.HW12.*;



import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;



class FileSearchVisitorTest {

    /* static private LocalDateTime ldt = LocalDateTime.now();

    static Directory root = new Directory(null,"root", 0, ldt);

    static Directory Apps = new Directory(root,"Apps", 0, ldt);
    static File x = new File(Apps,"x",1,ldt);

    static Directory bin = new Directory(root,"bin", 0, ldt);
    static File y = new File(bin,"y",19,ldt);

    static Directory home = new Directory(root,"home", 0, ldt);
    static File c = new File(home,"c",1,ldt);

    static Directory pictures = new Directory(home,"pictures", 0, ldt);
    static File a = new File(pictures,"a",1,ldt);
    static File b = new File(pictures,"b",1,ldt);

    static Link link_d = new Link(root, "d", 6, ldt, pictures);
    static Link link_e = new Link(root, "e", 6, ldt, x);

    @BeforeAll
    static void createFS() {
        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(link_d);
        root.appendChild(link_e);

        Apps.appendChild(x);

        bin.appendChild(y);

        home.appendChild(pictures);
        home.appendChild(c);

        pictures.appendChild(a);
        pictures.appendChild(b);
 */

 FileSystem FS;

 @BeforeEach
 public void setUp() {
     FS = TestFixtureInitializer.createFS();


    }
    @Test
    public void testAcceptForSize(){
        FileSearchVisitor visitor = new FileSearchVisitor("a");
        FS.getRootDirs().get(0).getFiles().get(0).accept(visitor);
        visitor.setFileName("b");
        FS.getRootDirs().get(0).getFiles().get(0).accept(visitor);
        visitor.setFileName("c");
        FS.getRootDirs().get(0).getFiles().get(0).accept(visitor);
        assertSame(3,visitor.getFoundFiles().size());
    }
@Test


    @Test
    public void testAcceptToLocateMultipleFile(){

        LinkedList<File> expected = new LinkedList<File>();
        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0));
        expected.add(FS.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1));

        Object[] exp = expected.toArray();

        FileSearchVisitor visitor = new FileSearchVisitor("a");
        FS.getRootDirs().get(0).getFiles().get(0).accept(visitor);
        visitor.setFileName("b");
        FS.getRootDirs().get(0).getFiles().get(0).accept(visitor);
        LinkedList<File> actual = visitor.getFoundFiles();

        Object[] act = actual.toArray();
        assertEquals(exp, act);

    }
}
