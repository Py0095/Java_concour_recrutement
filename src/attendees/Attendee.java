package attendees;

import java.util.UUID;

import services.Repository;

abstract class Attendee {

    protected String code;
    protected String name;
    protected String sex;

    public Attendee(String line) {
        String[] parts = line.split(",");
        this.code = parts[0];
        this.name = parts[1];
        this.sex = parts[2];
    }

    public Attendee(String name, String sex) {
        this.code = this.genarrateUuid();
        this.name = name;
        this.sex = sex;
    }

    private String genarrateUuid() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey.toString();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    abstract public double getMarks();

    abstract public double getAverage();

    public void setQuetionMark(int question, double mark) throws Exception {
        String method = "setQ" + question + "Mark";
        this.getClass().getMethod(method, double.class).invoke(this, mark);
    }

    public void save() throws Exception {
        Repository.write(this, false);
    }

    @Override
    public String toString() {
        return "Code: " + code + ",\nName: " + name + ",\nSex: " + sex + ",\n";
    }
}