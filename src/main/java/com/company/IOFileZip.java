package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IOFileZip {

    public void zipFiles(){
        Path dirToZip = Path.of("");
        Path zip = Path.of("/file.zip");
        try(ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zip))){
            out.setLevel(Deflater.DEFAULT_COMPRESSION);
            Files.walk(dirToZip).filter(currFile -> !Files.isDirectory(currFile)).forEach(p-> {
                ZipEntry zipEntry = new ZipEntry(p.relativize(dirToZip).toString());
                try{
                    out.putNextEntry(zipEntry);
                    out.write(Files.readAllBytes(p));
                    out.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
