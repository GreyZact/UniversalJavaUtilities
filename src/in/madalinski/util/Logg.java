/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.madalinski.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wrapper for Logger
 *
 * @author mike
 */
public class Logg {

    private static Logg instance;
    private final String filePath = "app.log";
    private boolean writeToFile = true;
    private static FileExplorer fileExplorer;
    private int logLevel = 0;
    /**
     * A private Constructor prevents any other class from instantiating.
     */
    private Logg() {
        // nothing to do this time
    }

    /**
     * The Static initializer constructs the instance at class loading time;
     * this is to simulate a more involved construction process (it it were
     * really simple, you'd just use an initializer)
     */
    static {
        instance = new Logg();
        Logg.fileExplorer = new FileExplorer();
    }

    /**
     * Static 'instance' method
     *
     * @return instance
     */
    public static Logg getInstance() {
        return instance;
    }
    
    public boolean isWriteToFile() {
        return writeToFile;
    }

    public void setWriteToFile(boolean writeToFile) {
        this.writeToFile = writeToFile;
    }

    public int getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    public void printALL(String message) {
        print(message, Level.ALL);
    }

    public void printCONFIG(String message) {
        print(message, Level.CONFIG);
    }

    public void printFINE(String message) {
        print(message, Level.FINE);
    }

    public void printFINEST(String message) {
        print(message, Level.FINEST);
    }

    public void printINFO(String message) {
        print(message, Level.INFO);
    }

    public void printOFF(String message) {
        print(message, Level.OFF);
    }

    public void printSEVERE(String message) {
        print(message, Level.SEVERE);
    }

    public void printWARNING(String message) {
        print(message, Level.WARNING);
    }

    public void print(String message, Level level) {
        // Log only if Level is high enought
        if (logLevel < level.intValue()) {
            //  Log to console
            Logger.getLogger(FileExplorer.class.getName()).log(level, message);
            //  Save to file
            if (writeToFile) {
                fileExplorer.push(filePath, getTime() + "[" + level.toString() + "] " + message);
            }
        }
    }

    private String getTime() {
        return String.valueOf(new SimpleDateFormat("yyyy-MM-dd' T'HH:mm:ss.SSSXXX").format(Calendar.getInstance().getTime())) + " > ";
    }
}
