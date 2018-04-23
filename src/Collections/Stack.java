/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Collections;

import Exceptions.EmptyStackException;


/**
 *
 * @author Pedro
 * @param <E>
 */
public interface Stack<E> {
    
    public int size();
    
    public boolean isEmpty();
    
    public E peek () throws EmptyStackException;
    
    public void push (E elem);
    
    public E pop() throws EmptyStackException;
    
    public Iterator getIterator();
}
