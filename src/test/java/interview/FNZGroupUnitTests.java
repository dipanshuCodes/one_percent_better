package interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FNZGroupUnitTests {

    @Test
    public void A_uniqueProducts(){

        int[] tc1 = new int[] {2, 3, 3, 5, 5, 5, 8, 8};
        assertEquals(4, FNZGroup.uniqueProducts(tc1));
        int[] tc2 = new int[] {1,2,3};
        assertEquals(3, FNZGroup.uniqueProducts(tc2));

    }
}
