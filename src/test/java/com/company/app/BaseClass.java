package com.company.app;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseClass {
        Path pathToDirectory;
        @BeforeMethod(alwaysRun = true)
        public Path createDirectory() throws IOException {
                // real direcrory
                //File path = new File("/Users/anastasiadanilkina/Desktop/my-app/src/test/testDirectory");
                // directory.mkdir();
                //temp directory
                //get the default temporary folders path
                //String default_tmp = System.getProperty("java.io.tmpdir");
                //System.out.println(default_tmp);
                pathToDirectory = Files.createTempDirectory("test");
                //System.out.println("TMP: " + pathToDirectory.toString());
                return this.pathToDirectory;
        }
        @AfterMethod(alwaysRun = true)
        public void deleteDirectory() {
                if (pathToDirectory != null) {
                        try {
                                FileUtils.cleanDirectory(new File(pathToDirectory.toString()));
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                        // System.out.println("TMP: " + pathToDirectory);
                        File directory = new File(pathToDirectory.toString());
                        boolean deleted = directory.delete();
                        if (deleted) {
                                //System.out.println("Yes!");
                        } else
                                System.out.println("No");
                }
        }
}
