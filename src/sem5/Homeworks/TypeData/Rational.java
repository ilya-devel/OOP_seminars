package sem5.Homeworks.TypeData;

import java.util.Scanner;

public class Rational implements IMainOperation{
    private double value;

    public Rational (String msg) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter " + msg + " rational digit > ");
        this.value = in.nextDouble();
    }

//    public void summary(Rational other) {
//        this.value += other.getValue();
//    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public void summarize(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.value += ((Rational) other).value;
        }
    }

    @Override
    public void subtraction(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.value -= ((Rational) other).value;
        }
    }

    @Override
    public void multiplication(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.value *= ((Rational) other).value;
        }
    }

    @Override
    public void division(Object other) {
        if (other.getClass().equals(this.getClass())) {
            this.value /= ((Rational) other).value;
        }
    }
}
