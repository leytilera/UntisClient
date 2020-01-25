package ley.untis.data;

import java.util.ArrayList;

public class KlasseResponse extends ArrayList<KlasseResponse.Klasse> {

    public static class Klasse {
        public int id;
        public String name;
        public String longName;
        public String backColor;
        public String longColor;
        public boolean active;
        public String teacher1;
        public String teacher2;

    }

}
