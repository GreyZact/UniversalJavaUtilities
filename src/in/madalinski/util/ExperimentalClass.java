/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.madalinski.util;

import java.util.Date;
import java.util.List;

/**
 * Class used only in development for checking how things really work.
 *
 * @author mike
 */
public class ExperimentalClass {

    public static void main(String[] args) {
        Debug debug = new Debug("NewClass> ");
        debug.setOn(true);
        debug.setWriteToFile(true);
        debug.log("Test Debug");

        FileExplorer fileExplorer = new FileExplorer();
        fileExplorer.setDebugOn(true);
        fileExplorer.setDebugWriteToFile(true);
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vestibulum nisi nec venenatis eleifend. Pellentesque ut consectetur risus. Aliquam eu hendrerit nunc. Nunc velit tellus, molestie vel consectetur eleifend, varius sit amet diam. Aenean quam enim, faucibus eget lectus sit amet, hendrerit pharetra elit. Praesent vel nisi id nisi faucibus maximus sed non ipsum. Nullam placerat diam sed tincidunt imperdiet. Etiam dictum vulputate nibh a fermentum. Donec vulputate lacinia elementum. Nunc facilisis et nisl nec gravida.\n"
                + "\n"
                + "Quisque malesuada dolor vitae risus volutpat, at rhoncus est tincidunt. Maecenas in dignissim elit. Fusce sit amet neque id elit interdum efficitur. Cras sed ipsum semper, consectetur libero et, sagittis nunc. Cras euismod at eros vel finibus. Sed et odio a purus auctor suscipit ac in enim. Vestibulum et aliquet enim, vitae viverra erat. Fusce ac enim tortor. Ut cursus, ex at iaculis finibus, nisi libero feugiat massa, et imperdiet nibh sapien ut nulla. Nam vitae dui diam. Fusce hendrerit nisl et dolor tempus viverra.";
        fileExplorer.write("d.log", lorem);

        Debug d = new Debug("ExperimentalClass> Reader> ");
        d.setOn(true);
        List<String> list = fileExplorer.read("debug.log");
        list.forEach(item -> d.log(item));

        new Logg().printWARNING(System.getProperty("os.name"));
        Long time = new Date().getTime();
        new Logg().printWARNING(Config.getKey("example"));
        new Logg().printWARNING("took: " + String.valueOf(new Date().getTime() - time));
    }
}
