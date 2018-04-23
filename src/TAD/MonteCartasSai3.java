/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Exceptions.EmptyPileOfCards;

/**
 *
 * @author lbsilva
 */
public class MonteCartasSai3 extends MonteCartas {

    /**
     * um tipo especifico de monte de cartas, que em vez de remover uma carta,
     * remove 3
     */
    public MonteCartasSai3() {
        super();
    }

    /**
     * método não suportado nesta classe
     * 
     * @return 
     */
    @Override
    public CartaJogo retirarCarta() {
        throw new UnsupportedOperationException("Metodo nao suportado para " + getClass().toString());
    }

    /**
     * método utilizado para remover 3 cartas que são retornadas numa variável
     * do tipo MonteCartas com as 3 cartas.
     * 
     * @return as cartas
     * @throws EmptyPileOfCards caso o monte tenha menos de 3 cartas
     */
    public MonteCartas retirar3Cartas() throws EmptyPileOfCards {
        if (super.size() < 3) {
            throw new EmptyPileOfCards("Monte de cartas com menos de 3 cartas");
        }
        MonteCartas monteCartas = new MonteCartas();
        for (int i = 0; i < 3; i++) {
            monteCartas.adicionarCarta(super.retirarCarta());
        }
        return monteCartas;
    }
}
