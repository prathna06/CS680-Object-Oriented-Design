package edu.umb.CS680.HW12;

import edu.umb.CS680.HW12.fs.*;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getName().compareTo(o1.getName());
    }
}