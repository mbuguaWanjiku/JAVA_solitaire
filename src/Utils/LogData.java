/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 *
 * @author lbsilva
 */
public class LogData implements Observer {

    private File file;
    
    /**
     * Observer que insere a data no documento de texto
     * @param file  documento de texto
     */
    public LogData(File file) {
        this.file = file;
    }
    
    /**
     * insere a data no documento de texto no formado: "AAAA/MM/DD HH:MM:SS"
     * @param subject 
     */
    @Override
    public void update(Subject subject) {
        String date = Calendar.getInstance().get(Calendar.YEAR) + "/"
                + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "/"
                + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + " "
                + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":"
                + Calendar.getInstance().get(Calendar.MINUTE) + ":"
                + Calendar.getInstance().get(Calendar.SECOND);
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(date+": ");
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
