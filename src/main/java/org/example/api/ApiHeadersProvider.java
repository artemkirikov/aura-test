package org.example.api;

import java.util.HashMap;
import java.util.Map;

public class ApiHeadersProvider {
    public static Map<String, String> defaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Accept-Encoding", "gzip, deflate, br, zstd");
        headers.put("Accept-Language", "en-US,en;q=0.5");
        headers.put("Connection", "keep-alive");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:...)" );
        headers.put("Cookie", "adminjs=s%3AS1ZXBffD0E_S4ToRXmyLy12gLSRs5Beg.dqvU3Og%2B1T6bKNZZ9Q0rl4vdC0MyMFtaJsoxN58ggPY");
        return headers;
    }
} 