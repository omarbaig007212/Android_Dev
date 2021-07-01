public class Message{
    private String recipient;
    private String text;
    private int id;
    public Message(String recipient,String text,int id)
    {
        this.recipient=recipient;
        this.text=text;
        this.id=id;
    }
    public void getDetails()
    {
        System.out.println("recipient --> "+recipient+"\ntext--> "+text
        +"\nid--> "+id);
    }
    public void setrecipient(String recipient)
    {
        this.recipient=recipient;
    }
    public String getrecipient()
    {
        return recipient;
    }
    public void setText(String text)
    {
        this.text=text;
    }
    public String getText()
    {
        return text;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return id;
    }
}