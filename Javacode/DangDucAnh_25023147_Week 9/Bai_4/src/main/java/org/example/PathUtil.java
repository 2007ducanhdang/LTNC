package org.example;

import java.io.File;

public class PathUtil {
    public String buildPath(String folder, String file) {
        // Refactoring: Thay vì dùng "\\" cố định, dùng File.separator
        return folder + File.separator + file;
    }
}
