package com.LucaSteam.utilities;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DocumentRead {
    public static ArrayList<String> InicialData (String path) {
        Path path1 = Paths.get(path);
        ArrayList<String> ToReturn = new ArrayList<>();
        try {
            List<String> line = Files.readAllLines(path1, StandardCharsets.UTF_8);
            for (int i = 0; i < line.size(); i++) {
                ToReturn.add(line.get(i));
            }
        } catch (IOException ex){
            ex.printStackTrace();
            System.err.println("I/O error: " + ex);
        }
        return ToReturn;
    }

    public static void SaveData(String path, ArrayList<String> toWrite) {
        Path path1 = Paths.get(path);
        try {
            BufferedWriter bw = Files.newBufferedWriter(path1, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            for (int i = 0; i < toWrite.size(); i++) {
                bw.write(toWrite.get(i));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Terminado de guardar");
        } catch (IOException io) {
            System.err.println(io);
        }
    }

    public static void SaveDataTest(String path, ArrayList<String> toWrite) {
        Path path1 = Paths.get(path);
        try {
            BufferedWriter bw = Files.newBufferedWriter(path1, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            for (int i = 0; i < toWrite.size(); i++) {
                if (toWrite.get(i).contains(",")){
                    bw.write(toWrite.get(i));
                    bw.newLine();
                } else {
                    bw.write("");
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
            System.out.println("Terminado de guardar");
        } catch (IOException io) {
            System.err.println("I/O" + io);
        }
    }
}

