package sem6.Homeworks.Calc.TypeData;

/*
* Создал базовый класс типа вычислений
* от которого наследуют классы Complex Rational
* и разбил общий интерфейс на 4 для каждой операции
* */

import sem6.Homeworks.Calc.TypeData.Interface.IDivision;
import sem6.Homeworks.Calc.TypeData.Interface.IMultiplication;
import sem6.Homeworks.Calc.TypeData.Interface.ISubtraction;
import sem6.Homeworks.Calc.TypeData.Interface.ISummarize;

public class BaseType implements IMultiplication, IDivision, ISubtraction, ISummarize {
    @Override
    public void division(Object obj) {

    }

    @Override
    public void multiplication(Object obj) {

    }

    @Override
    public void subtraction(Object obj) {

    }

    @Override
    public void summarize(Object obj) {

    }
}
