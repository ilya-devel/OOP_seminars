package sem6.Homeworks.Calc.TypeData;

import sem6.Homeworks.Calc.TypeData.Interface.IDivision;
import sem6.Homeworks.Calc.TypeData.Interface.IMultiplication;
import sem6.Homeworks.Calc.TypeData.Interface.ISubtraction;
import sem6.Homeworks.Calc.TypeData.Interface.ISummarize;

import java.util.Scanner;

public class Complex extends BaseType implements IMultiplication, ISubtraction, ISummarize, IDivision {
    private double real;
    private double image;

    public Complex(String msg) {
        System.out.println(msg);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter real values > ");
        this.real = in.nextDouble();
        System.out.print("Enter image values > ");
        this.image = in.nextDouble();
    }

    public Complex(double r, double i) {
        this.real = r;
        this.image = i;
    }


    public double getReal() {
        return real;
    }

    public double getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "(" + real + ") + (" + image + "i)";
    }

    @Override
    public void summarize(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.real += ((Complex) other).getReal();
            this.image += ((Complex) other).getImage();
        }
    }

    @Override
    public void subtraction(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.real -= ((Complex) other).getReal();
            this.image -= ((Complex) other).getImage();
        }
    }

    @Override
    public void multiplication(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.real *= ((Complex) other).getReal();
            this.image *= ((Complex) other).getImage();
        }
    }

    @Override
    public void division(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.real /= ((Complex) other).getReal();
            this.image /= ((Complex) other).getImage();
        }
    }
}
