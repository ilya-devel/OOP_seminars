package sem6.tsk1.Account;

public class SalaryAccount extends Account{
    @Override
    public void showBalance(String numberAccount) {
        super.showBalance(numberAccount);
    }

    @Override
    public void refIll(String numberAccount, String sum) {
        super.refIll(numberAccount, sum);
    }

    public void payment(String numberAccount, String sum) {
        System.out.println();
    }
}
