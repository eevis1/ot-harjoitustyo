
package app.domain;

import app.domain.User;


public class Course {

    private int id;
    private String name;
    private int grade;
    private boolean done;
    private User user;

    public Course(int id, int grade, boolean done, User user) {
        this.id = id;
        this.grade = grade;
        this.done = done;
        this.user = user;
    }

    public Course(String name, User user) {
        this.name = name;
        this.user = user;
        this.done = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        done = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Course)) {
            return false;
        }
        Course other = (Course) obj;
        return id == other.id;
    }

    Object getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
