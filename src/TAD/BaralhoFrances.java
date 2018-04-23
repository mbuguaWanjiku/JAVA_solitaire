/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

/**
 *
 * @author lbsilva-pfcosta
 */
public class BaralhoFrances extends BaralhoJogo {

    public BaralhoFrances() {
        super(52);
        adicionarCartas(gerarMonte());
    }

    /**
     * metodo que gera um baralho tipico de cartas francesas (as 52 cartas do AS ao REI com os naipes: COPAS, OUROS, ESPADAS e PAUS)
     * 
     * @return o monte de cartas para ser adicionado ao baralho
     */
    private MonteCartas gerarMonte() {
        MonteCartas monteGerado = new MonteCartas();
        for (int i = 0; i < 13; i++) {
            monteGerado.adicionarCarta(new CartaFrancesa(ValorFrances.values()[i], NaipeFrances.COPAS));
            monteGerado.adicionarCarta(new CartaFrancesa(ValorFrances.values()[i], NaipeFrances.OUROS));
            monteGerado.adicionarCarta(new CartaFrancesa(ValorFrances.values()[i], NaipeFrances.ESPADAS));
            monteGerado.adicionarCarta(new CartaFrancesa(ValorFrances.values()[i], NaipeFrances.PAUS));
        }
        return monteGerado;
    }
}
