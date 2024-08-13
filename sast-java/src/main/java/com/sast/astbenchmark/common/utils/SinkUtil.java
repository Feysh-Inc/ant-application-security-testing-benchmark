package com.sast.astbenchmark.common.utils;


import java.io.IOException;

public class SinkUtil {
    public static void sink(Object param) {
        try {
            Runtime.getRuntime().exec(param.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
