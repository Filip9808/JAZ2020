package pl.jazapp.app.webapp.model;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class Storage {

    private static Map<String, User> storage = new ConcurrentHashMap<>();

    public static void AddToStorage(String username, User user) {
        storage.put(username, user);

    }

    public static boolean IsUserExist(String username) {
        return storage.containsKey(username);

    }

    public static boolean IsUsernameAndPasswordCorrect(String username, String password) {
        if (IsUserExist(username)) {
            return storage.get(username).getPassword().equals(password);

        } else {
            return false;


        }
    }

    public static String getFirstName(String username) {
        return storage.get(username).getFirstName();
    }
    public static String getLastName(String username) {
        return storage.get(username).getLastName();
    }

}



