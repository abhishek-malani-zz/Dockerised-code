public class FriendshipManager {
    public static void makeFriends(Person personA, Person personB) {
        personA.addFriend(personB);
        personB.addFriend(personA);
    }
}
