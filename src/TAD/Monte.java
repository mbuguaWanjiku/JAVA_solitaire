/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Collections.Iterator;
import Exceptions.CardNotAllowedException;
import Exceptions.EmptyPileOfCards;

/**
 *
 * @author lbsilva
 */
public interface Monte {
    public void adicionarCarta(Carta carta) throws CardNotAllowedException;
    public void adicionarCartas(MonteCartas monteCartas) throws CardNotAllowedException;
    public int size();
    public Carta retirarCarta() throws MonteCartasVazioException;
    public Iterator getIterator();
    public Carta verUltimaCarta() throws EmptyPileOfCards;
}
