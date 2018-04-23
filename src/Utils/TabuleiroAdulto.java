/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import TAD.BaralhoJogo;
import TAD.MonteCartas;

/**
 *
 * @author lbsilva
 */
public class TabuleiroAdulto extends Tabuleiro {
    
    
    
    public TabuleiroAdulto(BaralhoJogo baralho) {
        super(baralho);
    }
    
    @Override
    public void maisCartas() {
        super.maisCartas();
        if (baralho.size() > 0) {
            if (monteCartasLixo.size() != 0) {
                descartadas.adicionarCartas(monteCartasLixo);
            }
            monteCartasLixo = new MonteCartas();
            Logger.getInstance().setJogada("Baralho vazio, reposição das cartas do monte lixe no baralho");
            Logger.getInstance().changedState();
            Logger.getInstance().notifyObservers();
            int size = baralho.size();
            for (int i = 0; i < size && i < 3; i++) {
                monteCartasLixo.adicionarCartas(baralho.retirarCartas(1));
            }
        } else {
            descartadas.adicionarCartas(monteCartasLixo);
            baralho.adicionarCartas(descartadas);
            descartadas = new MonteCartas();
            monteCartasLixo = new MonteCartas();
        }
        
    }
}
