package bank_system;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này đại diện cho tài khoản chung.
 */
public abstract class Account {
    public static final String CHECKING_TYPE = "CHECKING";
    public static final String SAVINGS_TYPE = "SAVINGS";

    private long accountNumber;
    private double balance;
    protected List<Transaction> transactionList;

    /**
     * Khởi tạo tài khoản.
     *
     * @param accountNumber số tài khoản
     * @param balance       số dư ban đầu
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    /** Lấy số tài khoản. */
    public long getAccountNumber() {
        return accountNumber;
    }

    /** Đặt số tài khoản. */
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    /** Lấy số dư. */
    public double getBalance() {
        return balance;
    }

    /** Đặt số dư. */
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    /** Lấy danh sách giao dịch. */
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    /** Đặt danh sách giao dịch. */
    public void setTransactionList(List<Transaction> transactionList) {
        if (transactionList == null) {
            this.transactionList = new ArrayList<>();
        } else {
            this.transactionList = transactionList;
        }
    }

    /** Phương thức nạp tiền. */
    public abstract void deposit(double amount);

    /** Phương thức rút tiền. */
    public abstract void withdraw(double amount);

    /** Thực hiện nạp tiền hợp lệ. */
    protected void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        balance += amount;
    }

    /** Thực hiện rút tiền hợp lệ. */
    protected void doWithdrawing(double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        balance -= amount;
    }

    /** Thêm một giao dịch vào lịch sử. */
    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionList.add(transaction);
        }
    }

    /** Lấy lịch sử giao dịch. */
    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
        for (int i = 0; i < transactionList.size(); i++) {
            sb.append(transactionList.get(i).getTransactionSummary());
            if (i < transactionList.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account other = (Account) obj;
        return this.accountNumber == other.accountNumber;
    }

    @Override
    public int hashCode() {
        return (int) (accountNumber ^ (accountNumber >>> 32));
    }
}