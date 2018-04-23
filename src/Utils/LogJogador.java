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
public class LogJogador implements Observer {

    private String jogador;
    private File file;
    
    /**
     * Observer que guarda no logger o nome do jogador
     * @param file 
     */
    public LogJogador(File file) {
        jogador = "Unknown";
        this.file = file;
    }
    
    /**
     * método que guarda no logger o nome do jogador que, caso o utilizador
     * o altere através da interface gráfica, deve ser realizado o .set(String jogador);
     * @param subject 
     */
    @Override
    public void update(Subject subject) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(" - Por: "+jogador);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * método que actualiza o nome do jogador para um outro
     * @param jogador  novo nome do jogador
     */
    public void setJogador (String jogador) {
        this.jogador = jogador;
    }
}
