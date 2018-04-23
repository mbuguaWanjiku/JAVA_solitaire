/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Collections.Iterator;
import Exceptions.CardNotAllowedException;
import Exceptions.EmptyPileOfCards;
import TAD.BaralhoJogo;
import TAD.Carta;
import TAD.EstrategiaEmpilhamentoCorNaipeDescendente;
import TAD.EstrategiaEmpilhamentoNaipeAscendente;
import TAD.MonteCartas;
import TAD.MonteCartasSequencial;

/**
 *
 * @author lbsilva-pfcosta
 */
public class Tabuleiro {

    private static final int N_MONTES_CARTAS_JOGO = 7;

    protected TabuleiroCareTaker tabuleiroInfoCareTaker;

    protected BaralhoJogo baralho;
    protected MonteCartas descartadas;
    protected MonteCartas monteCartasLixo;
    private MonteCartasSequencial[] montesCartasJogo;
    private MonteCartas[] montesCartasEscondidas;
    private MonteCartasSequencial[] montesCartasTopo;
    private String nomeJogador;

    private int monteSeleccionado, numeroCartasSeleccionadas;

    /**
     * Construtor que recebe um baralho, pois este depende do tipo de baralho
     *
     * @param baralho baralho que será utilizado para ditribuir as cartas
     */
    public Tabuleiro(BaralhoJogo baralho) {
        this.baralho = baralho;
        this.tabuleiroInfoCareTaker = new TabuleiroCareTaker();
        baralho.baralhar();
        inicializarMontes();
        for (int i = 0; i < montesCartasEscondidas.length; i++) {
            System.out.println(montesCartasEscondidas[i].size());

        }
    }

    public MonteCartas getMonteCartasLixo() {
        return monteCartasLixo;
    }

    public void moverCartaParaColuna(int index) {
        tabuleiroInfoCareTaker.saveState(new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas));
        Carta carta = monteCartasLixo.retirarCarta();
        try {
            montesCartasJogo[index].adicionarCarta(carta);
        } catch (CardNotAllowedException e) {
            monteCartasLixo.adicionarCarta(carta);
            throw e;
        }
    }

    public void maisCartas() {
        tabuleiroInfoCareTaker.saveState(new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas));

    }

    public String getMonteCartasTopo(int index) {
        try {
            return montesCartasTopo[index].verUltimaCarta().toString();
        } catch (EmptyPileOfCards e) {
            return null;
        }
    }

    public MonteCartas getMonteCartasJogo(int index) {
        return montesCartasJogo[index];
    }

    public boolean isMonteCartasEscondidasEmpty(int index) {
        return montesCartasEscondidas[index].size() == 0;
    }

    public boolean isBaralhoEmpty() {
        return baralho.size() == 0;
    }

    /**
     * Método utilizado para regredir um estado
     */
    public void undo() {
                tabuleiroInfoCareTaker.saveRedoState(new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas));

        TabuleiroInfo info = new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas);
        tabuleiroInfoCareTaker.undo(info);
        baralho = info.getBaralho();
        monteCartasLixo = info.getMonteCartasLixo();
        montesCartasJogo = info.getMontesCartasJogo();
        montesCartasEscondidas = info.getMontesCartasEscondidas();
        montesCartasTopo = info.getMontesCartasTopo();
        descartadas = info.getDescartadas();
        monteSeleccionado = info.getMonteSeleccionado();
        numeroCartasSeleccionadas = info.getNumeroCartasSeleccionadas();
    }

    public boolean hasUndos() {
        return tabuleiroInfoCareTaker.hasUndos();
    }

    public boolean hasRedos() {
        return tabuleiroInfoCareTaker.hasRedos();
    }

    public void redo() {
        TabuleiroInfo info = new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas);
        tabuleiroInfoCareTaker.redo(info);
        baralho = info.getBaralho();
        monteCartasLixo = info.getMonteCartasLixo();
        montesCartasJogo = info.getMontesCartasJogo();
        montesCartasEscondidas = info.getMontesCartasEscondidas();
        montesCartasTopo = info.getMontesCartasTopo();
        descartadas = info.getDescartadas();
        monteSeleccionado = info.getMonteSeleccionado();
        numeroCartasSeleccionadas = info.getNumeroCartasSeleccionadas();
    }

    /**
     * Método auxiliar que tem como função distribuir as cartas do baralho pelos
     * vários montes
     */
    private void inicializarMontes() {

        descartadas = new MonteCartas();
        montesCartasJogo = new MonteCartasSequencial[N_MONTES_CARTAS_JOGO];
        for (int i = 0; i < N_MONTES_CARTAS_JOGO; i++) {
            montesCartasJogo[i] = new MonteCartasSequencial(new EstrategiaEmpilhamentoCorNaipeDescendente());
            montesCartasJogo[i].adicionarCartas(baralho.retirarCartas(1));
        }
        montesCartasEscondidas = new MonteCartas[N_MONTES_CARTAS_JOGO];
        for (int i = 0; i < N_MONTES_CARTAS_JOGO; i++) {
            montesCartasEscondidas[i] = new MonteCartas();
            montesCartasEscondidas[i].adicionarCartas(baralho.retirarCartas(i));
        }

        montesCartasTopo = new MonteCartasSequencial[4];
        for (int i = 0; i < 4; i++) {
            montesCartasTopo[i] = new MonteCartasSequencial(new EstrategiaEmpilhamentoNaipeAscendente());
        }
        monteCartasLixo = new MonteCartas();
    }

    /**
     * Método utilizado na aplicação de consola
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (baralho.size() != 0) {
            sb.append("[///]");
        } else {
            sb.append("     ");
        }
        sb.append(" ");
        if (monteCartasLixo.size() != 0) {
            sb.append("[");
            sb.append(monteCartasLixo.verUltimaCarta());
            sb.append("]");
        } else {
            sb.append("     ");
        }
        sb.append("          ");
        for (int i = 0; i < 4; i++) {
            if (montesCartasTopo[i].size() != 0) {
                sb.append("[");
                sb.append(montesCartasTopo[i].verUltimaCarta());
                sb.append("]");
            } else {
                sb.append("     ");
            }
            sb.append(" ");
        }
        sb.append("\n\n");
        Iterator[] it = new Iterator[N_MONTES_CARTAS_JOGO];
        for (int i = 0; i < it.length; i++) {
            it[i] = montesCartasJogo[i].getIterator();
        }
        Iterator[] itHidden = new Iterator[N_MONTES_CARTAS_JOGO];
        for (int i = 0; i < it.length; i++) {
            itHidden[i] = montesCartasEscondidas[i].getIterator();

        }
        int finishedDecks = 0;
        sb.append("\n");
        for (int i = 0; i < itHidden.length; i++) {
            if (itHidden[i].hasNext()) {
                sb.append("[///]");
            } else {
                sb.append("     ");
            }
            sb.append(" ");
        }
        sb.append("\n");
        while (finishedDecks < 7) {
            for (int i = 0; i < N_MONTES_CARTAS_JOGO; i++) {
                if (it[i].hasNext()) {
                    sb.append("[");
                    sb.append(it[i].next());
                    sb.append("]");
                } else {
                    sb.append("     ");
                    finishedDecks++;
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Altera o nome do jogador que começa como "Unknown"
     *
     * @param nomeJogador Novo nome
     */
    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        Logger.getInstance().setJogador(nomeJogador);
    }

    public void selectColuna(int monte, int numeroCartas) {
        this.monteSeleccionado = monte;
        System.out.println("Foram seleccionadas do monte " + monte + ", " + (montesCartasJogo[monte].size() - numeroCartas) + " cartas.");
        this.numeroCartasSeleccionadas = (montesCartasJogo[monte].size() - numeroCartas);
    }

    public void selectUltimaCartaDeColuna(int i) {
        this.monteSeleccionado = i;
        this.numeroCartasSeleccionadas = 1;
    }

    public void moverCartaDeColunaParaColuna(int i) {
        tabuleiroInfoCareTaker.saveState(new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas));
        MonteCartas temp = new MonteCartas();
        for (int j = 0; j < numeroCartasSeleccionadas; j++) {
            temp.adicionarCarta(montesCartasJogo[monteSeleccionado].retirarCarta());
        }
        MonteCartas backUp = new MonteCartas(temp);
        try {
            montesCartasJogo[i].adicionarCartas(temp);
        } catch (CardNotAllowedException e) {
            montesCartasJogo[monteSeleccionado].adicionarCartas(backUp);
            throw e;
        } finally {
            verificarMontes();
        }
    }

    public void desselect() {
        this.monteSeleccionado = -1;
        this.numeroCartasSeleccionadas = -1;
    }

    private void verificarMontes() {
        for (int i = 0; i < montesCartasJogo.length; i++) {
            if (montesCartasJogo[i].size() == 0 && montesCartasEscondidas[i].size() != 0) {
                montesCartasJogo[i].adicionarCarta(montesCartasEscondidas[i].retirarCarta());
            }
        }
    }

    public void moverCartaParaTopo(int numeroBloco) {
        tabuleiroInfoCareTaker.saveState(new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas));
        Carta carta = monteCartasLixo.retirarCarta();
        try {
            montesCartasTopo[numeroBloco].adicionarCarta(carta);
        } catch (CardNotAllowedException e) {
            monteCartasLixo.adicionarCarta(carta);
            throw e;
        } finally {
            verificarMontes();
        }
    }

    public void moverCartaDeColunaParaTopo(int numeroBloco) {
        tabuleiroInfoCareTaker.saveState(new TabuleiroInfo(baralho, monteCartasLixo, montesCartasJogo, montesCartasEscondidas, montesCartasTopo, descartadas, monteSeleccionado, numeroCartasSeleccionadas));
        MonteCartas temp = new MonteCartas();
        for (int j = 0; j < numeroCartasSeleccionadas; j++) {
            temp.adicionarCarta(montesCartasJogo[monteSeleccionado].retirarCarta());
        }
        MonteCartas backUp = new MonteCartas(temp);
        try {
            montesCartasTopo[numeroBloco].adicionarCartas(temp);
        } catch (CardNotAllowedException e) {
            montesCartasJogo[monteSeleccionado].adicionarCartas(backUp);
            throw e;
        } finally {
            verificarMontes();
        }
    }
}
