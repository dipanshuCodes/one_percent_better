package binarysearch.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAthMagicalNumberTest {

    FindAthMagicalNumber magicalNumber = new FindAthMagicalNumber();

    @Test
    public void testSampleCase() {
        assertEquals(2, magicalNumber.findAthMagicalNumber(1, 2, 3));
        assertEquals(6, magicalNumber.findAthMagicalNumber(4, 2, 3));
    }

    @Test
    public void testSmallInput() {
        assertEquals(2, magicalNumber.findAthMagicalNumber(1, 2, 3));
        assertEquals(3, magicalNumber.findAthMagicalNumber(2, 2, 3));
        assertEquals(4, magicalNumber.findAthMagicalNumber(3, 2, 3));
    }

    @Test
    public void testWithSameBAndC() {
        assertEquals(10, magicalNumber.findAthMagicalNumber(5, 2, 2));
        assertEquals(20, magicalNumber.findAthMagicalNumber(10, 2, 2));
    }

    @Test
    public void testCoprimeBAndC() {
        assertEquals(4, magicalNumber.findAthMagicalNumber(3, 2, 3));  // 2, 3, 4
        assertEquals(8, magicalNumber.findAthMagicalNumber(5, 2, 3));  // 2, 3, 4, 6, 8
        assertEquals(9, magicalNumber.findAthMagicalNumber(6, 2, 3));  // 2, 3, 4, 6, 8, 9
    }

    @Test
    public void testOneIsMultipleOfAnother() {
        assertEquals(25, magicalNumber.findAthMagicalNumber(5, 5, 10));
        assertEquals(30, magicalNumber.findAthMagicalNumber(6, 5, 10));
    }

}
