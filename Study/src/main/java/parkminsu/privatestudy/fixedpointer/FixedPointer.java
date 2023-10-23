package parkminsu.privatestudy.fixedpointer;

public class FixedPointer {
    public static void main(String[] args) {
        Fixed fixed = num -> Math.cos(num);

        double eof = 1e-6;
        double num = 1.0;
        System.out.println(calculatotFixedPoint(eof, num, fixed));

    }

    public static double calculatotFixedPoint(double eof, double num, Fixed fixed) {
        int loop = 10000;
        double num1 = num;
        for (int i = 0; i < loop; i++) {
            double num2 = fixed.calculate(num1);
            System.out.println(num2 - num1);
            System.out.println(eof);
            if (Math.abs(num2 - num1) < eof) {
                return num2;
            }
            num1 = num2;
        }
        throw new IllegalArgumentException("해당하는 식이 없음");
    }
}
