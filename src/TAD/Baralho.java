/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Exceptions.CardAlreadyExistsException;
import Exceptions.EmptyDeckException;
import Exceptions.FullDeckException;
import Collections.Iterator;

/**
 *
 * @author lbsilva-pfcosta
 * @param <E>
 */
public interface Baralho<E extends Carta> {
    
    /**
     * metodo que baralha o baralho, passando as cartas para uma posicao random
     */
    public void baralhar();
    
    /**
     * metodo que remove uma certa quantia de cartas para uma variavel do tipo MonteCartas
     * 
     * @param quantidade quantia de cartas a remover
     * @return um monte de cartas com as cartas removidas
     * @throws EmptyDeckException caso o baralho esteja vazio
     */
    public MonteCartas retirarCartas(int quantidade) throws EmptyDeckException;
    
    /**
     * metodo que adiciona cartas atraves de um monte de cartas
     * 
     * @param monteCartas o monte de cartas que contem as cartas a serem adicionadas
     * @throws FullDeckException caso o baralho ja esteja completo com a variavel indicada no inicio
     * @throws CardAlreadyExistsException o monte de cartas tenha uma carta ja existente no baralho
     */
    public void adicionarCartas(MonteCartas monteCartas) throws FullDeckException, CardAlreadyExistsException;
    
    /**
     * metodo que mostra a ultima carta no baralho
     * 
     * @return uma carta no baralho
     * @throws EmptyDeckException caso o baralho esteja vazio
     */
    public E verUltimaCarta() throws EmptyDeckException;
    
    /**
     * metodo que retorna um iterador para percorrer todas as cartas
     * 
     * @return o iterador
     */
    public Iterator getIterator();
    
    public int size();
}
