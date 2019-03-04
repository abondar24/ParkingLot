package org.abondar.industrial.parkinglot.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParserUtil {

    public static List<String[]> parseFile(InputStream is) {

        List<String[]> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.lines()
                .forEach(l -> {

                    String[] data = l.split(" ");

                    lines.add(data);
                });
        return lines;
    }
}
