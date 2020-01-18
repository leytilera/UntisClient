package ley.untis.data;

import java.util.ArrayList;

public class TimegridResponse extends ArrayList<TimegridResponse.Day> {

    public static class Day {
        public int day;
        public TimeUnit[] timeUnits;
        public static class TimeUnit {
            public int startTime;
            public int endTime;
            public String name;
        }
    }

}
