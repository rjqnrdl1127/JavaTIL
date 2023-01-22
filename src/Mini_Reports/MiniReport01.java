package Mini_Reports;

public class MiniReport01 {

    public static void main(String[] args) {
        String format;  //

        System.out.println(" [구구단 출력] ");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                format = String.format("%02d x %02d = %02d   ", j, i, i *j);
                System.out.print(format);

                if (j == 9) System.out.print("\n");
            }
        }
    }
}
