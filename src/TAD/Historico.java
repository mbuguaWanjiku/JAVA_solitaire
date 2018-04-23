/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Exceptions.HistoryException;

/**
 *
 * @author lbsilva
 */
public interface Historico<E> {
    public void addEntrada (Entrada<E> entrada) throws HistoryException;
    public Entrada<E> getEntrada(int index);
}
