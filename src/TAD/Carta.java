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
public interface Carta {
    
    /**
     * este metodo retorna o valor da carta
     * 0 - AS
     * 1 - DOIS
     * 2 - TRES
     * 3 - QUATRO
     * 4 - CINCO
     * 5 - SEIS
     * 6 - SETE
     * 7 - OITO
     * 8 - NOVE
     * 9 - DEZ
     * 10 - VALETE
     * 11 - DAMA
     * 12 - REI
     * 
     * @return o valor da carta
     */
    public int getValor();
    
    /**
     * metodo que retorna o naipe da carta
     * 
     * @return o naipe numa variavel do tipo Naipe
     */
    public Naipe getNaipe();
    
    /**
     * metodo substituto do "equals" que vai verificar se duas cartas sao iguais
     * @param carta carta a ser comparada a do proprio objecto
     * @return true se a carta for igual, false se a carta for diferente
     */
    public boolean igual(Carta carta);
}
