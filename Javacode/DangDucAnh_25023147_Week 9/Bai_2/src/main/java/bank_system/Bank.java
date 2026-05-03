package bank_system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Đại diện cho ngân hàng.
 */
public class Bank {
    private List<Customer> customerList;

    /** Khởi tạo ngân hàng. */
    public Bank() {
        this.customerList = new ArrayList<>();
    }

    /** Lấy danh sách khách hàng. */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Đặt danh sách khách hàng.
     *
     * @param customerList danh sách khách hàng
     */
    public void setCustomerList(List<Customer> customerList) {
        if (customerList == null) {
            this.customerList = new ArrayList<>();
        } else {
            this.customerList = customerList;
        }
    }

    /** Đọc dữ liệu khách hàng từ InputStream. */
    public void readCustomerList(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer current = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                int last = line.lastIndexOf(' ');
                if (last <= 0) {
                    continue;
                }
                String token = line.substring(last + 1).trim();
                if (token.matches("\\d{9}")) {
                    String name = line.substring(0, last).trim();
                    current = new Customer(Long.parseLong(token), name);
                    customerList.add(current);
                } else if (current != null) {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 3) {
                        long num = Long.parseLong(parts[0]);
                        double bal = Double.parseDouble(parts[2]);
                        if (Account.CHECKING_TYPE.equals(parts[1])) {
                            current.addAccount(new CheckingAccount(num, bal));
                        } else if (Account.SAVINGS_TYPE.equals(parts[1])) {
                            current.addAccount(new SavingsAccount(num, bal));
                        }
                    }
                }
            }
        } catch (Exception e) {
            // Bỏ qua lỗi trong quá trình đọc
        }
    }

    /** Trả về chuỗi thông tin khách hàng xếp theo ID. */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            res.append(customerList.get(i).getCustomerInfo());
            if (i < customerList.size() - 1) {
                res.append("\n");
            }
        }
        return res.toString();
    }

    /** Trả về chuỗi thông tin khách hàng xếp theo Tên. */
    public String getCustomersInfoByNameOrder() {
        List<Customer> copy = new ArrayList<>(customerList);
        copy.sort((c1, c2) -> {
            int res = c1.getFullName().compareTo(c2.getFullName());
            return res != 0 ? res : Long.compare(c1.getIdNumber(), c2.getIdNumber());
        });

        StringBuilder sb = new StringBuilder();
        for (Customer c : copy) {
            sb.append(c.getCustomerInfo()).append("\n");
        }
        return sb.toString().trim();
    }
}