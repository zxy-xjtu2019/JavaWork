package homework3;

import java.math.BigDecimal;

public class ComplexNum {
    private double a,b;

    //create class
    public ComplexNum(double a,double b){
        this.a = a;
        this.b = b;
    }
    public ComplexNum(double a){
        this(a,0);
    }
    public ComplexNum(ComplexNum x){
        a = x.a;
        b = x.b;
    }
    public ComplexNum(){
        this.a = 0;
        this.b = 0;
    }
    //
    public String toString(){
        return getOut(a)+" + "+getOut(b)+"i";
    }
    public String getRealPart(){
        return getOut(a);
    }
    public String getImaginaryPart(){
        return getOut(b);
    }
    public double abs(){
        return Math.sqrt(a*a+b*b);
    }
    public static String getOut(double x){
        BigDecimal a = new BigDecimal(String.valueOf(x));
        BigDecimal aa = a.stripTrailingZeros();
        return aa.toPlainString();
    }
    public void show(){
        if(this.a!=0&&this.b!=0)System.out.printf("%s + %si",getOut(a),getOut(b));
        if(this.a==0&&this.b!=0)System.out.printf("%si",getOut(b));
        if(this.a!=0&&this.b==0)System.out.printf("%s",getOut(a));
        if(this.a==0&&this.b==0)System.out.printf("0");
    }
    public static void addComplexNum(ComplexNum x,ComplexNum y){
        x.show();
        System.out.print(" + ");
        y.show();
        System.out.print(" = ");
        ComplexNum z = new ComplexNum(x.a+y.a,x.b+y.b);
        z.show();
        System.out.println();
    }
    public static void subtractComplexNum(ComplexNum x,ComplexNum y){
        x.show();
        System.out.print(" - ");
        y.show();
        System.out.print(" = ");
        ComplexNum z = new ComplexNum(x.a-y.a,x.b-y.b);
        z.show();
        System.out.println();
    }
    public static void multComplexNum(ComplexNum x,ComplexNum y){
        x.show();
        System.out.print(" × ");
        y.show();
        System.out.print(" = ");
        ComplexNum z = new ComplexNum(x.a*y.a-y.b*x.b,x.a*y.b+y.a*x.b);
        z.show();
        System.out.println();
    }
    public static void divideComplexNum(ComplexNum x,ComplexNum y){
        x.show();
        System.out.print(" ÷ ");
        y.show();
        System.out.print(" = ");
        ComplexNum z = new ComplexNum((x.a*y.a+y.b*x.b)/(y.a*y.a+y.b*y.b),(x.b*y.a-y.b*x.a)/(y.a*y.a+y.b*y.b));
        z.show();
        System.out.println();
    }

}