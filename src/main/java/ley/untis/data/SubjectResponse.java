package ley.untis.data;

import java.util.ArrayList;

public class SubjectResponse extends ArrayList<SubjectResponse.Subject> {

    public static class Subject {
        public int id;
        public String name;
        public String longName;
        public String foreColor;
        public String backColor;
        public String alternateName;
        public boolean active;
    }

}
