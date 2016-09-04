package FindSorted;

/**
 * Created by alexnagorniy on 20.08.16.
 */
public class ContactInfo {
    private String city;
    private String phone;
    private String email = "";

    public ContactInfo() {
        this.city  = "";
        this.phone  = "";
        this.email  = "";
    }

    public ContactInfo(String city) {
        this.city = city != null ? city : "";
        this.phone  = "";
        this.email  = "";
    }

    public ContactInfo(String city, String phone, String email) {
        this.city = city != null ? city : "";
        this.phone = phone != null ? phone : "";
        this.email = email != null ? email : "";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "City: " + city +' ' +
                ", phoneNumber: " + phone + ' ' +
                ", email: " + email + ' ' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactInfo that = (ContactInfo) o;

        if (!city.equals(that.city)) return false;
        if (!phone.equals(that.phone)) return false;
        return email.equals(that.email);

    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
