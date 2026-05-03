package bank_system;

/**
 * Tài khoản tiết kiệm thuc thi cac quy dinh ve rut tien và nap tien.
 */
public class SavingsAccount extends Account {
    public static final double MAX_WITHDRAW = 1000.0;
    public static final double MIN_BALANCE = 5000.0;

    /** Khởi tạo tài khoản tiết kiệm. */
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(t);
        } catch (BankException e) {
            // Bỏ qua ngoại lệ
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            if (amount > MAX_WITHDRAW) {
                throw new InvalidFundingAmountException(amount);
            }
            if (initialBalance - amount < MIN_BALANCE) {
                throw new InsufficientFundsException(amount);
            }
            doWithdrawing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(
                    Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(t);
        } catch (BankException e) {
            // Bỏ qua ngoại lệ
        }
    }
}