/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import TAD.Baralho;
import TAD.BaralhoJogo;
import TAD.MonteCartas;
import TAD.MonteCartasSequencial;

/**
 *
 * @author lbsilva
 */
public class TabuleiroInfo {

    private BaralhoJogo baralho;
    private MonteCartas monteCartasLixo;
    private MonteCartasSequencial[] montesCartasJogo;
    private MonteCartas[] montesCartasEscondidas;
    private MonteCartasSequencial[] montesCartasTopo;
    private MonteCartas descartadas;
    private int monteSeleccionado, numeroCartasSeleccionadas;

    public TabuleiroInfo(BaralhoJogo baralho, MonteCartas monteCartasLixo, MonteCartasSequencial[] montesCartasJogo, MonteCartas[] montesCartasEscondidas, MonteCartasSequencial[] montesCartasTopo, MonteCartas descartadas, int monteSeleccionado, int numeroCartasSeleccionadas) {
        this.baralho = baralho;
        this.monteCartasLixo = monteCartasLixo;
        this.montesCartasJogo = montesCartasJogo;
        this.montesCartasEscondidas = montesCartasEscondidas;
        this.montesCartasTopo = montesCartasTopo;
        this.descartadas = descartadas;
        this.monteSeleccionado = monteSeleccionado;
        this.numeroCartasSeleccionadas = numeroCartasSeleccionadas;
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

    public BaralhoJogo getBaralho() {
        return baralho;
    }

    public void setBaralho(BaralhoJogo baralho) {
        this.baralho = baralho;
    }

    public MonteCartas getMonteCartasLixo() {
        return monteCartasLixo;
    }

    public void setMonteCartasLixo(MonteCartas monteCartasLixo) {
        this.monteCartasLixo = monteCartasLixo;
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

    public Memento save() {
        return new Memento(baralho, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, monteCartasLixo, descartadas, monteSeleccionado, numeroCartasSeleccionadas);
    }
    
    public MonteCartas getDescartadas() {
        return descartadas;
    }
    
    public void restore(Object objMemento) {
        Memento memento = (Memento) objMemento;
        this.baralho = memento.getSavedBaralho();
        this.montesCartasJogo = memento.getSavedMontesCartasJogo();
        this.montesCartasTopo = memento.getSavedMontesCartasTopo();
        this.monteCartasLixo = memento.getMonteCartasLixo();
        this.descartadas = memento.getCartasDescartadas();
        this.numeroCartasSeleccionadas = memento.getNumeroCartasSeleccionadas();
        this.monteSeleccionado = memento.getMonteSeleccionado();
    }
}
