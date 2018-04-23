/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Collections.Iterator;
import Exceptions.CardNotAllowedException;

/**
 *
 * @author lbsilva
 */
public class MonteCartasSequencial extends MonteCartas {

    private EstrategiaEmpilhamento estrategiaEmpilhamento;

    /**
     * tipo especial de monte de cartas
     * 
     * @param estrategiaEmpilhamento a forma como o monte de cartas será ordenado
     */
    public MonteCartasSequencial(EstrategiaEmpilhamento estrategiaEmpilhamento) {
        super();
        this.estrategiaEmpilhamento = estrategiaEmpilhamento;
    }
    
    public MonteCartasSequencial(MonteCartasSequencial clone) {
        this(clone.estrategiaEmpilhamento);
        Iterator it = clone.getIterator();
        while (it.hasNext()) {
            this.adicionarCarta((Carta) it.next());
        }
    }

    @Override
    public void adicionarCartas(MonteCartas monteCartas) throws CardNotAllowedException {
        int size = monteCartas.size();
        for (int i = 0; i < size; i++) {
            adicionarCarta(monteCartas.retirarCarta());
        }
    }
    
    @Override
    public void adicionarCarta(Carta carta) throws CardNotAllowedException {
        boolean empilhamentoValido;
        if (super.size() == 0) {
            empilhamentoValido = estrategiaEmpilhamento.primeiraCartaValida(carta);
        } else {
            empilhamentoValido = estrategiaEmpilhamento.empilhamentoValido(carta, super.verUltimaCarta());
        }
        if (!empilhamentoValido) {
            throw new CardNotAllowedException("Carta nao permitida: " + carta.toString());
        }
        super.adicionarCarta(carta);
    }
}
