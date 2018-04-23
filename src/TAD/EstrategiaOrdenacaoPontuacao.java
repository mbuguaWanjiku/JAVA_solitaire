/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Collections.List;

/**
 *
 * @author lbsilva-pfcosta
 */
public class EstrategiaOrdenacaoPontuacao implements EstrategiaOrdenacao {

    /**
     * método que ordena a lista de pontuacao consoante a pontuacao. Este método
     * recore ao algoritmo selection sort
     * 
     * @param entradas 
     */
    @Override
    public void ordenar(List<Pontuacao> entradas) {
        int first;
        for (int i = entradas.size() - 1; i > 0; i--) {
            first = 0;
            for (int j = 1; j <= i; j++) {
                if (entradas.get(j).pontuacao() > entradas.get(first).pontuacao()) {
                    first = j;
                }
            }
            troca(entradas, first, i);
        }
    }

    /**
     * método auxiliar para o "ordenar" que troca duas entradas de posicoes
     * @param entradas
     * @param first
     * @param i 
     */
    private void troca(List<Pontuacao> entradas, int first, int i) {
        Pontuacao temp = entradas.get(first);
        entradas.set(first, entradas.get(i));
        entradas.set(i, temp);
    }

}
