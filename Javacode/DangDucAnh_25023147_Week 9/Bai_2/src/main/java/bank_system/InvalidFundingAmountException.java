package bank_system;

import java.util.Locale;

/**
 * Ngoại lệ khi số tiền giao dịch không hợp lệ.
 */
public class InvalidFundingAmountException extends BankException {
    /**
     * Khởi tạo ngoại lệ.
     *
     * @param amount số tiền
     */
    public InvalidFundingAmountException(double amount) {
        super(String.format(Locale.US, "Số tiền không hợp lệ: $%.2f", amount));
    }
}