package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class FilesWalk {

    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.walk(Path.of("./src"))) {
            var totalCodeLines = stream.filter(Files::isRegularFile)
                    .filter(file -> file.getFileName().toString().endsWith(".java"))
                    .flatMap(file -> {
                        try {
                            return Files.lines(file);
                        } catch (IOException e) {
                            return Stream.empty();
                        }
                    })
                    .filter(line -> !line.isBlank() && !line.startsWith("package") && !line.startsWith("import"))
                    .count();
            System.out.printf("Java Code Lines: %d",totalCodeLines);
        }
    }

}
