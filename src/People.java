import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jessicahuffstutler on 10/19/15.
 */
public class People {
    public static void main(String[] args) {
        String fileContent = readFile("people.csv");
        String[] peopleContent = fileContent.split("\n");
        HashMap<String, ArrayList<Persons>> people = new HashMap();

        for (String personName : peopleContent) { //for (int i = 1; i < lines.length; i++)
            String[] column = personName.split(",");
            String lastName = column[2];
            String country = column[4];
            Persons p = new Persons(lastName, country);
            ArrayList<Persons> list = people.get(lastName);
            if(list == null) {
                list = new ArrayList();
                list.add(p);
                people.put(lastName, list);
            } else {
                list.add(p);
            }

            System.out.println(list);
        }
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

    static void writeFile(String fileName, String fileContent) {
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        } catch (Exception e) {

        }
    }

    //static void savePerson() {
    //    File f = new File("save.json"); //json library wants you to set getters for anything you want to save
    //    JsonSerializer serializer = new JsonSerializer();
    //    String contentToSave = serializer.serialize(country);

    //    try {
    //        FileWriter fw = new FileWriter(f);
    //        fw.write(contentToSave);
    //        fw.close();
    //    } catch (Exception e) {
    //            System.out.println("Save not successful.");
    //    }
    //}
}
