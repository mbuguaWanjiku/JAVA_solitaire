/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author lbsilva
 * @param <E>
 */
public class DoubleLinkedList<E> implements List<E> {

    private DNode<E> first;
    private DNode<E> last;
    private int size;

    public DoubleLinkedList() {
        this.first = new DNode<>(null, null, null);
        this.last = new DNode<>(null, first, null);
        this.first.setNext(last);
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return searchNode(i).getElement();
    }

    @Override
    public void add(int i, E elem) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        DNode<E> temp = searchNode(i);
        DNode<E> prev = temp.getPrevious();
        DNode<E> newNode = new DNode<>(elem, prev, temp);
        temp.setPrevious(newNode);
        prev.setNext(newNode);
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        DNode<E> temp = searchNode(i);
        E elem = temp.getElement();
        DNode<E> prev = temp.getPrevious();
        DNode<E> next = temp.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        size--;
        return elem;
    }

    @Override
    public E set(int i, E elem) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size)  {
            throw new IndexOutOfBoundsException();
        }
        DNode<E> temp = searchNode(i);
        E toReturn = temp.getElement();
        temp.setElement(elem);
        return toReturn;
    }

    private DNode<E> searchNode(int index) {
        DNode<E> temp = first.getNext();
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    
    private int searchElement(E element) {
        DNode<E> temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.getElement().equals(element)) {
                return i;
            } else {
                temp = temp.getNext();
            }
        }
        return -1;
    }

    @Override
    public Iterator getIterator() {
        return new DoubleLinkedListIterator();
    }

    @Override
    public E remove(E elem) throws IndexOutOfBoundsException {
        int index = searchElement(elem);
        if (index == -1) {
            throw new IndexOutOfBoundsException();
        } else {
            E element = remove(index);
            return element;
        }
    }
    
    private class DoubleLinkedListIterator implements Iterator<E> {

        private DNode<E> temp;
        private int cursor;
        
        public DoubleLinkedListIterator() {
            temp = first;
            cursor = 0;
        }
        
        @Override
        public E next() {
            E element = temp.getElement();
            temp = temp.getNext();
            return element;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }
        
    }
}
