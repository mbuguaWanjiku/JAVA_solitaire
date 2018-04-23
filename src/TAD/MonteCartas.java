/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Exceptions.CardNotAllowedException;
import Exceptions.EmptyPileOfCards;
import Collections.Iterator;
import Collections.Stack;
import Collections.DynamicStack;
import Exceptions.EmptyStackException;

/**
 *
 * @author lbsilva-pfcosta
 */
public class MonteCartas implements Monte, Cloneable {

    private Stack<Carta> cartas;

    /**
     * esta classe armazena um conjunto de cartas que podem ser removidas
     * ou adicionadas
     */
    public MonteCartas() {
        cartas = new DynamicStack<>();
    }
    
    public MonteCartas(MonteCartas clone) {
        this.cartas = new DynamicStack<>();
        Iterator it = clone.getIterator();
        while (it.hasNext()) {
            cartas.push((Carta) it.next());
        }
    }
    
    /**
     * adicionar uma carta ao monte
     * 
     * @param carta carta a ser adicionara
     * @throws CardNotAllowedException caso a carta nao seja permitida
     */
    @Override
    public void adicionarCarta(Carta carta) throws CardNotAllowedException {
        cartas.push(carta);
    }
    
    @Override
    public void adicionarCartas(MonteCartas monteCartas) throws CardNotAllowedException {
        int inc = monteCartas.size();
        for (int i = 0; i < inc; i++) {
            this.adicionarCarta(monteCartas.retirarCarta());
        }
    }
    
    /**
     * numero de cartas existentes no monte
     * 
     * @return 
     */
    @Override
    public int size() {
        return cartas.size();
    }
    
    /**
     * retirar uma carta do monte
     * 
     * @return a carta
     */
    @Override
    public Carta retirarCarta() throws MonteCartasVazioException {
        if (cartas.isEmpty()) {
            throw new MonteCartasVazioException();
        }
        return cartas.pop();
    }
    
    @Override
    public Iterator getIterator() {
        return cartas.getIterator();
    }
    
    /**
     * ver a ultima carta do monte
     * 
     * @return a carta
     * @throws EmptyPileOfCards  se o monte de cartas estiver vazio
     */
    @Override
    public Carta verUltimaCarta() throws EmptyPileOfCards {
        try {
            return cartas.peek();
        } catch (EmptyStackException e) {
            throw new EmptyPileOfCards("Monte de cartas vazio");
        }
    }
}
