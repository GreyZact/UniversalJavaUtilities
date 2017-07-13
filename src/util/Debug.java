/*
 * To change this license header, choose License Headers inWhat Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inWhat the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Utility used for debugging.
 *
 * @author mike
 *
 * @param prefixMessage default debug message prefix [default: prefixMessage =
 * "DEBUG> "]
 * @param inWhat name of place from which debug is executed
 * @param on parametr which decides if class writtes messages [default: on =
 * false]
 * @param writeToFile parametr which decides if class writtes messages to
 * additional file[default: writeToFile = false]
 * @param filePath Path to additional log file [default: filePath = "debug.log"]
 */
public class Debug {

    private String prefixMessage = "DEBUG> ";
    private String inWhat = " > ";
    private boolean on = false;
    private boolean writeToFile = false;
    private String filePath = "debug.log";

    /**
     * Constructor
     *
     */
    public Debug() {
    }

    /**
     * Constructor
     *
     * @param inWhat name of place from which debug is executed
     */
    public Debug(String inWhat) {
        this.inWhat = inWhat;
    }

    /**
     * Constructor
     *
     * @param prefixMessage default debug message prefix
     *
     * [default: prefixMessage = "DEBUG> "]
     * @param inWhat name of place from which debug is executed
     */
    public Debug(String prefixMessage, String inWhat) {
        this.prefixMessage = prefixMessage;
        this.inWhat = inWhat;
    }

    /**
     * Getter for prefixMessage
     * <p>
     * default debug message prefix [default: prefixMessage = "DEBUG> "]
     */
    public String getPrefixMessage() {
        return prefixMessage;
    }

    /**
     * Setter for String prefixMessage
     *
     * @param prefixMessage default debug message prefix
     *
     * [default: prefixMessage = "DEBUG> "]
     */
    public void setPrefixMessage(String prefixMessage) {
        this.prefixMessage = prefixMessage;
    }

    /**
     *
     */
    public String getInWhat() {
        return inWhat;
    }

    /**
     *
     * @param inWhat name of place from which debug is executed
     */
    public void setInWhat(String inWhat) {
        this.inWhat = inWhat;
    }

    /**
     *
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see Image
     */
    public boolean isOn() {
        return on;
    }

    /**
     *
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see Image
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    /**
     *
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see Image
     */
    public boolean isWriteToFile() {
        return writeToFile;
    }

    /**
     *
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see Image
     */
    public void setWriteToFile(boolean writeToFile) {
        this.writeToFile = writeToFile;
    }

    /**
     *
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see Image
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     *
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see Image
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     *
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see Image
     */
    public void log(String message) {
        if (on) {
            System.out.println(prefixMessage + inWhat + message);
            if (writeToFile) {
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd' T'HH:mm:ss.SSSXXX").format(Calendar.getInstance().getTime());
                writeToLogFile(timeStamp + " > " + prefixMessage + inWhat + message);
            }
        }

    }

    /**
     * Used to add message to debug.log file.
     *
     * @param message an absolute URL giving the base location of the image
     */
    private void writeToLogFile(String message) {
        FileExplorer fileExplorer = new FileExplorer();
        fileExplorer.push(filePath, message);
    }
}
