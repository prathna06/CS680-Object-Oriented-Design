package edu.umb.CS680.HW14.fs;


import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.CS680.HW14.fs.Directory;
import edu.umb.CS680.HW14.fs.File;
import edu.umb.CS680.HW14.fs.Link;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

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


    private String[] dirToStringArray(Directory d){

        String[] dirInfo = {
                String.valueOf(d.isLink()),
                d.getName(),
                String.valueOf(d.getSize()),
                (d.getParent() != null)? String.valueOf(d.getParent().getName()) : null,
                String.valueOf(d.getCreationTime()),
                String.valueOf(d.countChildren()),

        };
        return dirInfo;
    }

    @Test
    public void verifyEqualityForDirectoryRoot(){
        String[] expected = new String[]{"false","root", "0",null,String.valueOf(ldt),"5"};
        Directory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryApps (){
        String[] expected = new String[]{"false","Apps", "0","root",String.valueOf(ldt),"1"};
        Directory actual = Apps;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryBin (){
        String[] expected = new String[]{"false","bin", "0","root",String.valueOf(ldt),"1"};
        Directory actual = bin;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryHome () {
        String[] expected = new String[]{"false","home", "0","root",String.valueOf(ldt),"2"};
        Directory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void testGetTotalSizeforRoot(){
        assertEquals(5,root.getTotalSize());
    }

    @Test
    public void testGetTotalSizeforhome(){
        assertEquals(3,home.getTotalSize());
    }

    @Test
    public void testGetTotalSizeforBin(){
        assertEquals(1,bin.getTotalSize());
    }

    @Test
    public void testGetTotalSizeforApps(){
        assertEquals(1,Apps.getTotalSize());
    }


}