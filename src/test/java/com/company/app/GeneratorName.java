package com.company.app;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GeneratorName {
        //Генерация случайного номера в имени файла
        public static Object name(String ext) {
                return "test" + Integer.toString(new Random().nextInt()) + ext;
        }

        @DataProvider
        public static Iterator <Object[]> randomFileName() {
                List <Object[]> data = new ArrayList <>();
                data.add(new Object[]{ name(".txt") });
                data.add(new Object[]{ name(".csv") });
                return data.iterator();
        }

        @DataProvider
        public static Iterator <Object[]> loadUserFromFile() throws IOException {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        GeneratorName.class.getResourceAsStream("/names.data")));

                List <Object[]> nameData = new ArrayList <>();
                String line = in.readLine();
                while (line != null) {
                        nameData.add(line.split(";"));
                        line = in.readLine();
                }
                in.close();
                return nameData.iterator();
        }
}
