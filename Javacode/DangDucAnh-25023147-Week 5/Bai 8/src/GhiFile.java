import java.io.*;
import java.util.Scanner;

public class GhiFile {
    public static void main(String[] args) {
        File file = new File("Bai 8/src/numbers.dat");
        Scanner scanner = new Scanner(System.in);
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                dos.writeInt(scanner.nextInt());
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
