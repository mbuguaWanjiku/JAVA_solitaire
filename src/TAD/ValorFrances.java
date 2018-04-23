/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

/**
 *
 * @author lbsilva
 */
public enum ValorFrances implements Valor {
    AS, DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI;
    
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    @Override
    public int getValor() {
        return this.ordinal();
    }
}

