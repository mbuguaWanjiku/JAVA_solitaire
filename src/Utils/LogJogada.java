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

/**
 *
 * @author lbsilva
 */
public class LogJogada implements Observer {
    
    private String jogada;
    private File file;
    
    /**
     * Observer que acrescenta ao logger a jogada realizada
     * @param file  ficheiro ao qual vai ser acrescentado
     */
    public LogJogada (File file) {
        jogada = "Unknown";
        this.file = file;
    }
    
    /**
     * método que acrescenta ao logger a jogada realizada
     * a jogada deve de ser definida antes do update realizando o .set(String jogada);
     * @param subject 
     */
    @Override
    public void update(Subject subject) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(" - "+jogada);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * definir qual a jogada a acrescentar ao logger
     * @param jogada  uma string com a jogada
     */
    public void setJogada(String jogada) {
        this.jogada = jogada;
    }
}
