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
public interface List<E> {

    public int size();

    public boolean isEmpty();

    public E get(int i) throws IndexOutOfBoundsException;

    public void add(int i, E elem) throws IndexOutOfBoundsException;

    public E remove(int i) throws IndexOutOfBoundsException;
    
    public E remove(E elem) throws IndexOutOfBoundsException;

    public E set(int i, E elem) throws IndexOutOfBoundsException;
    
    public Iterator getIterator();
}
