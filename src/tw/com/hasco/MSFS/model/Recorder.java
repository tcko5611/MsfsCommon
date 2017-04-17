/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.concurrent.Callable;
import tw.com.hasco.MSFS.FS.FSBasic;

/**
 * record class
 * @author DELL
 */
public class Recorder implements Callable<String> {
    String fileName;
    int sleepTime;
    int maxRepeatTime;
    int currRepeatTime;
    String currTime="";
    FSBasic fsBasic;
    PrintWriter out;
    boolean stop;
    /**
     * 
     * @param name file name
     * @param sec record sec period
     * @param fs fs instnace
     * @throws IOException comes from fs
     */
    public Recorder(String name, double sec, FSBasic fs) throws IOException {
        fileName = name;
        sleepTime = (int) (sec *1000);
        maxRepeatTime = (int) (1.0/sec);
        currRepeatTime = 0;
        fsBasic = fs;
        File file = new File(name);
        File dir = file.getParentFile();
        if(!dir.exists()) {
            dir.mkdirs();
        }
        // for FileWriter only use iso-8859-1
        // out = new PrintWriter( new BufferedWriter(new FileWriter(name)));
        out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "big5")));
        String str = fsBasic.getType() + "," + sleepTime + "," + fsBasic.getSimulator();
        out.println(str);
        out.println(fsBasic.getFirstLine());
        out.println(fsBasic.getSecondLine());
        stop = false;
    }
    public void stop() {
        stop = true;
    }
    @Override
    public String call() throws Exception {
        while (!stop) {
            String line = fsBasic.getNewLine();
            String time = line.split(",", 2)[0];
            if (time.equals(currTime)) {
                if (currRepeatTime >= maxRepeatTime) { 
                    continue;  
                } else {
                    ++currRepeatTime;
                }
            } else {
                currRepeatTime = 0;
                currTime = time;
            }
            out.println(line);
            sleep(sleepTime);
        }
        out.close();
        return "Recoder end";
    }
}
