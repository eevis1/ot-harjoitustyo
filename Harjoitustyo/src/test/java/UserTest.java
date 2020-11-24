

import app.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    

        @Test
        public void equalWhenSameUsername() {
            User u1 = new User("tester", "Teppo");
            User u2 = new User("tester", "Teppo");
            assertTrue(u1.equals(u2));
        }

        @Test
        public void nonEqualWhenDifferentUsername() {
            User u1 = new User("tester", "Teppo");
            User u2 = new User("hellas", "Arto");
            assertFalse(u1.equals(u2));
        }

        @Test
        public void nonEqualWhenDifferentType() {
            User u = new User("tester", "Teppo");
            Object o = new Object();
            assertFalse(u.equals(o));
        }
    }

