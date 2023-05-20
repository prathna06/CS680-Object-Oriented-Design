package edu.umb.CS680.HW12;


import edu.umb.CS680.HW12.fs.FSElement;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getCreationTime().compareTo(o1.getCreationTime());
    }
}