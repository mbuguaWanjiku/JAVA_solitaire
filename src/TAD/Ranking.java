/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Collections.Iterator;

/**
 *
 * @author lbsilva
 */
public interface Ranking {
    
    /**
     * método que ordena o ranking consoante um certo critério
     */
    public void ordenar();
    
    /**
     * método que adiciona uma nova entrada ao ranking
     * 
     * @param entrada 
     */
    public void adicionarEntrada(Pontuacao entrada);
    
    public Iterator getIterator();
    
    /**
     * método que devolve uma entrada de pontuacao
     * 
     * @param index
     * @return a entrada
     */
    public Pontuacao getEntrada(int index);
}
