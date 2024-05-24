/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yukasir;

/**
 *
 * @author Paideia
 */
import java.util.prefs.Preferences;

public class LocalStorage {

    // Save data to local storage
    public static void saveData(String key, String value) {
        Preferences prefs = Preferences.userRoot().node(LocalStorage.class.getName());
        prefs.put(key, value);
    }

    // Retrieve data from local storage
    public static String getData(String key) {
        Preferences prefs = Preferences.userRoot().node(LocalStorage.class.getName());
        return prefs.get(key, null); // Default value is null if key doesn't exist
    }
    
     // Remove data from local storage
    public static void removeData(String key) {
        Preferences prefs = Preferences.userRoot().node(LocalStorage.class.getName());
        prefs.remove(key);
    }


//    public static void main(String[] args) {
//        // Example usage
//        saveData("username", "john_doe");
//        String username = getData("username");
//        System.out.println("Username: " + username);
//    }
}

