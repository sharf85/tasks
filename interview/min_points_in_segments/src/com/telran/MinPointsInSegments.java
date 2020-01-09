package com.telran;

import java.util.Collections;
import java.util.List;

public class MinPointsInSegments {

    public int getMinPointsNumber(List<Segment> segments) {
        Collections.sort(segments);

        int res = 1;
        double nextPoint = segments.get(0).right;

        for (Segment segment : segments) {
            if (segment.left > nextPoint) {
                res++;
                nextPoint = segment.right;
            } else if (segment.right < nextPoint) {
                nextPoint = segment.right;
            }
        }

        return res;
    }
}
