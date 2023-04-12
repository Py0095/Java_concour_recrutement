public class Applicant {

    private String code;
    private String name;
    private String sexe;

    public Applicant(String code, String name, String sexe) {
        this.code = code;
        this.name = name  ;
        this.sexe = sexe;
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

    @Override
    public String toString() {
        return " Code: "+code + "\n Name: " + name + "\n Sexe: " + sexe;
    }

}
