
package app.domain;


import app.domain.Course;
import app.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Actions{

    static void main(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Course course;
    private User user;
    private User loggedIn;
    private ArrayList<User> users;
    private ArrayList<Course> courses;

    public Actions(Course course, User user) {
        this.course = course;
        this.user = user;
    }


    /**
     * sisäänkirjautuminen
     *
     * @param username käyttäjätunnus
     *
     * @return true jos käyttäjätunnus on olemassa, muuten false
     */
    public boolean login(String username) {
        boolean found = users.contains(username);
        if (found == false) {
            return false;
        }

        loggedIn = user;

        return true;
    }

    /**
     * kirjautuneena oleva käyttäjä
     *
     * @return kirjautuneena oleva käyttäjä
     */
    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * uloskirjautuminen
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * uuden käyttäjän luominen
     *
     * @param username käyttäjätunnus
     * @param name käyttäjän nimi
     *
     * @return true jos käyttäjätunnus on luotu onnistuneesti, muuten false
     */
    public boolean createUser(String username, String name) {
        if (user.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username, name);
        try {
            users.add(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
    
}
