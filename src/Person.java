/**
 * Created by jessicahuffstutler on 10/19/15.
 */
public class Person implements Comparable {
    String firstName;
    String lastName;
    String email;
    String country;
    String ipAddress;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String country, String ipAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ipAddress = ipAddress;
    }

    public String toString() {
        return String.format("%s %s lives in %s.\n", firstName, lastName, country);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public int compareTo(Object o) {
        Person c = (Person) o;
        int result = lastName.compareTo(c.lastName);
        return result;
    }
}
