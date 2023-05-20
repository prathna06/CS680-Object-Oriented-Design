package edu.umb.CS680.HW12;



import java.util.Comparator;

import edu.umb.CS680.HW12.fs.*;
public class AlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o1.getName().compareTo(o2.getName());
    }
}