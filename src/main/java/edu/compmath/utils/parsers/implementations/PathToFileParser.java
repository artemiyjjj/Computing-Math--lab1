package edu.compmath.utils.parsers.implementations;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class PathToFileParser {

    public static Optional<Path> resolvePath(String pathToFile) {
        try {
            Path path = Paths.get(pathToFile);
            boolean isAbsolute = path.isAbsolute();
            if (!isAbsolute) {
                path = Paths.get("").relativize(path);
            }
            if (Files.exists(path)) {
                return Optional.of(path);
            }
            else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
