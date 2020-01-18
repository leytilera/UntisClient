package ley.untis.data;

import java.util.ArrayList;

public class TeacherResponse extends ArrayList<TeacherResponse.Teacher> {

    public static class Teacher {

        public int id;
        public String name;
        public String longName;
        public String foreName;
        public String foreColor;
        public String backColor;

    }

}
