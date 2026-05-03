package bank_system;

/**
 * Tài khoản vãng lai.
 */
public class CheckingAccount extends Account {
    /**
     * Khởi tạo tài khoản vãng lai.
     *
     * @param accountNumber số tài khoản
     * @param balance       số dư ban đầu
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance, finalBalance);
            addTransaction(t);
        } catch (BankException e) {
            // Bỏ qua ngoại lệ
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            doWithdrawing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance, finalBalance);
            addTransaction(t);
        } catch (BankException e) {
            // Bỏ qua ngoại lệ
        }
    }
}