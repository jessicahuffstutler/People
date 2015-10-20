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
        String fileContent = readFile("people.csv"); //reading the file called people.csv
        String[] peopleContent = fileContent.split("\n"); //reading the entire file and then splitting it up
        HashMap<String, ArrayList<Person>> people = new HashMap();

//        int index = 0 //alternative to the for loop below to skip the first line from the csv file
//        for (String line lines) {
//            if (index !=0) {
//            }
//        }

//        for (String line : lines){ //2nd alternative to the below to skip first line in csv file
//            if (line == lines[0]){
//                continue;
//            }
//        }

        for (int i = 1; i < peopleContent.length; i++) { //for (String content : peopleContent); for loop
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

        System.out.println(people); //System.out.println(people.toString()); the ".toString" isnt necessary
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
//country name is the key and inside of that there is an arraylist of those people (from that country)
//which would then be sorted alphabetically.
