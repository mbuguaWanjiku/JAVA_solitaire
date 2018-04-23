/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Collections.DoubleLinkedList;
import Collections.Iterator;
import Collections.List;

/**
 *
 * @author lbsilva
 */
public class RankingJogo implements Ranking {

    private List<Pontuacao> entradas;
    private EstrategiaOrdenacao estrategiaOrdenacao;
    private int maxEntradas;
    
    /**
     * um ranking é uma "lista" de entradas que contém associado a pontução dos
     * jogadores
     * 
     * @param maxEntradas o limite da lista
     */
    public RankingJogo(int maxEntradas, EstrategiaOrdenacao estrategia) {
        entradas = new DoubleLinkedList<>();
        this.maxEntradas = maxEntradas;
        this.estrategiaOrdenacao = estrategia;
    }

    @Override
    public void ordenar() {
        estrategiaOrdenacao.ordenar(entradas);
    }

    @Override
    public void adicionarEntrada(Pontuacao entrada) {
        entradas.add(entradas.size(), entrada);
    }

    @Override
    public Iterator getIterator() {
        return entradas.getIterator();
    }

    @Override
    public Pontuacao getEntrada(int index) {
        return entradas.get(index);
    }
}
