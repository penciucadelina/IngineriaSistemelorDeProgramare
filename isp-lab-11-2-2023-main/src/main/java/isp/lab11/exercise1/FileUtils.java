package isp.lab11.exercise1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * @author Radu Miron
 * @version 1
 */
public class FileUtils {
    private static final File MESSAGES_DIR = new File("messages");

    private FileUtils() {
    }

    public static void writeMessageToFile(String aircraftId, String message) {
        Path aircraftMessageFile = new File(MESSAGES_DIR, aircraftId + ".txt").toPath();
        try {
            if (Files.exists(aircraftMessageFile))
                Files.writeString(aircraftMessageFile, message + "\n", StandardOpenOption.APPEND);
            else {
                Files.writeString(aircraftMessageFile, message + "\n", StandardOpenOption.CREATE_NEW);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
