package ley.untis.data;

public class SimpleTimetableDateParams extends SimpleTimetableParams {

    public int startDate;
    public int endDate;

    public SimpleTimetableDateParams(int id, int type, int startDate, int endDate) {
        super(id, type);
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
