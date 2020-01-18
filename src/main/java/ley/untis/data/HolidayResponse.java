package ley.untis.data;

import java.util.ArrayList;

public class HolidayResponse extends ArrayList<HolidayResponse.Holiday> {

    public static class Holiday {
        public int id;
        public String name;
        public String longName;
        public int startDate;
        public int endDate;
    }

}
