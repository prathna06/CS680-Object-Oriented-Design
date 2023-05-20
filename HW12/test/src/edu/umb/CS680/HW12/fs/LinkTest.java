package edu.umb.CS680.HW12.fs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {


    static private LocalDateTime ldt = LocalDateTime.now();

    static Directory root = new Directory(null,"root", 0, ldt);

    static Directory Apps = new Directory(root,"Apps", 0, ldt);
    static File file_x = new File(Apps,"x",1,ldt);

    static Directory bin = new Directory(root,"bin", 0, ldt);
    static File file_y = new File(bin,"y",1,ldt);

    static Directory home = new Directory(root,"home", 0, ldt);
    static File file_c = new File(home,"c",1,ldt);

    static Directory pictures = new Directory(home,"pictures", 0, ldt);
    static File file_a = new File(pictures,"a",1,ldt);
    static File file_b = new File(pictures,"b",1,ldt);

    static Link link_d = new Link(root, "d", 6, ldt, pictures);
    static Link link_e = new Link(root, "e", 6, ldt, file_x);

    @BeforeAll
    static void createFS() {
        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(link_d);
        root.appendChild(link_e);

        Apps.appendChild(file_x);

        bin.appendChild(file_y);

        home.appendChild(pictures);
        home.appendChild(file_c);

        pictures.appendChild(file_a);
        pictures.appendChild(file_b);

    }


    @Test
    public void verifyEqualityForLinkD() {
        Directory expected = pictures;
        FSElement actual = link_d.getTarget();
        assertSame(expected, actual);
    }

    @Test
    public void verifyEqualityForLinkE() {
        File expected = file_x;
        FSElement actual = link_e.getTarget();
        assertSame(expected, actual);
    }

    @Test
    public void testTargetSizeforlinkD(){
        assertEquals(0,link_d.TargetSize());
    }

    @Test
    public void testTargetSizeforlinkE(){
        assertEquals(1,link_e.TargetSize());
    }


}