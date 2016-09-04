package FindSorted;


import java.util.Comparator;

/**
 * Created by alexnagorniy on 20.08.16.
 */
public abstract class User {
    private long id;
    private String fullName;
    private String pass;
    private ContactInfo contactInfo;

    public User() {
        this.fullName = "";
        this.pass = "" + (int)(Math.random()*10000);
        this.contactInfo = new ContactInfo();
    }

    public User(String fullName) {
        this.fullName = fullName != null ? fullName : "";
        this.pass = "" + (int)(Math.random()*10000);
        this.contactInfo = new ContactInfo();
    }

    public User(long id, String fullName, String pass) {
        this.id = id;
        this.fullName = fullName != null ? fullName : "";
        this.pass = pass != null ? pass : "";
        this.contactInfo = new ContactInfo();
    }

    public User(String fullName, ContactInfo contactInfo) {
        this.fullName = fullName != null ? fullName : "";
        this.pass = "" + (int)(Math.random()*10000);
        this.contactInfo = contactInfo != null ? contactInfo : new ContactInfo();
    }

    public User(String fullName, String pass, ContactInfo contactInfo) {
        this.fullName = fullName != null ? fullName : "";
        this.pass = pass != null ? pass : "";
        this.contactInfo = contactInfo != null ? contactInfo : new ContactInfo();
    }

    public User(long id, String fullName, String pass, ContactInfo contactInfo) {
        this.id = id;
        this.fullName = fullName != null ? fullName : "";
        this.pass = pass != null ? pass : "";
        this.contactInfo = contactInfo != null ? contactInfo : new ContactInfo();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", pass='" + pass + '\'' +
                ", " + contactInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!fullName.equals(user.fullName)) return false;
        if (!pass.equals(user.pass)) return false;
        return contactInfo.equals(user.contactInfo);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + fullName.hashCode();
        result = 31 * result + pass.hashCode();
        result = 31 * result + contactInfo.hashCode();
        return result;
    }
}
