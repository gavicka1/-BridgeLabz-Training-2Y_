import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    public LibraryItem(String itemId,String title,String author){setItemId(itemId);setTitle(title);setAuthor(author);}
    public String getItemId(){return itemId;}
    public void setItemId(String id){if(id==null||id.isEmpty()) throw new IllegalArgumentException(); this.itemId=id;}
    public String getTitle(){return title;}
    public void setTitle(String t){if(t==null||t.isEmpty()) throw new IllegalArgumentException(); this.title=t;}
    public String getAuthor(){return author;}
    public void setAuthor(String a){if(a==null) a=""; this.author=a;}
    public String getItemDetails(){return "ID:"+getItemId()+" Title:"+getTitle()+" Author:"+getAuthor();}
    public abstract int getLoanDuration();
}

interface Reservable{
    boolean reserveItem(String user);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable{
    private boolean available=true;
    private String reservedBy;
    public Book(String id,String title,String author){super(id,title,author);}
    public int getLoanDuration(){return 21;}
    public boolean reserveItem(String user){if(!available) return false; available=false; reservedBy=user; return true;}
    public boolean checkAvailability(){return available;}
}

class Magazine extends LibraryItem implements Reservable{
    private boolean available=true;
    public Magazine(String id,String title,String author){super(id,title,author);}
    public int getLoanDuration(){return 7;}
    public boolean reserveItem(String user){if(!available) return false; available=false; return true;}
    public boolean checkAvailability(){return available;}
}

class DVD extends LibraryItem implements Reservable{
    private boolean available=true;
    public DVD(String id,String title,String author){super(id,title,author);}
    public int getLoanDuration(){return 3;}
    public boolean reserveItem(String user){if(!available) return false; available=false; return true;}
    public boolean checkAvailability(){return available;}
}

public class LibraryManagement{
    public static void main(String[] args){
        List<LibraryItem> items=new ArrayList<>();
        Book b=new Book("B01","Core Java","Author A");
        Magazine m=new Magazine("M01","Tech Monthly","Publisher");
        DVD d=new DVD("D01","Movie X","Director");
        items.add(b); items.add(m); items.add(d);
        for(LibraryItem it:items) System.out.println(it.getItemDetails()+" LoanDays:"+it.getLoanDuration());
        System.out.println("Reserve book: "+((Reservable)b).reserveItem("Student1")+" Available after reserve: "+((Reservable)b).checkAvailability());
    }
}
