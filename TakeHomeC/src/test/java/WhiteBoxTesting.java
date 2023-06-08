import org.junit.Assert;
import org.junit.Test;

/*
Paths Coverage:
1. Test for the happy feeling as the only neighbor: [1, -1, 1]
    Expected: No exception

2. Test for no neighbors at the beginning: [-1, 1, 0, -1]
    Expected: IllegalArgumentException (no happy feelings as neighbors)

Decision/Condition Coverage:
3. Test for a happy feeling as the left neighbor: [1, -1, 0]
    Expected: No exception

4. Test for a happy feeling as the right neighbor: [0, -1, 1]
    Expected: No exception

Loop Coverage:
5. Test for multiple sad feelings surrounded by happy feelings: [1, -1, -1, 1]
    Expected: No exception
*/

public class WhiteBoxTesting {
    @Test
    public void testCheckNeighbours_HappyFeelingAsTheOnlyNeighbor() {
        Implementation solver = new Implementation();

        int[] array = {1, -1, 1};
        try {
            solver.checkNeighbours(1, array);
            Assert.assertTrue(true);
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected exception");
        }
    }

    @Test
    public void testCheckNeighbours_NoHappyNeighbors_NoNeighborsAtBeginning() {
        Implementation solver = new Implementation();

        int[] array = {-1, 1, 0, -1};
        try {
            solver.checkNeighbours(0, array);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testCheckNeighbours_HappyFeelingAsTheLeftNeighbor() {
        Implementation solver = new Implementation();

        int[] array = {1, -1, 0};
        try {
            solver.checkNeighbours(1, array);
            Assert.assertTrue(true);
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected exception");
        }
    }

    @Test
    public void testCheckNeighbours_HappyNeighbors_HappyFeelingAsTheRightNeighbor() {
        Implementation solver = new Implementation();

        int[] array = {0, -1, 1};
        try {
            solver.checkNeighbours(1, array);
            Assert.assertTrue(true);
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected exception");
        }
    }

    @Test
    public void testCheckNeighbours_MultipleSadFeelingsSurroundedByHappyFeelings() {
        Implementation solver = new Implementation();

        int[] array = {1, -1, -1, 1};
        try {
            solver.checkNeighbours(1, array);
            Assert.assertTrue(true);
        } catch (IllegalArgumentException e) {
            Assert.fail("Unexpected exception");
        }
    }
}
