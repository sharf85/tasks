package com.telran;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkingTimeServiceTest {


    WorkingTimeService ds = new WorkingTimeService();

    @Test
    public void getInterval_NY_Moscow() {
        int startPeter = 9;
        int endPeter = 18;
        String peterZone = "Europe/Moscow";

        int startNY = 8;
        int endNY = 17;
        String nyZone = "America/New_York";

        assertEquals(3, ds.getCommonInterval(startPeter, endPeter, peterZone, startNY, endNY, nyZone));
        assertEquals(3, ds.getCommonInterval(startNY, endNY, nyZone, startPeter, endPeter, peterZone));
    }

    @Test
    public void getInterval_Cal_Vlad() {
        int startVlad = 9;
        int endVlad = 18;
        String vladZone = "Asia/Vladivostok";

        int startCal = 8;
        int endCal = 17;
        String calZone = "America/Los_Angeles";

        assertEquals(1, ds.getCommonInterval(startVlad, endVlad, vladZone, startCal, endCal, calZone));
        assertEquals(1, ds.getCommonInterval(startCal, endCal, calZone, startVlad, endVlad, vladZone));
    }
}