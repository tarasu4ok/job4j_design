package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                stringBuilder.append(i)
                        .append(" * ")
                        .append(j)
                        .append(" = ")
                        .append(i * j)
                        .append(System.lineSeparator());
            }
            stringBuilder.append(System.lineSeparator());
        }

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(stringBuilder.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}