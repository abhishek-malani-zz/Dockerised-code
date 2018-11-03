import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) throws Exception {
        // INPUT is read from the file "input"
        BufferedReader reader = new BufferedReader(new FileReader("./input"));
        MainClass.seek(reader);
        String[] names = reader.readLine().split(",");
        Map<String, Person> personMap = new HashMap<>();
        List<Person> people = new ArrayList<>();
        for (String name : names) {
            name = name.trim().toLowerCase();
            Person person = new Person(name);
            people.add(person);
            personMap.put(name, person);
        }
        int index = 0;
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            names = line.split(",");
            for (String name : names) {
                name = name.trim().toLowerCase();
                Person friend = personMap.get(name);
                Person person = people.get(index);
                FriendshipManager.makeFriends(person, friend);
            }
            index++;
        }
        for (Person person : people) {
            System.out.println("2nd Degree friends of " + person.toString() + " are: " + person.getFriendsAtDepth(2));
        }
    }

    private static void seek(BufferedReader reader) throws Exception {
        for (int i = 0; i < 15; i++) {
            reader.readLine();
        }
    }
}
