package ch.he.arc.p1.g5.fi5t;

public class UserClass {
    private String Nom;
    private String Prenom;
    public String Role;
    private String MDP;
    private Integer MessageEnvoyer;
    private String Pseudo;


    public UserClass(String sNom,String sPrenom,String sRole,String sMDP,String sPseudo,Integer iMessageEnvoyer) {
        super();
        Nom=sNom;
        Prenom=sPrenom;
        Role=sRole;
        MDP=sMDP;
        Pseudo=sPseudo;
        MessageEnvoyer=iMessageEnvoyer;

    }

    public String getNom()
    {
        return Nom;
    }
    public String getPrenom()
    {
        return Prenom;
    }
    public String getRole()
    {
        return Role;
    }
    public String getMDP()
    {
        return MDP;
    }
    public String getPseudo()
    {
        return Pseudo;
    }
    public Integer getImessage()
    {
        return MessageEnvoyer;
    }
    public void setNom(String NNom)
    {
        Nom=NNom;
    }
    public void setPrenom(String NPrenom)
    {
        Prenom=NPrenom;
    }
    public void setRole(String NRole)
    {
        Role=NRole;
    }
    public void setMDP(String NMDP)
    {
        MDP=NMDP;
    }
    public void setPseudo(String NPseudo)
    {
       Pseudo=NPseudo;
    }



}

