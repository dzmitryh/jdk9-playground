package com.lgi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InputStream {
    public static void main(String[] args) {
        System.out.println(
                getDataFromIsJava8(ClassLoader.getSystemResourceAsStream("story.txt")));

        System.out.println();

        System.out.println(
                getDataFromIsJava9(ClassLoader.getSystemResourceAsStream("story.txt")));
    }

    private static String getDataFromIsJava9(java.io.InputStream is) {
        try {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getDataFromIsJava8(java.io.InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[8192];
        try {
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                baos.write(data, 0, nRead);
            }
            baos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(baos.toByteArray());
    }
}
