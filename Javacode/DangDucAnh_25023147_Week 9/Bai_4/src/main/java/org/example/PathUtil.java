package org.example;

import java.nio.file.Paths;

public class PathUtil {
    public String buildPath(String folder, String file) {
        // Hệ thống sẽ tự động sinh ra dấu \ (nếu là Windows) hoặc / (nếu là Linux/Mac)
        return Paths.get(folder, file).toString();
    }
}
