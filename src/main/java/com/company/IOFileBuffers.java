package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOFileBuffers {

    public void binaryModeManualBuffer() {
        try (InputStream in = new FileInputStream("");
             OutputStream out = new FileOutputStream("")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void characterModeManualBuffer() {
        try (Reader in = new FileReader("", StandardCharsets.UTF_8);
             Writer out = new FileWriter("", StandardCharsets.UTF_8)) {
            char[] buffer = new char[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void characterModeAutoBuffer() {
        try (BufferedReader in =
                     new BufferedReader(new InputStreamReader(new FileInputStream(""), StandardCharsets.UTF_8));
             PrintWriter out =
                     new PrintWriter(new OutputStreamWriter(new FileOutputStream(""), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
