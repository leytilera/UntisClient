package ley.untis.data;

import java.util.ArrayList;

public class RoomResponse extends ArrayList<RoomResponse.Room> {

    public static class Room {
        public int id;
        public String name;
        public String longName;
        public String foreColor;
        public String backColor;
    }

}
