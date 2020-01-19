package ley.untis.data;

public class CustonTimetableParams {

    public Option options;

    public CustonTimetableParams(int id, int type, Options options) {
        this.options = new Option(id, type, options);
    }

    public CustonTimetableParams(int id, int type, Options options, int startDate, int endDate) {
        this.options = new DateOption(id, type, options, startDate, endDate);
    }

    public static class Option {
        public Element element;
        public boolean onlyBaseTimetable;
        public boolean showBooking;
        public boolean showInfo;
        public boolean showSubstText;
        public boolean showLsText;
        public boolean showLsNumber;
        public boolean showStudentgroup;
        public String[] klasseFields;
        public String[] teacherFields;
        public String[] subjectFields;
        public String[] roomFields;

        public Option(int id, int type, Options options) {
            element = new Element(id, type);
            onlyBaseTimetable = options.onlyBaseTimetable;
            showBooking = options.showBooking;
            showInfo = options.showInfo;
            showSubstText = options.showSubstText;
            showLsText = options.showLsText;
            showLsNumber = options.showLsNumber;
            showStudentgroup = options.showStudentgroup;
            if(options.klasseFields == null) {
                klasseFields = new String[1];
                klasseFields[0] = "id";
            } else {
                klasseFields = options.klasseFields;
            }
            if(options.teacherFields == null) {
                teacherFields = new String[1];
                teacherFields[0] = "id";
            } else {
                teacherFields = options.teacherFields;
            }
            if(options.subjectFields == null) {
                subjectFields = new String[1];
                subjectFields[0] = "id";
            } else {
                subjectFields = options.subjectFields;
            }
            if(options.roomFields == null) {
                roomFields = new String[1];
                roomFields[0] = "id";
            } else {
                roomFields = options.roomFields;
            }
        }

        public static class Element {
            public Element(int id, int type) {
                this.id = id;
                this.type = type;
            }
            public int id;
            public int type;
            public String keyType= "id";
        }
    }

    public static class DateOption extends Option {
        public int startDate;
        public int endDate;

        public DateOption(int id, int type, Options options, int startDate, int endDate) {
            super(id, type, options);
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

}
