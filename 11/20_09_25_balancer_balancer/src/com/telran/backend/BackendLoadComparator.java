package com.telran.backend;

import java.util.Comparator;

public class BackendLoadComparator implements Comparator<BackendServerEntity> {
    @Override
    public int compare(BackendServerEntity o1, BackendServerEntity o2) {
        return Integer.compare(o1.getLoad(), o2.getLoad());
    }
}
