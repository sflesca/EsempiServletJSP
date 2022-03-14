package psw.beans;

public class RegisterBean {
    private String myid;
    private String passwd;
    private String cognome;
    private String nome;
    private String email;
    private String confpswd;

    public String getMyid() {
        return myid;
    }

    public void setMyid(String myid) {
        this.myid = myid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfpswd() {
        return confpswd;
    }

    public void setConfpswd(String confpswd) {
        this.confpswd = confpswd;
    }
}
