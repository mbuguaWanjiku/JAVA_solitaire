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
public final class Logger extends Subject {
    
    private LogJogada logJogada;
    private LogJogador logJogador;
    private LogData logData;
    
    private static Logger instance = new Logger();
    private File file;

    /**
     * Um observable para escrever os dados dos observers que estiverem adicionadod
     */
    private Logger() {
        super();
        this.file = new File("log.txt");
        escreverCabecalho();
        logJogada = new LogJogada(file);
        logJogador = new LogJogador(file);
        logData = new LogData(file);
        addObserver(logData);
        addObserver(logJogada);
        addObserver(logJogador);
        
    }

    public static Logger getInstance() {
        return instance;
    }
    
    public void setJogador(String jogador) {
        logJogador.setJogador(jogador);
    }
    
    public void setJogada(String jogada) {
        logJogada.setJogada(jogada);
    }

    private void escreverCabecalho() {
        String data = Calendar.getInstance().get(Calendar.YEAR) + "/"
                + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "/"
                + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + " "
                + Calendar.getInstance().get(Calendar.HOUR) + ":"
                + Calendar.getInstance().get(Calendar.MINUTE) + ":"
                + Calendar.getInstance().get(Calendar.SECOND);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("|=======================================LOGGER=====|");
            pw.println("| Jogo iniciado em:                                |");
            pw.println("| "+data);
            pw.println("|==================================================|");
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
