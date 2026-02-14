package business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import dal.TFIDFCalculator;

public class TFIDFCalculatorTest {

    private TFIDFCalculator calculator;

    @Before
    public void setUp() {
        calculator = new TFIDFCalculator();
    }

    @Test
    public void testTFIDFCalculationPositive() {
        // Add documents to corpus
        calculator.addDocumentToCorpus("بسم الله الرحمن الرحيم");
        calculator.addDocumentToCorpus("الله أكبر");
        calculator.addDocumentToCorpus("كتاب مفيد"); // Dummy 1
        calculator.addDocumentToCorpus("قراءة ممتعة"); // Dummy 2

        // Calculate TF-IDF for a document containing "الله"
        String document = "الله";
        double score = calculator.calculateDocumentTfIdf(document);

        // Score should be greater than 0
        assertTrue("TF-IDF score should be positive for relevant Arabic text", score > 0.0);
    }

    @Test
    public void testTFIDFCalculationNegative() {
        // Add documents
        calculator.addDocumentToCorpus("تفاحة موزة");
        calculator.addDocumentToCorpus("برتقال عنب");

        // Calculate for a document with NO overlapping words
        String document = "سيارة طائرة";
        double score = calculator.calculateDocumentTfIdf(document);

        // Score should be 0.0
        assertEquals("TF-IDF score should be 0.0 for unrelated document", 0.0, score, 0.0001);
    }
    
    @Test
    public void testEmptyInput() {
        String document = "";
        double score = calculator.calculateDocumentTfIdf(document);
        
        // Should return 0.0 and NOT NaN
        assertEquals("Empty input should return 0.0", 0.0, score, 0.0001);
    }
    
    @Test
    public void testNonArabicInput() {
        // English text should be filtered out, resulting in empty word list -> 0.0
        String document = "Hello World";
        double score = calculator.calculateDocumentTfIdf(document);
        
        assertEquals("Non-Arabic input should return 0.0", 0.0, score, 0.0001);
    }
}
