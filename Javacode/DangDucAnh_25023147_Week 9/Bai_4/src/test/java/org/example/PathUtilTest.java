package org.example;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class PathUtilTest {

    @Test
    public void testBuildPath() {
        PathUtil util = new PathUtil();
        String actualPath = util.buildPath("logs", "app.log");

        // Refactoring: Kỳ vọng kết quả linh hoạt theo hệ điều hành
        String expectedPath = "logs" + File.separator + "app.log";

        assertEquals(expectedPath, actualPath, "Đường dẫn đã chuẩn Cross-platform!");
    }
}