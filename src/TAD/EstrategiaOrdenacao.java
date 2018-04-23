/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Collections.List;

/**
 *
 * @author lbsilva-pfcosta-pfcosta
 */
public interface EstrategiaOrdenacao {

    /**
     * este método vai oprdenar a lista de pontuacao consoante um certo criterio
     * 
     * @param entradas 
     */
    public void ordenar(List<Pontuacao> entradas);
}
