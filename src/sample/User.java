package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class User {
    private String surname;
    private String name;
    private String password;

    public User(String surname, String password) {
        this.surname = surname;
        this.password = password;
    }

    public User(String surname, String name, String password) {
        this.surname = surname;
        this.name = name;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
