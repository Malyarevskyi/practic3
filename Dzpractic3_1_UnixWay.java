package practic.practic3;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Dzpractic3_1_UnixWay {
    public static void main(String[] args) {
        Path path = Paths.get("home/../var/./lib/../folder/./file.txt");

        System.out.println("full path: " + path);
        System.out.println("path normalize (short path): " + path.normalize());
    }
}
