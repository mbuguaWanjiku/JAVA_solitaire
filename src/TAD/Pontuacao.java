/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

/**
 *
 * @author lbsilva
 */
public class Pontuacao implements Comparable<Pontuacao> {
    
    private Jogador jogador;
    private int pontos;

    public Pontuacao (Jogador jogador, int pontuacao) {
        this.jogador = jogador;
        this.pontos = pontuacao;
    }
    
    public Jogador getJogador() {
        return jogador;
    }
    
    public int pontuacao() {
        return pontos;
    }

    @Override
    public int compareTo(Pontuacao toCompare) {
        return pontos - toCompare.pontos;
    }
}
