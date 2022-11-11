import java.util.*;

class Main {
    static int amount = 0;

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        mergeSort(numbers);
        System.out.println(amount);
    }

    public static Integer[] mergeSort(Integer[] array) {
        amount++;
        if(array.length == 1) {
            return array;
        }

        // Split Array
        Integer[] leftSide = splitArray(array, 0);
        Integer[] rightSide = splitArray(array, 1);

        // mergeSort
        mergeSort(leftSide);
        mergeSort(rightSide);

        // Return Sorted And Merged Array //
        return SortArray(mergeArray(leftSide, rightSide));
    }

    public static Integer[] splitArray(Integer[] array, int half) {
        // First half
        if(half == 0) {
            Integer[] halfArray = new Integer[Math.floorDiv(array.length, 2)];
            for(int i = 0; i < Math.floorDiv(array.length, 2); i++) {
                halfArray[i] = array[i];
            }
            return halfArray;
        }

        // Second half
        int length = array.length - Math.floorDiv(array.length, 2);
        Integer[] halfArray = new Integer[length];
        for(int i = 0; i < length; i++) {
            halfArray[i] = array[i+Math.floorDiv(array.length, 2)];
        }
        return halfArray;
    }

    public static Integer[] mergeArray(Integer[] a, Integer[] b) {
        int totalLength = a.length + b.length;
        Integer[] array = new Integer[totalLength];
        for(int i = 0; i < totalLength; i++) {
            if(i < a.length) {
                array[i] = a[i];
                continue;
            }
            array[i] = b[i-a.length];
        }
        return array;
    }

    public static Integer[] SortArray(Integer[] array) {
        Integer[] newArray = array.clone();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(newArray[i] < newArray[j]) {
                    newArray[i] = newArray[i] + newArray[j];
                    newArray[j] = newArray[i] - newArray[j];
                    newArray[i] = newArray[i] - newArray[j];
                }
            }
        }
        return newArray;
    }
}