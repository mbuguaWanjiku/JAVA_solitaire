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
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author lbsilva-pfcosta
 */
public class BaralhoJogo implements Baralho<Carta>, Cloneable {

    private final static Random RANDOM = new Random(Calendar.getInstance().get(Calendar.MILLISECOND));

    protected Carta[] cartas;
    private int nCartas;

    /**
     * Um BaralhoJogo e um baralho sem cartas por defeito, esta classe nao deve
     * ser utilizada para implementar baralhos devem de ser criadas novas
     * classes que extendam e que, nos seus construtores, insiram logo as cartas
     * pretendidas no baralho (por exemplo na classe BaralhoUno, extendia desta
     * classe e no construtor do BaralhoUno eram logo inseridas as cartas no
     * baralho (super.adicionarCartas(MonteCartas cartasUno)) «-Exemplo
     *
     * @param capacity a capacidade do baralho
     */
    public BaralhoJogo(int capacity) {
        this.cartas = new CartaJogo[capacity];
    }

    public BaralhoJogo(BaralhoJogo clone) {
        this.cartas = new Carta[clone.cartas.length];
        this.nCartas = clone.nCartas;
        for (int i = 0; i < clone.nCartas; i++) {
            this.cartas[i] = clone.cartas[i];
        }
    }

    @Override
    public void adicionarCartas(MonteCartas monteCartas) throws FullDeckException, CardAlreadyExistsException {
        if (cartas.length - nCartas < monteCartas.size()) {
            throw new FullDeckException("Baralho cheio");
        }

        if (cartasExistentes(monteCartas)) {
            throw new CardAlreadyExistsException("Cartas existentes");
        }
        adicionarMonteCartas(monteCartas);
    }

    @Override
    public Carta verUltimaCarta() throws EmptyDeckException {
        if (nCartas == 0) {
            throw new EmptyDeckException("Baralho vazio");
        }
        return cartas[nCartas - 1];
    }

    /**
     * metodo que vai verificar se as cartas de um certo monte de cartas ja
     * existe no baralho, este metodo e utilizado para impedir que entrem cartas
     * repetidas no baralho
     *
     * @param monteParaTeste o monte de cartas cujo as cartas vao ser testadas
     * @return true se existirem cartas repetidas, falso caso contrario
     */
    private boolean cartasExistentes(MonteCartas monteParaTeste) {
        if (nCartas == 0) {
            return false;
        }
        Carta cartaParaTeste;
        for (int i = 0; i < monteParaTeste.size(); i++) {
            cartaParaTeste = monteParaTeste.retirarCarta();
            for (int j = 0; j < nCartas; j++) {
                if (cartas[j].igual(cartaParaTeste)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public void baralhar() {
        for (int i = 0; i < cartas.length; i++) {
            int indexAleatorio = RANDOM.nextInt(nCartas);
            trocarCartas(i, indexAleatorio);
        }
    }

    @Override
    public MonteCartas retirarCartas(int quantidade) throws EmptyDeckException {
        if (quantidade > nCartas) {
            throw new EmptyDeckException("Numero cartas no baralho: " + nCartas + "\nNumero cartas a retirar: " + quantidade);
        }
        int fim = nCartas - quantidade - 1;
        MonteCartas retiradas = new MonteCartas();
        for (int i = nCartas - 1; i > fim; i--) {
            retiradas.adicionarCarta(cartas[i]);
            cartas[i] = null;
            nCartas--;
        }
        return retiradas;
    }

    /**
     * metodo que retorna o numero de cartas no baralho
     *
     * @return numero de cartas no baralho
     */
    @Override
    public int size() {
        return nCartas;
    }

    /**
     * este e o metodo principal que e utilizado para inserir as cartas do monte
     * no array
     *
     * @param monteCartas o monte de cartas a ser inserido
     */
    private void adicionarMonteCartas(MonteCartas monteCartas) {
        int fim = nCartas + monteCartas.size();
        for (int i = nCartas; i < fim; i++) {
            cartas[i] = monteCartas.retirarCarta();
            nCartas++;
        }
    }

    /**
     * metodo utilizado como auxilio do baralhar, serve para trocar duas cartas
     * de posicao
     *
     * @param primeira actual posicao da primeira carta para troca
     * @param segunda actual posicao da segunda carta para troca
     */
    private void trocarCartas(int primeira, int segunda) {
        Carta temp = cartas[primeira];
        cartas[primeira] = cartas[segunda];
        cartas[segunda] = temp;
    }

    @Override
    public Iterator getIterator() {
        return new BaralhoIterator();
    }

    private class BaralhoIterator implements Iterator<Carta> {

        private int cursor;

        public BaralhoIterator() {
            cursor = 0;
        }

        @Override
        public Carta next() {
            return cartas[cursor++];
        }

        @Override
        public boolean hasNext() {
            return cursor < nCartas;
        }

    }

    @Override
    public Baralho clone() throws CloneNotSupportedException {
        BaralhoJogo temp = new BaralhoJogo(cartas.length);
        temp.nCartas = this.nCartas;
        temp.cartas = this.cartas.clone();
        return temp;
    }
}
