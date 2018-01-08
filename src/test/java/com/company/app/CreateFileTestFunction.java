package com.company.app;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateFileTestFunction extends BaseClass {
        //Проверка существования файла в указанной директрии
        public boolean isExistedFileByName(Path pathToDirectory, String nameFile) {
                boolean flag = false;
                String listl[] = new File(pathToDirectory.toString()).list();
                for (String item : listl) {
                        if (item.contains(nameFile)) {
                                flag = true;
                                return flag;
                        }
                }
                return flag;
        }

        @Test(groups = { "positive" }, dataProviderClass = GeneratorName.class, dataProvider = "randomFileName")
        public void createTxtFile(String nameFile) {
                System.out.println("Positive 1 ");
                //String nameFile = "testTXT.txt";
                File file = new File(pathToDirectory.toString() + "/" + nameFile );
                try {
                        file.createNewFile();
                } catch (IOException e) {
                        // e.printStackTrace();
                }
                boolean isExistedFile = isExistedFileByName(pathToDirectory, nameFile);
                assertThat("TXT file was not created", isExistedFile, is(true));
        }

        /*@Test(groups = { "positive" }, dataProviderClass = GeneratorName.class, dataProvider = "randomFileName")
        public void createCsvFile(String nameFile) {
                System.out.println("Positive 2");
                //String nameFile = "testCSV.csv";
                File file = new File(pathToDirectory.toString() + "/" + nameFile + ".csv");
                try {
                        file.createNewFile();
                } catch (IOException e) {
                        // e.printStackTrace();
                }
                boolean isExistedFile = isExistedFileByName(pathToDirectory, nameFile);
                assertThat("CSV file was not created", isExistedFile, is(true));
        }*/

        @Test(groups = { "negative" }, alwaysRun = true, dataProviderClass = GeneratorName.class, dataProvider = "loadUserFromFile")
        public void createFileInNotExistedDirectory(String nameFile, String ext) {
                System.out.println("Negative 1");
                //String nameFile = "testWithoutDir.csv";
                File file = new File(nameFile + "/" + nameFile+ext);
                try {
                        file.createNewFile();
                } catch (IOException e) {
                        //  e.printStackTrace();
                }
                boolean isExistedFile = isExistedFileByName(pathToDirectory, nameFile+ext);
                assertThat("File was not created", isExistedFile, is(true));
        }

       /* @Test(groups = { "negative" }, alwaysRun = true)
        public void createNonValidNamedFile() {
                System.out.println("Negative 2");
                String nameFile = "& ; | * ? ' ` [ ] ( ) $ < > { } ^ #  / % !";
                File file = new File(pathToDirectory.toString() + "/" + nameFile);
                try {
                        file.createNewFile();
                } catch (IOException e) {
                        //e.printStackTrace();
                }
                boolean isExistedFile = isExistedFileByName(pathToDirectory, nameFile);
                assertThat("File was not created", isExistedFile, is(true));
        }*/

}
