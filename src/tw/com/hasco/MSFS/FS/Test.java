/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.hasco.MSFS.FS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import tw.com.hasco.MSFS.model.PlaneType;

/**
 *
 * @author DELL
 */
public class Test {
    public static void main(String args[]){
        try {
            ClassLoader classLoader = Test.class.getClassLoader();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    classLoader.getResourceAsStream("file/data.txt")));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.charAt(0) == '#') {
                    continue;
                }
                String[] strs = line.split("\\s+");
                System.out.println(strs[1]);
                System.out.println(PlaneType.getEnumFromString(strs[1]).getDes1());
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
