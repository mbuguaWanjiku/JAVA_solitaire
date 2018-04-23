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
public abstract class CartaJogo implements Carta {

    private Valor valor;
    private Naipe naipe;

    /**
     * uma CartaJogo tem um valor e um naipe associado sendo que o naipe pode
     * ser um tipo especifico de naipe (isto porque Naipe e uma interface, e
     * para criar um novo naipe de novas cartas, basta criar um enumerado que
     * implemente a interface Naipe) o mesmo se aplica para o valor
     *
     * @param valor valor da carta
     * @param naipe naipe da carta
     */
    public CartaJogo(Valor valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    @Override
    public boolean igual(Carta cartaComparada) {
        System.out.println("ok3");
        if (cartaComparada == null) {
            return false;
        }
        if (!(cartaComparada instanceof CartaJogo)) {
            return false;
        }
        if (cartaComparada == this) {
            return true;
        }
        CartaJogo carta = (CartaJogo) cartaComparada;
        return (this.valor == carta.valor && this.naipe == carta.naipe);
    }

    @Override
    public Naipe getNaipe() {
        return naipe;
    }

    @Override
    public String toString() {
        return valor.toString() + "_" + naipe.toString();
    }

    @Override
    public int getValor() {
        return valor.getValor();
    }
}
