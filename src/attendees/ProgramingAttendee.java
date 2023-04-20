package attendees;

import java.util.ArrayList;

import services.Repository;

public class ProgramingAttendee extends Attendee {

    public static final String FILENAME = "programing_attendees.txt";
    public static final int NB_QUESTIONS = 3;
    public static final double PROGRAM_TOTAL_MARK = 500.0;
    public static final double Q1_TOTAL_MARK = 200.0;
    public static final double Q2_TOTAL_MARK = 150.0;
    public static final double Q3_TOTAL_MARK = 150.0;

    private double programMark;
    private double q1Mark;
    private double q2Mark;
    private double q3Mark;

    public ProgramingAttendee(String line) {
        super(line);
        String[] parts = line.split(",");
        assert parts.length == 7;
        this.programMark = Double.parseDouble(parts[3]);
        this.q1Mark = Double.parseDouble(parts[4]);
        this.q2Mark = Double.parseDouble(parts[5]);
        this.q3Mark = Double.parseDouble(parts[6]);
    }

    public ProgramingAttendee(String name, String sex, double programMark) {
        super(name, sex);
        this.programMark = programMark;
        this.q1Mark = 0;
        this.q2Mark = 0;
        this.q3Mark = 0;
    }

    public double getProgramMark() {
        return programMark;
    }

    public void setProgramMark(double programMark) {
        this.programMark = programMark;
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

    public double getQ3Mark() {
        return q3Mark;
    }

    public void setQ3Mark(double q3Mark) {
        this.q3Mark = q3Mark;
    }

    @Override
    public String toString() {
        return super.toString() + "Program Mark: " + programMark + ",\nQ1 Mark: " + q1Mark + ",\nQ2 Mark: " + q2Mark
                + ",\nQ3 Mark: " + q3Mark + ",\n\nTotal Mark: " + getMarks() + ",\nAverage: " + getAverage() + "/100\n";
    }

    public static ArrayList<ProgramingAttendee> fetchAll() throws Exception {
        return Repository.read(FILENAME, ProgramingAttendee.class);
    }

    @Override
    public double getMarks() {
        return programMark + q1Mark + q2Mark + q3Mark;
    }

    @Override
    public double getAverage() {
        double nAverage = (getMarks() / (PROGRAM_TOTAL_MARK + Q1_TOTAL_MARK + Q2_TOTAL_MARK + Q3_TOTAL_MARK)) * 100;
        return Double.parseDouble(String.format("%.2f", nAverage));
    }

}
