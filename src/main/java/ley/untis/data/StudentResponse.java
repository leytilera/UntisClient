package ley.untis.data;

import java.util.ArrayList;

public class StudentResponse extends ArrayList<StudentResponse.Student> {

    public static class Student {
        public int id;
        public String key;
        public String name;
        public String foreName;
        public String longName;
        public String gender;
    }

}
