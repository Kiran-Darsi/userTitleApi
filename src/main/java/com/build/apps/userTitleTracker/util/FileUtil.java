package com.build.apps.userTitleTracker.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    public static void writeListToFile(List<String> dataList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)))) {
            // Iterate through the list and write each item to a new line
            for (String item : dataList) {
                writer.write(item);
                writer.newLine(); // Add a newline character after each item
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
