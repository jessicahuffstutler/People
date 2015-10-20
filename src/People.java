import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jessicahuffstutler on 10/19/15.
 */
public class People {
    public static void main(String[] args) {
        String fileContent = readFile("people.csv");
        String[] peopleContent = fileContent.split("\n");
        HashMap<String, ArrayList<Person>> people = new HashMap();

        for (int i = 1; i < peopleContent.length; i++) { //for (String content : peopleContent)
            String[] column = peopleContent[i].split(",");
            String firstName = column[1];
            String lastName = column[2];
            String email = column[3];
            String country = column[4];
            String ipAddress = column [5];
            Person p = new Person(firstName, lastName, email, country, ipAddress);
            ArrayList<Person> list = people.get(country);
            if(list == null) {
                list = new ArrayList();
                list.add(p);
                people.put(country, list);
            } else {
                list.add(p);
            }

            for (ArrayList<Person> peeps : people.values()) {
                Collections.sort(peeps);
            }
        }

        System.out.println(people.toString());
    }

    static String readFile(String fileName) {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }
}
