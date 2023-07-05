package JavaBasicProgram;

public class Pattern {
    public static void main(String[] args) {
        tamGiacCan();
    }

    public static void tamGiacNguoc() {
        for (int i = 5; i > 0; i--) {
            for (int y = 0; y < 6; y++) {
                if (y >= i) {
                    System.out.print("*");
                } else
                    System.out.print(" ");

            }
            System.out.println("");
        }
    }

    public static void tamGiacCan() {
        int i, j, row = 6;

        for (i = 0; i < row; i++) {
            for (j = row - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


}
