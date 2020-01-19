package ley.untis.data;

import java.util.ArrayList;

public class TimetableResponse extends ArrayList<TimetableResponse.Period> {

    public static class Period {
        public int id;
        public int date;
        public int startTime;
        public int endTime;
        public String lstype;
        public String code;
        public String info;
        public String substText;
        public String lstext;
        public int lsnumber;
        public String statflags;
        public String activityType;
        public String sg;
        public String bkRemark;
        public String bkText;
        public Holder[] kl;
        public Holder[] te;
        public Holder[] su;
        public Holder[] ro;


        public static class Holder {
            public int id;
            public String name;
            public String longname;
            public String externalkey;
        }
    }

}
