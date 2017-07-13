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
     * Constructor with class name setter.
     *
     * @param inWhat name of place from which debug is executed
     */
    public Debug(String inWhat) {
        this.inWhat = inWhat;
    }

    /**
     * Getter for prefixMessage
     * <p>
     * [default: prefixMessage = "DEBUG> "]
     *
     * @return default debug message prefix
     */
    public String getPrefixMessage() {
        return prefixMessage;
    }

    /**
     * Setter for String prefixMessage
     * <p>
     * [default: prefixMessage = "DEBUG> "]
     *
     * @param prefixMessage default debug message prefix
     */
    public void setPrefixMessage(String prefixMessage) {
        this.prefixMessage = prefixMessage;
    }

    /**
     * Used to get name of class from which it is called.
     *
     * @return returns name of class from which it is called.
     */
    public String getInWhat() {
        return inWhat;
    }

    /**
     * Used to set or change name of class from which it is called.
     *
     * @param inWhat name of place from which debug is executed
     */
    public void setInWhat(String inWhat) {
        this.inWhat = inWhat;
    }

    /**
     * Used to learn if debugging is on.
     * <p>
     * [true - ON ]
     * <p>
     * [false - OFF]
     *
     * @return boolean true if debugging is on.
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Used to turn debugging on or off.
     * <p>
     * [default: on = false]
     *
     * @param on parameter which decides if class writes messages
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    /**
     * For checking if debug writes messages to additional file (debug.log) is
     * on or off.
     * <p>
     * [true - ON ]
     * <p>
     * [false - OFF]
     *
     * @return returns true
     */
    public boolean isWriteToFile() {
        return writeToFile;
    }

    /**
     *
     * <p>
     * [default: writeToFile = false]
     *
     * @param writeToFile parameter which decides if class writes messages to
     * additional file
     */
    public void setWriteToFile(boolean writeToFile) {
        this.writeToFile = writeToFile;
    }

    /**
     * Used for getting path of file where debug writes.
     * <p>
     * [default: filePath = "debug.log"]
     *
     * @return returns path of file
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Used for setting path to file where debug writes.
     * <p>
     * [default: filePath = "debug.log"]
     *
     * @param filePath Path to additional log file
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Used for debugging.
     *
     * @param message contents of debug message
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
