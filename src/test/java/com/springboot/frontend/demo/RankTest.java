package com.springboot.frontend.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RankTest {
    @Test
    public void testAH() {
        Assertions.assertEquals(1, getRank("abc"));
        Assertions.assertEquals(1, getRank("Abc"));
        Assertions.assertEquals(3, getRank("xxx"));
        Assertions.assertEquals(3, getRank("Xxx"));
        Assertions.assertEquals(3, getRank("Xxx"));
    }

    private int getRank(String name) {
        String[] patterns = {"^[A-Ha-h].*$", "^[I-Qi-q].*$", "^[R-Zr-z].*$"};
        for (int i = 0; i < patterns.length; i++) {
            if (name.matches(patterns[i])) {
               return i + 1;
            }
        }
        return 0;
    }
}
