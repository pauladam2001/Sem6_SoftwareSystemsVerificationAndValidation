import java.util.Arrays;

public class Implementation {
    public static void main(String[] args) {
        int[] array = {-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1};
        Implementation solver = new Implementation();
        int[] result = solver.beHappy(array);
        System.out.println(Arrays.toString(result));
    }

    public int findSadFeeling(int startingIndex, int[] array) {
        for (int i = startingIndex; i < array.length; i++) {
            if (array[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    public void checkNeighbours(int position, int[] array) {
        if ((position == 0 || array[position - 1] != 1) && (position == array.length - 1 || array[position + 1] != 1)) {
            throw new IllegalArgumentException("No happy feelings as neighbours");
        }
    }

    public void insertHappyFeelings(int position, int[] array) {
        int[] tempArray = Arrays.copyOf(array, array.length + 2);
        for (int i = tempArray.length - 1; i > position + 2; i--) {
            tempArray[i] = tempArray[i - 2];
        }
        tempArray[position] = 1;
        tempArray[position + 2] = 1;
        System.arraycopy(tempArray, 0, array, 0, array.length);
    }

    public int[] beHappy(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                int sadPosition = findSadFeeling(i, array);
                if (sadPosition != -1) {
                    checkNeighbours(sadPosition, array);
                    insertHappyFeelings(sadPosition, array);
                    i = sadPosition;
                }
            }
        }
        return array;
    }
}
