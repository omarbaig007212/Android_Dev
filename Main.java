import java.util.*;
public class Main {
    public static ArrayList<Contacts> contacts;
    public static Scanner sc;
    private static int id=0;
    public static void main(String[] args)
    {
        sc=new Scanner(System.in);
        contacts=new ArrayList<>();
        System.out.println("Welcome!!");
        showOptions();
    }
    public static void showOptions()
    {
        System.out.println(" 1.Manage Contacts"+"\n 2.Messages"+"\n 3.Quit");
        int n=sc.nextInt();
        switch(n)
        {
            case 1:
                ManageContacts();
                break;
            case 2:
                Messages();
                break;
            default:
                break;
        }
    }
    public static void ManageContacts()
    {
        System.out.println("1.Show all contacts"+"\n2.Add a new contact"
        +"\n3.Search for a contact"+"\n4.Delete a contact"+
        "\n5.Go back to the previous menu");
        int n=sc.nextInt();
        switch(n)
        {
            case 1:
                allContacts();
                break;
            case 2:
                addContacts();
                break;
            case 3:
                searchContacts();
                break;
            case 4:
                delContacts();
                break;
            default:
                showOptions();
                break;
        }
    }
    public static void allContacts()
    {
        for(Contacts c: contacts)
        {
            c.getDetails();
        }
        showOptions();
    }
    public static void addContacts()
    {
        System.out.println("Adding a new Contact!"+
        "\n Please provide name,number,email");
        String name=sc.next();
        String num=sc.next();
        String em=sc.next();
        if(name==""||num==""||em=="")
        {
            System.out.println("please enter names,num and email!");
            addContacts();
        }
        for(Contacts c:contacts)
        {
            if(c.getname().equals(name))
            {
                System.out.println(name+" already present in the arraylist");
                addContacts();
            }
        }
        Contacts c=new Contacts(name,num,em);
        contacts.add(c);
        System.out.println(name+" Added to the arraylist");
        showOptions();
    }
    public static void searchContacts()
    {
        System.out.println("please eneter the contact name");
        String s=sc.next();
        boolean flag=false;
        if(s.equals(""))
        {
            searchContacts();
        }
        for(Contacts c:contacts)
        {
            if(c.getname().equals(s))
            {
                c.getDetails();
                flag=true;
            }
        }
        if(flag==false)
        {
            System.out.println("Not Found--> "+s);
        }
        showOptions();
    }
    public static void delContacts()
    {
        System.out.println("Please enter the name");
        String s=sc.next();
        if(s.equals(""))
            delContacts();
        boolean flag=false;
        for(Contacts c:contacts)
        {
            if(c.getname().equals(s))
            {
                flag=true;
                contacts.remove(c);
            }
        }
        if(flag==false)
            System.out.println("Not Found --> "+s);
        showOptions();
    }
    public static void Messages()
    {
        System.out.println("Please select one option"+
        "\n 1. Show all messages"+
        "\n 2. Send a message"+
        "\n 3. Go back");
        int n=sc.nextInt();
        switch(n)
        {
            case 1:
                showMsg();
                break;
            case 2:
                sendMsg();
                break;
            default:
                showOptions();
                break;
        }
    }
    public static void showMsg()
    {
        ArrayList<Message> msg=new ArrayList<>();
        for(Contacts c:contacts)
        {
            msg.addAll(c.getmessages());
            System.out.println(c.getmessages());
        }
        if(msg.size()>0)
        {
            for(Message m:msg)
            {
                m.getDetails();
                System.out.println("-------");
            }
        }
        else
        {
            System.out.println("No messages found");
        }
        showOptions();
    }
    public static void sendMsg()
    {
        System.out.println("Enter the name of contact");
        String name=sc.next();
        if(name.equals(""))
        {
            sendMsg();
        }
        else
        {
            boolean flag=false;
            for(Contacts c:contacts)
            {
                if(c.getname().equals(name))
                {
                    flag=true;
                }
            }
            if(flag==true)
            {
                System.out.println("Enter the Text message");
                String text=sc.next();
                if(text.equals(""))
                {
                    System.out.println("Please enter a msg");
                    sendMsg();
                }
                else
                {
                    id++;
                    Message newMsg=new Message(name, text, id);
                    for(Contacts c:contacts)
                    {
                        if(c.getname().equals(name))
                        {
                            ArrayList<Message> newMsgs=c.getmessages();
                            newMsgs.add(newMsg);
                            c.setmessages(newMsgs);
                        }
                    }
                }
            }
            else
            {
                System.out.println("no such contact found!");
            }
        }
        Messages();
    }
}