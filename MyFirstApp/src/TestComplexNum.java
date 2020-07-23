import homework3.ComplexNum;
import java.util.Scanner;

public class TestComplexNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double d = in.nextDouble();
        ComplexNum x = new ComplexNum(a,b);
        ComplexNum y = new ComplexNum(c,d);
        ComplexNum.addComplexNum(x, y);    
        ComplexNum.divideComplexNum(x, y);
        ComplexNum.multComplexNum(x, y);
        ComplexNum.subtractComplexNum(x, y);
        System.out.printf("|%s + %si| = %s",ComplexNum.getOut(a),ComplexNum.getOut(b),ComplexNum.getOut(x.abs()));
        in.close();
    }
}