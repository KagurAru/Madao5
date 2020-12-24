package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User("1","12","123");

    @Test
    void getSurname() {
        assertEquals("1",user.getSurname());
    }

    @Test
    void getName() {
        assertEquals("12",user.getName());
    }

    @Test
    void getPassword() {
        assertEquals("123",user.getPassword());
    }

}