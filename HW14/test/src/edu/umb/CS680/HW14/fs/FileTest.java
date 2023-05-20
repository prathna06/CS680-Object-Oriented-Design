package edu.umb.CS680.HW14.fs;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.CS680.HW14.fs.Directory;
import edu.umb.CS680.HW14.fs.File;
import edu.umb.CS680.HW14.fs.Link;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {


    static private LocalDateTime ldt = LocalDateTime.now();

    static Directory root = new Directory(null,"root", 0, ldt);

    static Directory Apps = new Directory(root,"Apps", 0, ldt);
    static File file_x = new File(Apps,"x",1,ldt);

    static Directory bin = new Directory(root,"bin", 0, ldt);
    static  File file_y = new  File(bin,"y",1,ldt);

    static Directory home = new Directory(root,"home", 0, ldt);
    static  File file_c = new  File(home,"c",1,ldt);

    static Directory pictures = new Directory(home,"pictures", 0, ldt);
    static  File file_a = new  File(pictures,"a",1,ldt);
    static  File file_b = new  File(pictures,"b",1,ldt);

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


    private String[] fileToStringArray(File file){
        String[] file_Info = {
                String.valueOf(file.isDirectory()),
                file.getName(),
                String.valueOf(file.getSize()),
                (file.getParent() != null)? String.valueOf(file.getParent().getName()) : null,
                String.valueOf(file.getCreationTime())
        };
        return file_Info;
    }

    @Test
    public void verifyEqualityForFileX(){
        String[] expected = new String[]{"false","x", "1","Apps",String.valueOf(ldt)};
        File actual = file_x;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileY() {
        String[] expected = new String[]{"false","y", "1","bin",String.valueOf(ldt)};
        File actual = file_y;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileA(){
        String[] expected = new String[]{"false","a", "1","pictures",String.valueOf(ldt)};
        File actual = file_a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityForFileC(){
        String[] expected = new String[]{"false","c", "1","home",String.valueOf(ldt)};
        File actual = file_c;
        assertArrayEquals(expected, fileToStringArray(actual));
    }



}