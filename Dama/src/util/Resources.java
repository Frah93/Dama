package util;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.imageio.ImageIO;
import util.sound.Sound;

/**
 * Resources è un gestore delle risorse interne di un'applicazione. La classe
 * fornisce diversi metodi per leggere, estrarre o riprodurre immagini, suoni o
 * testo
 *
 * @author Oneiros
 */
public class Resources {

    //La classe di riferimento dalla quale leggere le risorse
    static Class source = Resources.class;

    /**
     * Costruttore privato (Resources è una classe statica)
     */
    private Resources() {
    }

    /**
     * Imposta la classe di riferimento dalla quale leggere le risorse. La
     * classe di riferimento di default è Resources stessa.
     *
     * @param source la classe di riferimento dalla quale leggere le risorse
     */
    public static void setSourceClass(Class source) {
        Resources.source = source;
    }

    /**
     * Restituisce un'immagine presente nelle risorse dell'applicazione
     *
     * @param path Il path relativo dell'immagine (ad esempio:
     * "/path/myImage.png")
     * @return L'immagine corrispondente al path
     */
    public static BufferedImage getImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
            System.exit(-1);
        }
        return image;
    }

    /**
     * Restituisce un suono WAVE presente nelle risorse dell'applicazione
     *
     * @param path Il path relativo del suono (ad esempio: "/path/mySound.wav")
     * @return Il suono corrispondente al path
     */
    public static Sound getSound(String path) {
        Sound sound = null;
        try {
            //System.out.println("\n\n\n\n" + getResource(path).toURI() + "\n\n\n\n");
            //File file = new File(getResource(path).toURI());
            sound = new Sound(getResource(path));
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(-1);
        }
        return sound;
    }

    /**
     * Restituisce il testo contenuto in un file di testo (.txt) presente nelle
     * risorse dell'applicazione
     *
     * @param path Il path relativo del file di testo (ad esempio:
     * "/path/myText.txt")
     * @return Il testo contenuto nel file
     */
    public static String getText(String path) {

        StringBuilder builder = new StringBuilder();

        try {
            InputStream byteStream = getResourceAsStream(path);
            InputStreamReader txtStream = new InputStreamReader(byteStream, "ISO-8859-1");
            BufferedReader reader = new BufferedReader(txtStream);
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
            System.exit(-1);
        }

        return builder.toString();
    }

    /**
     * Estrae un file interno al jar nella stessa cartella del jar e ne
     * restituisce il path. Nel caso in cui il programma risulti non essere
     * eseguito da un jar ma da un file .class, il metodo ritorna direttamente
     * il path del file presente nelle risorse del file .class
     *
     * @param path Il path del file interno al jar
     * @return Il path del file estratto
     */
    public static File extract(String path) throws IOException {
        return extract(path, null);
    }

    /**
     * Estrae un file interno al jar nella cartella specificata e ne restituisce
     * il path. Nel caso in cui il programma risulti non essere eseguito da un
     * jar ma da un file .class, il metodo ritorna direttamente il path del file
     * presente nelle risorse del file .class
     *
     * @param source Il path del file interno al jar
     * @param destination Il path della cartella di destinazione
     * @return Il path del file estratto
     */
    public static File extract(String source, File destination) throws IOException {
        if (source.startsWith("/")) {
            source = source.substring(1);
        }
        File jarPath = getRunningSource();
        File homeDir = getHomeDir();
        if (destination == null) {
            destination = homeDir;
        }

        InputStream input = null;
        FileOutputStream output = null;
        try {
            if (isRunningFromJar()) {
                JarFile jar = new JarFile(jarPath);
                JarEntry sourceFile = jar.getJarEntry(source);
                String fileName = sourceFile.getName();
                fileName = fileName.substring(fileName.lastIndexOf("/"));
                input = jar.getInputStream(sourceFile);
                destination = new File(destination, fileName);
            } else {
                File sourceFile = new File(homeDir, source);
                input = new FileInputStream(sourceFile);
                destination = new File(destination, sourceFile.getName());
            }
            if (!destination.exists()) {
                destination.getParentFile().mkdirs();
                output = new FileOutputStream(destination);
                while (input.available() > 0) {
                    output.write(input.read());
                }
            }
        } finally {
            try {
                input.close();
                output.close();
            } catch (Exception e) {
            }
        }
        return destination;
    }

    /**
     * @return Restituisce la sorgente di esecuzione dell'applicazione
     */
    public static File getRunningSource() {
        CodeSource codeSource = source.getProtectionDomain().getCodeSource();
        try {
            return new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
            return null;
        }
    }

    /**
     * @return Restituisce il path dal quale si sta eseguendo l'applicazione
     */
    public static File getHomeDir() {
        File runningSource = getRunningSource();
        if (isRunningFromJar()) {
            return runningSource.getParentFile();
        }
        return runningSource;
    }

    /**
     * @return Restituisce una sottocartella al path dal quale si sta eseguendo l'applicazione
     */
    public static File getHomeSubDir(String sub) {
        File home = getHomeDir();
        return new File(home, sub);
    }

    /**
     * @return True se si sta eseguendo l'applicazione da un file .jar, False
     * altrimenti
     */
    public static boolean isRunningFromJar() {
        String className = Resources.class.getName().replace('.', '/');
        String classJar = Resources.class.getResource("/" + className + ".class").toString();
        return classJar.startsWith("jar:");
    }

    /**
     * Chiama il metodo getResource() sulla classe di riferimento
     *
     * @see java.lang.Class#getResource(java.lang.String)
     */
    public static URL getResource(String resource) {
        return Resources.source.getResource(resource);
    }

    /**
     * Chiama il metodo getResourceAsStream() sulla classe di riferimento
     *
     * @see java.lang.Class#getResourceAsStream(java.lang.String)
     */
    public static InputStream getResourceAsStream(String resource) {
        return Resources.source.getResourceAsStream(resource);
    }
}
