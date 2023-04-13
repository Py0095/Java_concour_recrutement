public class Applicant {

    private String code;
    private String name;
    private String sexe;
    private Double noteApplicant;

    public Applicant(String code, String name, String sexe,Double noteApplicant) {
        this.code = code;
        this.name = name;
        this.sexe = sexe;
        this.noteApplicant = noteApplicant;

    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Double getNoteApplicant() {
        return noteApplicant;
    }

    public void setNoteApplicant(Double noteApplicant) {
        this.noteApplicant = noteApplicant;
    }

    @Override
    public String toString() {
        return " Code: "+code + "\n Name: " + name + "\n Sexe: " + sexe + "\n Note: " + noteApplicant ;
    }

    // @Override
    // public String toStrng2() {
    // return code + "!" + name + "!" + sexe + '\n';
    // }
}
