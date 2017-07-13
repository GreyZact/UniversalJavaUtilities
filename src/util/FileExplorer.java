/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Utility used for reading and writing files.
 *
 * @author mike
 */
public class FileExplorer {

    private final Debug debug = new Debug("FileExplorer> ");
    private String PATH = System.getProperty("user.dir") + "/../";

    public FileExplorer() {
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    public Boolean getDebugOn() {
        return debug.isOn();
    }

    public void setDebugOn(boolean on) {
        this.debug.setOn(on);
    }

    public Boolean getDebugWriteToFile() {
        return debug.isWriteToFile();
    }

    public void setDebugWriteToFile(boolean on) {
        this.debug.setWriteToFile(on);
    }

    public void write(String output, String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(PATH + output);
            bw = new BufferedWriter(fw);
            bw.write(data);

            debug.log("write> " + PATH + output + " > WRITEN");

        } catch (IOException ex) {
            debug.log("write> " + PATH + output + " > ERROR");
            Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {

                if (bw != null) {
                    bw.close();

                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                debug.log("write> " + PATH + output + " > ERROR");
                Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeImage(String output, BufferedImage rawImage) {
        // Get filetype from output parametr
        String[] tmpStringArray = output.split("\\.");
        String filetype = tmpStringArray[tmpStringArray.length - 1];

        try {
            BufferedImage bi = rawImage;
            File outputfile = new File(output);
            //  Write raw image data to file
            ImageIO.write(bi, filetype, outputfile);
        } catch (IOException ex) {
            debug.log("writeImage> " + PATH + output + " > ERROR");
            Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void push(String output, String newLine) {
        try {
            FileOutputStream fop = new FileOutputStream(PATH + output, true);
            PrintStream ps = new PrintStream(fop);
            ps.println(newLine);
            ps.close();
            debug.log("push> " + PATH + output + " > WRITEN");
        } catch (FileNotFoundException ex) {
            debug.log("push> " + PATH + output + " > ERROR");
            Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<String> read(String input) {
        LinkedList<String> tmpLinkedList = new LinkedList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(PATH + input);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                tmpLinkedList.add(sCurrentLine);
            }

        } catch (FileNotFoundException ex) {
            debug.log("read> " + PATH + input + " > ERROR");
            Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            debug.log("read> " + PATH + input + " > ERROR");
            Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {
                debug.log("read> " + PATH + input + " > ERROR");
                Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        debug.log("read> " + PATH + input + " > READ");
        return tmpLinkedList;
    }

    public String openFile(String input) {
        String tmpString = null;
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(PATH + input);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                tmpString += sCurrentLine;
            }

        } catch (FileNotFoundException ex) {
            debug.log("openFile> " + PATH + input + " > ERROR");
            Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            debug.log("openFile> " + PATH + input + " > ERROR");
            Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {
                debug.log("openFile> " + PATH + input + " > ERROR");
                Logger.getLogger(FileExplorer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        debug.log("openFile> " + PATH + input + " > READ");
        return tmpString;
    }

    public LinkedList<String> ls(String directory) {
        return null;
    }
}
