package dev.josemc.essentials.configurations;

import dev.josemc.essentials.utils.JarUtils;

public class FileManager {

    public FileManager() {
        JarUtils.extractFormJar(".conf");
    }
}
