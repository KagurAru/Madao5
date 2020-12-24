package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBTest {

    @Test
    void DBtest() {
        assertEquals(true, DB.test());
    }

    @Test
    void getUser() {
        DB db = new DB();
        User user = new User("admin","admin","admin");
        assertEquals(true, db.getUser(user));
    }
}