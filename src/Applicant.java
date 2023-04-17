public class Applicant {

    private String code;
    private String name;
    private String sexe;
    private Double moyApplicant;

    public Applicant(String code, String name, String sexe,Double moyApplicant) {
        this.code = code;
        this.name = name;
        this.sexe = sexe;
        this.moyApplicant = moyApplicant;

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

    public Double getMoyApplicant() {
        return moyApplicant;
    }

    public void setMoyApplicant(Double noteApplicant) {
        this.moyApplicant = noteApplicant;
    }

    @Override
    public String toString() {
        return " Code: "+code + "\n Name: " + name + "\n Sexe: " + sexe + "\n Note: " + moyApplicant ;
    }

    // @Override
    // public String toStrng2() {
    // return code + "!" + name + "!" + sexe + '\n';
    // }
}
