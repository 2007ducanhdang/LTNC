package bank_system;

import java.util.Locale;

/**
 * Đại diện cho một giao dịch.
 */
public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /** Khởi tạo giao dịch mới. */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /** Lấy kiểu giao dịch. */
    public int getType() {
        return type;
    }

    /** Đặt kiểu giao dịch. */
    public void setType(int type) {
        this.type = type;
    }

    /** Lấy số tiền. */
    public double getAmount() {
        return amount;
    }

    /** Đặt số tiền. */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Lấy số dư đầu. */
    public double getInitialBalance() {
        return initialBalance;
    }

    /** Đặt số dư đầu. */
    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    /** Lấy số dư cuối. */
    public double getFinalBalance() {
        return finalBalance;
    }

    /** Đặt số dư cuối. */
    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    /** Lấy tên kiểu giao dịch dưới dạng chuỗi. */
    public static String getTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
            default:
                return "Không rõ";
        }
    }

    /** In thông tin tóm tắt giao dịch chuẩn xác. */
    public String getTransactionSummary() {
        return String.format(Locale.US,
                "- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
                getTypeString(type), initialBalance, amount, finalBalance);
    }
}