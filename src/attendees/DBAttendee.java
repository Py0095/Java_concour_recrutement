package attendees;

import java.util.ArrayList;

import services.Repository;

public class DBAttendee extends Attendee {

    public static final String FILENAME = "db_attendees.txt";
    public static final int NB_QUESTIONS = 2;
    public static final double NETWORK_TOTAL_MARK = 300.0;
    public static final double Q1_TOTAL_MARK = 250.0;
    public static final double Q2_TOTAL_MARK = 250.0;

    private double dbMark;
    private double q1Mark;
    private double q2Mark;

    public DBAttendee(String line) {
        super(line);
        String[] parts = line.split(",");
        assert parts.length == 6;
        this.dbMark = Double.parseDouble(parts[3]);
        this.q1Mark = Double.parseDouble(parts[4]);
        this.q2Mark = Double.parseDouble(parts[5]);
    }

    public DBAttendee(String name, String sex, double dbMark) {
        super(name, sex);
        this.dbMark = dbMark;
        this.q1Mark = 0;
        this.q2Mark = 0;
    }

    public double getDbMark() {
        return dbMark;
    }

    public void setDbMark(double dbMark) {
        this.dbMark = dbMark;
    }

    public double getQ1Mark() {
        return q1Mark;
    }

    public void setQ1Mark(double q1Mark) {
        this.q1Mark = q1Mark;
    }

    public double getQ2Mark() {
        return q2Mark;
    }

    public void setQ2Mark(double q2Mark) {
        this.q2Mark = q2Mark;
    }

    @Override
    public String toString() {
        return super.toString() + "DB Mark: " + dbMark + ",\nQ1 Mark: " + q1Mark + ",\nQ2 Mark: " + q2Mark
                + ",\n\nTotal Mark: " + getMarks() + ",\nAverage: " + getAverage() + "/100\n";
    }

    public static ArrayList<DBAttendee> fetchAll() throws Exception {
        return Repository.read(FILENAME, DBAttendee.class);
    }

    @Override
    public double getMarks() {
        return this.dbMark + this.q1Mark + this.q2Mark;
    }

    @Override
    public double getAverage() {
        double nAverage = (this.getMarks() / (NETWORK_TOTAL_MARK + Q1_TOTAL_MARK + Q2_TOTAL_MARK)) * 100;
        return Double.parseDouble(String.format("%.2f", nAverage));
    }
}
