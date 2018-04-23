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
public class DNode<E> {

    private E element;
    private DNode<E> next, previous;
    
    public DNode(E element, DNode<E> previous, DNode<E> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }

    public DNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DNode<E> previous) {
        this.previous = previous;
    }
}
