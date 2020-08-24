package HomeWork14;

public class Test {

    public static void fillArray(int[] ints){
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random()*10+1);
            System.out.print(ints[i] + " ");
        }
        System.out.println(" ");
    }

    public static void bubbleSort(int[] ints){

        for (int i = 0; i < ints.length-1; i++) {
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println(" ");
    }

    public static void binarySearch(int[] ints, int elementValue){
        int firstElement = 0;
        int lastElement = ints.length - 1;
        int index = -1;
        while (firstElement <= lastElement) {
            int mid = (firstElement + lastElement) / 2;
            if (ints[mid] > elementValue)
                lastElement = mid - 1;
            else if (ints[mid] < elementValue)
                firstElement = mid + 1;
            else if (ints[mid] == elementValue) {
                index = mid;
                System.out.println(index);
                return;
            }

        }
        System.out.println(index);
    }

    public static void main(String[] args) {

        int[] ints = new int[15];

        fillArray(ints);
        bubbleSort(ints);
        binarySearch(ints, 6);
    }
}