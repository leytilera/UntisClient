package ley.untis.data;

import java.util.ArrayList;

public class SchoolResponse {

    public int size;
    public School[] schools;

    public static class School {
        public String server;
        public boolean useMobileServiceUrlAndroid;
        public String address;
        public String loginName;
        public int schoolId;
        public boolean useMobileServiceUrlIos;
        public String mobileServiceUrl;
        public String displayName;
        public String serverUrl;
    }

}
