package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathUtilTest {

    @Test
    public void testBuildPath() {
        PathUtil util = new PathUtil();
        String actualPath = util.buildPath("logs", "app.log");

        // CỐ TÌNH GÂY LỖI: Cứng nhắc đòi kết quả phải giống Windows
        String expectedPath = "logs\\app.log";

        assertEquals(expectedPath, actualPath, "Đường dẫn phải khớp hoàn toàn!");
    }
}