package ch.he.arc.p1.g5.fi5t;

/**
 * Created by raphael.schaffo on 22.08.2014.
 */
public class Message {
    private String Date;
    private String Heure;
    public String Status;
    private String Messages;
    private Integer IDMessage;
    private String IDUtilisateur;


    public Message(String sDate,String sHeure,String sStatus,String sMessages,String sUtilisateur, Integer iIDMessage) {
        super();
        Date = sDate;
        Heure = sHeure;
        Status = sStatus;
        Messages = sMessages;
        IDUtilisateur = sUtilisateur;
        IDMessage = iIDMessage;
    }

    public String getDate()
    {
        return Date;
    }
    public String getHeure()
    {
        return Heure;
    }
    public String getStatus()
    {
        return Status;
    }
    public String getMessages()
    {
        return Messages;
    }
    public String getIDUtilisateur()
    {
        return IDUtilisateur;
    }
    public Integer getIDMessage()
    {
        return IDMessage;
    }
    public void setStatus(String sStatus)
    {
       Status=sStatus;
    }


}
