package ley.untis.data;

import java.util.ArrayList;

public class DepartmentResponse extends ArrayList<DepartmentResponse.Department> {

    public static class Department {
        public int id;
        public String name;
        public String longName;
    }

}
