package edu.umb.CS680.HW06;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public static FileSystem fileSystem = FileSystem.getFileSystem();
    public static LocalDateTime ldt = LocalDateTime.now();
    public static FileSystem createFS() {
        if(fileSystem != null){
            fileSystem.resetFileSystem();
            fileSystem = FileSystem.getFileSystem();
        }
        var prjRoot = new Directory(null, "prjRoot", 0, ldt);
        var src = new Directory(prjRoot, "src", 0, ldt);
        var lib = new Directory(prjRoot, "lib", 0, ldt);
        var test = new Directory(prjRoot, "test", 0, ldt);
        var testSrc = new Directory(test, "src", 0, ldt);
        var a = new File(src, "a", 1, ldt);
        var b = new File(src, "b", 1, ldt);
        var c = new File(lib, "c", 1, ldt);
        var d = new File(testSrc, "d", 1, ldt);
        var x = new File(prjRoot, "x", 1, ldt);

        testSrc.appendChild(d);

        test.appendChild(testSrc);
        lib.appendChild(c);
        src.appendChild(a);
        src.appendChild(b);

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);
        fileSystem.appendRootDir(prjRoot);
        return fileSystem;

    }

}