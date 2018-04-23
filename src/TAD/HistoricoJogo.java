/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Exceptions.HistoryException;
import Collections.DoubleLinkedList;
import Collections.List;

/**
 *
 * @author lbsilva-pfcosta
 */
public class HistoricoJogo<E> implements Historico<E> {
    
    private List<Entrada<E>> entradas;
    private int maxEntradas;
    
    /**
     * um historico é um conjunto de entradas com um limite máximo
     * 
     * @param maxEntradas limite máximo
     */
    public HistoricoJogo(int maxEntradas) {
        entradas = new DoubleLinkedList<>();
        this.maxEntradas = maxEntradas;
    }
    
    /**
     * método que adiciona uma entrada no historico
     * 
     * @param entrada entrada
     * @throws HistoryException caso o historico já esteja cheio
     */
    @Override
    public void addEntrada (Entrada<E> entrada) throws HistoryException {
        if (entradas.size() == maxEntradas) {
            throw new HistoryException("Historico cheio");
        }
        entradas.add(entradas.size(), entrada);
    }
    
    /**
     * receber uma certa entrada que se encontra num indice
     * 
     * @param index indice
     * @return Entrada
     */
    @Override
    public Entrada<E> getEntrada(int index) {
        return entradas.get(index);
    }
}
