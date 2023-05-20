package edu.umb.CS680.HW12;
import edu.umb.CS680.HW12.fs.FSElement;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return (o1.getSize()-o2.getSize());
    }
}