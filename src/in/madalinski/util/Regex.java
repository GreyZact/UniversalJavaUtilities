/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.madalinski.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Much needed simple regex tool for Java
 *
 * @author mike
 */
public class Regex {

    private final Debug debug;

    public Regex() {
        this.debug = new Debug("Regex: ");
    }

    public Debug getDebug() {
        return debug;
    }

    public void setDebugging(Boolean isOn, Boolean writeToFile) {
        this.debug.setOn(isOn);
        this.debug.setWriteToFile(writeToFile);
    }

    public List<String[]> findAll(String input, String regex) {
        LinkedList<String[]> tmpList = new LinkedList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int groupCount = matcher.groupCount();
            String[] tmpStringArray = new String[groupCount];
            for (int i = 0; i < groupCount; i++) {
                debug.log("matcher.group(" + i + "): " + matcher.group(i));
                tmpStringArray[i] = matcher.group(i);
            }
            tmpList.add(tmpStringArray);
        }
        return tmpList;
    }

    public String find(String input, String regex) {
        return findAll(input, regex).get(0)[0];
    }

    public Boolean contains(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
