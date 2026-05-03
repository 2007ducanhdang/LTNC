package bank_system;

/**
 * Ngoại lệ chung trong hệ thống ngân hàng.
 */
public class BankException extends Exception {
    /**
     * Khởi tạo ngoại lệ.
     *
     * @param message thông báo lỗi
     */
    public BankException(String message) {
        super(message);
    }
}