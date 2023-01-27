package sem5.group.Presenter;

import sem5.group.Model.*;
import sem5.group.Console.View;

public class Presenter {
    View view;
    CalcModel model;
    double x;
    double y;

    public Presenter(CalcModel m, View v) {
        this.model = m;
        this.view = v;
    }

    public void buttonClick() {
        x = (view.getValue("X"));
        y = (view.getValue("Y"));
    }

    public void runOperation() {
        int choice = view.getChoice();
        this.buttonClick();
        switch (choice) {
            case 1 -> System.out.println(new SumCalc().result(x, y));
            case 2 -> System.out.println(new SubCalc().result(x, y));
            case 3 -> System.out.println(new MultCalc().result(x, y));
            case 4 -> System.out.println(new DivCalc().result(x, y));
        }
    }
}
