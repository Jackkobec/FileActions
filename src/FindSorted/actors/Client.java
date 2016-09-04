package FindSorted.actors;

/**
 *
 * */

public class Client extends User {
    long clientID;


    public Client(String fullName, ContactInfo contactInfo) {
        super(fullName, contactInfo);
        this.clientID = (long) (Math.random() * 1000);
    }

    @Override
    public String toString() {

        return "Client{" +
                "id=" + this.clientID +
                ", fullName='" + this.getFullName() + '\'' +
                ", pass='" + this.getPass() + '\'' +
                ", " + this.getContactInfo() + "\n";

    }
}
/*   private List<Comment> comments;


    public Client() {
        this.comments = new ArrayList<Comment>();
    }

    public Client(String fullName) {
        super(fullName);
        this.comments = new ArrayList<Comment>();
    }

    public Client(String fullName, ContactInfo contactInfo) {
        super(fullName, contactInfo);
        this.comments = new ArrayList<Comment>();
    }

    public Client(String fullName, String pass, ContactInfo contactInfo, List<Comment> comments) {
        super(fullName, pass, contactInfo);
        this.comments = comments != null ? comments : new ArrayList<Comment>();
    }

    public Client(String fullName, ContactInfo contactInfo, List<Comment> comments) {
        super(fullName, contactInfo);
        this.comments = comments != null ? comments : new ArrayList<Comment>();
    }

    public Client(long id, String fullName, String pass, ContactInfo contactInfo, List<Comment> comments) {
        super(id, fullName, pass, contactInfo);
        this.comments = comments != null ? comments : new ArrayList<Comment>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }*/

