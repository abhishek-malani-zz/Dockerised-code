import java.util.*;

public class Person {
    private String name;
    private Set<Person> friends = new HashSet<>();

    private class TraversalNode {
        private Person person;
        private int depth;

        private TraversalNode(Person person, int depth) {
            this.person = person;
            this.depth = depth;
        }
    }

    public Person(String name) {
        this.name = name;
    }

    public void addFriend(Person person) {
        friends.add(person);
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public String toString() {
        return name;
    }

    public List<Person> getFriendsAtDepth(int depth) {
        if (depth < 1) {
            return new ArrayList<>();
        }
        List<Person> result = new ArrayList<>();
        Set<Person> visitedSet = new HashSet<>();
        visitedSet.add(this);
        Queue<TraversalNode> bfsQueue = new LinkedList<>();
        for (Person friend : friends) {
            bfsQueue.add(new TraversalNode(friend, 1));
        }

        do {
            TraversalNode node = bfsQueue.remove();
            Person person = node.person;
            int at_depth = node.depth;
            if (visitedSet.contains(person))
                continue;
            visitedSet.add(person);
            if (at_depth < depth) {
                for (Person friend : person.getFriends()) {
                    bfsQueue.add(new TraversalNode(friend, at_depth + 1));
                }
            } else {
                result.add(person);
            }
        } while (!bfsQueue.isEmpty());
        return result;
    }
}
