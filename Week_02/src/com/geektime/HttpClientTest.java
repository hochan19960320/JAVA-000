package com.geektime;

public class HttpClientTest {
    public static void main(String[] args) {
        String s = HttpUtils.get("http://localhost:8808/api/hello", null, null);
        System.out.println(s);
    }

}
