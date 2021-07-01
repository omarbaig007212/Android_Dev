import java.util.*;
public class Contacts {
    private String name;
    private String number;
    private String email;
    private ArrayList<Message> messages;

    public Contacts(String name,String number,String email,ArrayList<Message> messages)
    {
        this.name=name;
        this.number=number;
        this.email=email;
        this.messages=messages;
    }
    public Contacts(String name,String number,String email)
    {
        this.name=name;
        this.number=number;
        this.email=email;
        this.messages=new ArrayList<>();
    }

    public void getDetails()
    {
        System.out.println(" name--> "+this.name+"\n number--> "+this.number
        +"\n email--> "+this.email+"\n messages--> "+this.messages);
    }

    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name=name;
    }

    public String getnumber()
    {
        return number;
    }
    public void setnumber(String number)
    {
        this.number=number;
    }

    public String getemail()
    {
        return email;
    }
    public void setemail(String email)
    {
        this.email=email;
    }
    public ArrayList<Message> getmessages()
    {
        return messages;
    }
    public void setmessages(ArrayList<Message> messages)
    {
        this.messages=messages;
    }
}
