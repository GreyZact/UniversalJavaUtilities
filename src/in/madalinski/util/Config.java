/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.madalinski.util;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Reads and makes available options saved in "configuration.file".
 * <p>
 * You can only have ONE instance of this class for retaining Configuration file integrity. 
 * @author mike
 */
public class Config {

    private static Config instance;
    private static HashMap<String, String> settingsMap;
    private static final String configFile = "configuration.file";

    /**
     * A private Constructor prevents any other class from instantiating.
     */
    private Config() {
        // nothing to do this time
    }

    /**
     * The Static initializer constructs the instance at class loading time;
     * this is to simulate a more involved construction process (it it were
     * really simple, you'd just use an initializer)
     */
    static {
        instance = new Config();
        settingsMap = load();
    }

    /**
     * Static 'instance' method
     * @return 
     */
    public static Config getInstance() {
        return instance;
    }
    
    public static LinkedList<String> getKeyList() {
        return null;
    }

    public static String getKey(String key) {
        return settingsMap.get(key);
    }

    public void updateKey(String key, String value) {

    }

    private static HashMap<String, String> load() {
        HashMap<String, String> tmpMap = new HashMap<>();
        // Read config file
        LinkedList<String> tmpList = new FileExplorer().read(configFile);
        // Convert config file to HashMap
        tmpList.stream().map((item) -> item.split("=")).forEachOrdered((tmpArray) -> {
            tmpMap.put(tmpArray[0], tmpArray[1]);
        });
        return tmpMap;
    }

    private void saveHashMapToFile(HashMap<String, String> hashMap) {
        FileExplorer fileExplorer = new FileExplorer();
        // Writte Text representation of settings HashMap to file       
        fileExplorer.write(configFile, transformHashMap2String(settingsMap));
    }

    /**
     * Used for changing HashMap<String, String> to it's Text representation.
     *
     * @param hashMap HashMap<String, String> containing settings
     * @return Text representation of HashMap
     */
    private String transformHashMap2String(HashMap<String, String> hashMap) {
        return null;
    }

    /**
     * Used for changing Text representation of HashMap to
     * HashMap<String, String>.
     *
     * @param string Text representation of HashMap
     * @return HashMap<String, String> containing settings
     */
    private HashMap<String, String> transformString2HashMap(String string) {
        return null;
    }
}