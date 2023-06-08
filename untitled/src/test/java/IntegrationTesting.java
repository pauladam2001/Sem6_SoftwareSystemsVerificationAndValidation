import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
Integration Test Cases - Component Integration Testing:

1. Test with no sad feelings in the array: [1, 0, 1]
    Expected output: [1, 0, 1]

2. Test with a single sad feeling in the array: [1, -1, 0, 1]
    Expected output: [1, -1, 1, 0, 1]

3. Test with multiple sad feelings in the array: [1, -1, 0, -1, 1]
    Expected output: [1, -1, 1, 0, -1, 1]
*/

public class IntegrationTesting {
    @Test
    public void testBeHappy() {
        Implementation solver = new Implementation();

        int[] array1 = {1, 0, 1};
        int[] expected1 = {1, 0, 1};
        Assert.assertTrue(Arrays.equals(expected1, solver.beHappy(array1)));

        int[] array2 = {1, -1, 0, 1};
        int[] expected2 = {1, -1, 1, 0, 1};
        Assert.assertTrue(Arrays.equals(expected2, solver.beHappy(array2)));

        int[] array3 = {1, -1, 0, -1, 1};
        int[] expected3 = {1, -1, 1, 0, -1, 1};
        Assert.assertTrue(Arrays.equals(expected3, solver.beHappy(array3)));
    }
}
