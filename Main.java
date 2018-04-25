
public class Main {
    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4, 5};
        System.out.println(occurrences(input, 5));

    }

    private static int occurrences(int[] x, int y){
        int r = 0;
        for (int number = 0; number < 5; number++){
            if (x[number] == y) {
                r = r + 1;
            }
        }
        return r;
    }
}
