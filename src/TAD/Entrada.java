/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lbsilva-pfcosta
 */
public class Entrada<E> {
    
    private Date data;
    private E elemento;
    
    /**
     * Uma entrada composta por um elemento que associa automaticamente
     * uma data.
     * 
     * @param elemento elemento a associar
     */
    public Entrada (E elemento) {
        this.elemento = elemento;
        this.data = Calendar.getInstance().getTime();
    }

    /**
     * devolve a data quando a entrada foi criada
     * 
     * @return a data de criação
     */
    public Date getData() {
        return data;
    }

    /**
     * retorna o elemento armazenado na entrada
     * 
     * @return o elemento
     */
    public E getElemento() {
        return elemento;
    }

    /**
     * altera o elemento armazenado
     * 
     * @param elemento o elemento
     */
    public void setElemento(E elemento) {
        this.elemento = elemento;
    }
}
