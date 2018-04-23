/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author lbsilva
 */
public interface Iterator<E> {
    
    public E next();
    
    public boolean hasNext();
}
