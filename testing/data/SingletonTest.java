package data;

import static org.junit.Assert.*;
import org.junit.Test;
import dal.DatabaseConnection;

public class SingletonTest {

    @Test
    public void testSingletonInstance() {
        // Get two instances of DatabaseConnection
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        // They must be the exact same object reference
        assertSame("DatabaseConnection should be a Singleton", instance1, instance2);
        assertNotNull("Instance should not be null", instance1);
    }
}
