
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTest {
                        // tests for equals()

    @Test
    public void testEqualsWithStringLiteralsAndStringObjectWithDifferentValue() throws Exception {
        String name1 = "Kunal";
        String name2 = new String("Swamiji");
        boolean result = name1.equals(name2);
        assertEquals(false, result);
    }

    @Test
    public void testEqualsWithStringLiteralsAndStringObjectWithSameValue() throws Exception {
        String name1 = "Kunal";
        String name2 = new String("Kunal");
        boolean result = name1.equals(name2);
        assertEquals(true, result);
    }

    @Test
    public void testEqualsWithTwoStringLiteralsHavingSameValue() throws Exception {
        String name1 = "Kunal";
        String name2 = "Kunal";

        boolean result = name1.equals(name2);
        assertEquals(true, result);
    }

    @Test
    public void testEqualsWithTwoStringLiteralsHavingDifferentValue() throws Exception {
        String name1 = "Kunal";
        String name2 = "Swamiji";
        boolean result = name1.equals(name2);
        assertEquals(false, result);
    }

    @Test
    public void testEqualsWithTwoStringObjectsHavingSameValue() throws Exception {
        String name1 = new String("Kunal");
        String name2 = new String("Kunal");

        boolean result = name1.equals(name2);
        assertEquals(true, result);
    }

    @Test
    public void testEqualsWithTwoStringObjectsHavingDifferentValue() throws Exception {
        String name1 = new String("Kunal");
        String name2 = new String("Swamiji");
        boolean result = name1.equals(name2);
        assertEquals(false, result);
    }

                        //tests for == operator
    @Test
    public void testEqualsOperatorWithStringLiteralsAndStringObjectWithSameValue() throws Exception {
        String name1 = "Kunal";
        String name2 = new String("Kunal");
        boolean result = name1 == name2;
        assertEquals(false, result);
    }

    @Test
    public void testEqualsOperatorWithStringLiteralsAndStringObjectWithDifferentValue() throws Exception {
        String name1 = "Kunal";
        String name2 = new String("Swamiji");
        boolean result = name1 == name2;
        assertEquals(false, result);
    }

    @Test
    public void testEqualsOperatorWithTwoStringLiteralsHavingSameValue() throws Exception {
        String name1 = "Kunal";
        String name2 = "Kunal";
        boolean result = name1 == name2;
        assertEquals(true, result);
    }

    @Test
    public void testEqualsOperatorWithTwoStringLiteralsHavingDifferentValue() throws Exception {
        String name1 = "Kunal";
        String name2 = "Swamiji";
        boolean result = name1 == name2;
        assertEquals(false, result);
    }

    @Test
    public void testEqualsOperatorWithTwoStringObjectsHavingSameValue() throws Exception {
        String name1 = new String("Kunal");
        String name2 = new String("Kunal");
        boolean result = name1 == name2;
        assertEquals(false, result);
    }

    @Test
    public void testEqualsOperatorWithTwoStringObjectsHavingDifferentValue() throws Exception {
        String name1 = new String("Kunal");
        String name2 = new String("Swamiji");
        boolean result = name1 == name2;
        assertEquals(false, result);
    }
}