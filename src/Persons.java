/**
 * Created by jessicahuffstutler on 10/19/15.
 */
public class Persons implements Comparable {
    String lastName;
    String country;

    public Persons(String name, String country) {
        this.lastName = name;
        this.country = country;
    }

    public String getName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int compareTo(Object o) {
        Persons c = (Persons) o;
        int result = lastName.compareTo(c.lastName);
        return result;
    }
}
