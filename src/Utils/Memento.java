/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import TAD.BaralhoJogo;
import TAD.MonteCartas;
import TAD.MonteCartasSequencial;

/**
 *
 * @author lbsilva
 */
public class Memento {
    private BaralhoJogo baralho;
    private MonteCartasSequencial[] montesCartasJogo;
    private MonteCartas[] montesCartasEscondidas;
    private MonteCartasSequencial[] montesCartasTopo;
    private MonteCartas monteCartasLixo;
    private MonteCartas descartadas;
    private int monteSeleccionado, numeroCartasSeleccionadas;

    public Memento(BaralhoJogo baralho, MonteCartasSequencial[] montesCartasJogo, MonteCartas[] montesCartasEscondidas, MonteCartasSequencial[] montesCartasTopo, MonteCartas monteCartasLixo, MonteCartas descartadas, int monteSeleccionado, int numeroCartasSeleccionadas) {
        this.baralho = new BaralhoJogo(baralho);
        this.montesCartasJogo = new MonteCartasSequencial[7];
        for (int i = 0; i < montesCartasJogo.length; i++) {
            this.montesCartasJogo[i] = new MonteCartasSequencial(montesCartasJogo[i]);
        }
        this.montesCartasEscondidas = new MonteCartas[7];
        for (int i = 0; i < montesCartasEscondidas.length; i++) {
            this.montesCartasEscondidas[i] = new MonteCartas(montesCartasEscondidas[i]);
        }
        this.montesCartasTopo = new MonteCartasSequencial[4];
        for (int i = 0; i < montesCartasTopo.length; i++) {
            this.montesCartasTopo[i] = new MonteCartasSequencial(montesCartasTopo[i]);
            
        }
        this.monteCartasLixo = new MonteCartas(monteCartasLixo);
        this.descartadas = new MonteCartas(descartadas);
        this.monteSeleccionado = monteSeleccionado;
        this.numeroCartasSeleccionadas = numeroCartasSeleccionadas;
    }

    public BaralhoJogo getBaralho() {
        return baralho;
    }

    public void setBaralho(BaralhoJogo baralho) {
        this.baralho = baralho;
    }

    public MonteCartasSequencial[] getMontesCartasJogo() {
        return montesCartasJogo;
    }

    public void setMontesCartasJogo(MonteCartasSequencial[] montesCartasJogo) {
        this.montesCartasJogo = montesCartasJogo;
    }

    public MonteCartas[] getMontesCartasEscondidas() {
        return montesCartasEscondidas;
    }

    public void setMontesCartasEscondidas(MonteCartas[] montesCartasEscondidas) {
        this.montesCartasEscondidas = montesCartasEscondidas;
    }

    public MonteCartasSequencial[] getMontesCartasTopo() {
        return montesCartasTopo;
    }

    public void setMontesCartasTopo(MonteCartasSequencial[] montesCartasTopo) {
        this.montesCartasTopo = montesCartasTopo;
    }

    public MonteCartas getDescartadas() {
        return descartadas;
    }

    public void setDescartadas(MonteCartas descartadas) {
        this.descartadas = descartadas;
    }

    public int getMonteSeleccionado() {
        return monteSeleccionado;
    }

    public void setMonteSeleccionado(int monteSeleccionado) {
        this.monteSeleccionado = monteSeleccionado;
    }

    public int getNumeroCartasSeleccionadas() {
        return numeroCartasSeleccionadas;
    }

    public void setNumeroCartasSeleccionadas(int numeroCartasSeleccionadas) {
        this.numeroCartasSeleccionadas = numeroCartasSeleccionadas;
    }

    
    
    public MonteCartas getMonteCartasLixo() {
        return monteCartasLixo;
    }

    public void setMonteCartasLixo(MonteCartas monteCartasLixo) {
        this.monteCartasLixo = monteCartasLixo;
    }
    
    public BaralhoJogo getSavedBaralho() {
        return baralho;
    }

    public MonteCartasSequencial[] getSavedMontesCartasJogo() {
        return montesCartasJogo;
    }

    public MonteCartas[] getSavedMontesCartasEscondidas() {
        return montesCartasEscondidas;
    }

    public MonteCartasSequencial[] getSavedMontesCartasTopo() {
        return montesCartasTopo;
    }
    
    public MonteCartas getCartasDescartadas() {
        return descartadas;
    }
}
