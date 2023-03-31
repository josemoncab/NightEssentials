package dev.josemc.essentials.utils;

import dev.josemc.essentials.Essentials;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Class with methods related to manipulate files inside plugin jar
 * */
public final class JarUtils {

    /**
     * Utility class
     * */
    private JarUtils() {
        throw new UnsupportedOperationException("Utility Class");
    }
    private static Essentials instance = Essentials.get();

    /**
     * Get all file paths from the jar.
     *
     * @param filter String used to search in jar files
     *
     * @return List of paths of th resources found
     */
    private static ArrayList<String> getFromJar(String filter) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Enumeration<JarEntry> entries = new JarFile(JarUtils.class.getProtectionDomain().getCodeSource().getLocation().getFile()).entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(filter) && !entry.getName().equals("plugin.yml")) {
                    list.add(entry.getName());
                }
            }
        } catch (IOException e) {
            instance.getLogger().severe("Error occur when trying to search for file in the plugin jar: \n" + e.getLocalizedMessage());
        }
        return list;
    }

    /**
     * Extract the resources matching the filter inside the plugins jar to the plugins folder
     * */
    public static void extractFormJar(String filter) {
        JarUtils.getFromJar(filter).forEach(fileString -> {
            Path destPath = Path.of(instance.getDataFolder().getPath(), fileString);
            File file = new File(destPath.toUri());
            file.getParentFile().mkdirs();
            if (!file.exists()) {
                try {
                    Files.copy(JarUtils.class.getResourceAsStream("/" + fileString), destPath);
                } catch (IOException e) {
                    instance.getLogger().severe("Error while creating file " + file + ": \n" + e);
                }
            }
        });
    }
}
