package sem5.group;

import sem5.group.Console.View;
import sem5.group.Model.SumCalc;
import sem5.group.Presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        Presenter app = new Presenter(new SumCalc(), new View());
        app.runOperation();
    }
}
