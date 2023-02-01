package sem6.Homeworks.Calc;

import sem6.Homeworks.Calc.TypeData.BaseType;
import sem6.Homeworks.Calc.TypeData.Complex;
import sem6.Homeworks.Calc.TypeData.Rational;
import sem6.Homeworks.Calc.View.View;

public class ControlMethods {
    BaseType num1;
    BaseType num2;
    boolean status = true;
    boolean getAns = true;
    View view = new View();

    public void runOperation() {
        while (getAns) {
            int choice = view.choiceTypeValues();
            switch (choice) {
                case 1 -> {
                    num1 = new Rational("first");
                    num2 = new Rational("second");
                }
                case 2 -> {
                    num1 = new Complex("First number");
                    num2 = new Complex("Second number");
                }
                case 3 -> this.status = false;
                default -> this.getAns = false;
            }
            if (!this.status) break;
            if (!this.getAns) {
                this.getAns = true;
                continue;
            }
            choice = view.choiceOperation();
            switch (choice) {
                case 1 -> num1.summarize(num2);
                case 2 -> num1.subtraction(num2);
                case 3 -> num1.multiplication(num2);
                case 4 -> num1.division(num2);
                case 5 -> this.getAns = false;
            }
            if (!this.getAns) {
                this.getAns = true;
            } else {
                view.showResult(num1.toString());
            }

        }
    }
}
