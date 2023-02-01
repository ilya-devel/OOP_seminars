package sem6.Homeworks.Calc.TypeData;

import sem6.Homeworks.Calc.TypeData.Interface.IDivision;
import sem6.Homeworks.Calc.TypeData.Interface.IMultiplication;
import sem6.Homeworks.Calc.TypeData.Interface.ISubtraction;
import sem6.Homeworks.Calc.TypeData.Interface.ISummarize;

import java.util.Scanner;

public class Rational extends BaseType implements ISummarize, IMultiplication, ISubtraction, IDivision {
    private double value;

    public Rational (String msg) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter " + msg + " rational digit > ");
        this.value = in.nextDouble();
    }

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
