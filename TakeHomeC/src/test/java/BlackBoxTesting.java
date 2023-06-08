import org.junit.Assert;
import org.junit.Test;

/*
Equivalence Classes:
1. Test for no sad feeling in the array: [0, 1, 0, 1, 0]
    Expected output: -1 (no sad feeling found)

2. Test for a single sad feeling in the array: [0, -1, 1, 0]
    Expected output: 1 (index of the first sad feeling)

3. Test for multiple sad feelings in the array: [-1, 0, -1, 1, -1, 0]
    Expected output: 0 (index of the first sad feeling)

Boundary Value Analysis:
4. Test for the first element being a sad feeling: [-1, 0, 1, 0]
    Expected output: 0 (index of the first sad feeling)

5. Test for the last element being a sad feeling: [0, 1, 0, -1]
    Expected output: 3 (index of the first sad feeling)
*/

public class BlackBoxTesting {
    @Test
    public void testFindSadFeeling_NoSadFeeling() {
        Implementation solver = new Implementation();

        int[] array = {0, 1, 0, 1, 0};
        Assert.assertEquals(-1, solver.findSadFeeling(0, array));
    }

    @Test
    public void testFindSadFeeling_SingleSadFeeling() {
        Implementation solver = new Implementation();

        int[] array = {0, -1, 1, 0};
        Assert.assertEquals(1, solver.findSadFeeling(0, array));
    }

    @Test
    public void testFindSadFeeling_MultipleSadFeelings() {
        Implementation solver = new Implementation();

        int[] array = {-1, 0, -1, 1, -1, 0};
        Assert.assertEquals(0, solver.findSadFeeling(0, array));
    }

    @Test
    public void testFindSadFeeling_FirstElementSadFeeling() {
        Implementation solver = new Implementation();

        int[] array = {-1, 0, 1, 0};
        Assert.assertEquals(0, solver.findSadFeeling(0, array));
    }

    @Test
    public void testFindSadFeeling_LastElementSadFeeling() {
        Implementation solver = new Implementation();

        int[] array = {0, 1, 0, -1};
        Assert.assertEquals(3, solver.findSadFeeling(0, array));
    }
}
