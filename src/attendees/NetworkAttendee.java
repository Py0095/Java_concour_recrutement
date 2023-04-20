package attendees;

import java.util.ArrayList;

import services.Repository;

public class NetworkAttendee extends Attendee {

    public static final String FILENAME = "network_attendees.txt";
    public static final int NB_QUESTIONS = 4;
    public static final double NETWORK_TOTAL_MARK = 250.0;
    public static final double Q1_TOTAL_MARK = 150.0;
    public static final double Q2_TOTAL_MARK = 200.0;
    public static final double Q3_TOTAL_MARK = 250.0;
    public static final double Q4_TOTAL_MARK = 300.0;

    private double networkMark;
    private double q1Mark;
    private double q2Mark;
    private double q3Mark;
    private double q4Mark;

    public NetworkAttendee(String line) {
        super(line);
        String[] parts = line.split(",");
        assert parts.length == 8;
        this.networkMark = Double.parseDouble(parts[3]);
        this.q1Mark = Double.parseDouble(parts[4]);
        this.q2Mark = Double.parseDouble(parts[5]);
        this.q3Mark = Double.parseDouble(parts[6]);
        this.q4Mark = Double.parseDouble(parts[7]);
    }

    public NetworkAttendee(String name, String sex, double networkMark) {
        super(name, sex);
        this.networkMark = networkMark;
        this.q1Mark = 0;
        this.q2Mark = 0;
        this.q3Mark = 0;
        this.q4Mark = 0;
    }

    public double getNetworkMark() {
        return networkMark;
    }

    public void setNetworkMark(double networkMark) {
        this.networkMark = networkMark;
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

    public double getQ4Mark() {
        return q4Mark;
    }

    public void setQ4Mark(double q4Mark) {
        this.q4Mark = q4Mark;
    }

    @Override
    public String toString() {
        return super.toString() + "Network Mark: " + networkMark + ",\nQ1 Mark: " + q1Mark + ",\nQ2 Mark: " + q2Mark
                + ",\nQ3 Mark: " + q3Mark + ",\nQ4 Mark: " + q4Mark + ",\n\nTotal Mark: " + getMarks() + ",\nAverage: " + getAverage() + "/100\n";
    }

    public static ArrayList<NetworkAttendee> fetchAll() throws Exception {
        return Repository.read(FILENAME, NetworkAttendee.class);
    }

    @Override
    public double getMarks() {
       return networkMark + q1Mark + q2Mark + q3Mark + q4Mark;
    }

    @Override
    public double getAverage() {
        double nAverage = (getMarks() / (NETWORK_TOTAL_MARK + Q1_TOTAL_MARK + Q2_TOTAL_MARK + Q3_TOTAL_MARK + Q4_TOTAL_MARK)) * 100;
        return Double.parseDouble(String.format("%.2f", nAverage));
    }

}
