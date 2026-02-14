package data;

import static org.junit.Assert.*;
import org.junit.Test;
import dal.HashCalculator;

public class HashingTest {

    @Test
    public void testHashingIntegrity() throws Exception {
        String originalContent = "This is the original content.";
        String editedContent = "This is the edited content.";

        // Calculate hashes
        String originalHash = HashCalculator.calculateHash(originalContent);
        String editedHash = HashCalculator.calculateHash(editedContent);

        // Verify hashes are consistent for same content
        assertEquals("Hash should be deterministic", originalHash, HashCalculator.calculateHash(originalContent));

        // Verify editing changes the hash
        assertNotEquals("Editing content should change the hash", originalHash, editedHash);
        
        // Verify format (MD5 is 32 hex chars)
        assertEquals("MD5 hash should be 32 characters long", 32, originalHash.length());
    }
}
