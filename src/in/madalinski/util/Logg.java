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

    private final String filePath = "app.log";
    private boolean writeToFile = true;
    final private FileExplorer fileExplorer;
    private int logLevel = 0;

    public Logg() {
        this.fileExplorer = new FileExplorer();
    }

    public Logg(boolean writeToFile) {
        this.fileExplorer = new FileExplorer();
        this.writeToFile = writeToFile;
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
//        Log to console
            Logger.getLogger(FileExplorer.class.getName()).log(level, message);
//        Save to file
            if (writeToFile) {
                fileExplorer.push(filePath, getTime() + "[" + level.toString() + "] " + message);
            }
        }
    }
//    public void write(String messasage) {
//        
//        Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, messasage);
//    }

    private String getTime() {
        return String.valueOf(new SimpleDateFormat("yyyy-MM-dd' T'HH:mm:ss.SSSXXX").format(Calendar.getInstance().getTime())) + " > ";
    }
}
