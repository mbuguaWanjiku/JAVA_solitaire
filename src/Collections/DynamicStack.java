/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import Exceptions.EmptyStackException;

/**
 *
 * @author lbsilva
 */
public class DynamicStack<E> implements Stack<E>, Cloneable {

    private Node<E> top;
    private int size;

    public DynamicStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack vazia");
        }
        return top.getElement();
    }

    @Override
    public void push(E element) {
        Node node = new Node(element, top);
        top = node;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack vazia");
        }
        E element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public Iterator getIterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        
        private Node<E> cursor;
        
        public StackIterator() {
            Node<E> tempNode = top;
            DynamicStack<E> tempStack = new DynamicStack<>();
            for (int i = 0; i < size; i++) {
                tempStack.push(tempNode.getElement());
                tempNode = tempNode.getNext();
            }
            cursor = tempStack.top;
        }

        @Override
        public E next() {
            E element = cursor.getElement();
            cursor = cursor.getNext();
            return element;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }
    }
}
