/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Collections.DoubleLinkedList;
import Collections.List;

/**
 *
 * @author lbsilva
 */
public class Subject {

    private List<Observer> observers;
    private boolean changedState;

    /**
     * Onde se situam os observers aos quais se realizam o update caso o changedState = true
     */
    public Subject() {
        this.observers = new DoubleLinkedList<>();
        this.changedState = false;
    }

    /**
     * adicionar um observer
     * @param observer  O observer a adicionar
     */
    public void addObserver(Observer observer) {
        observers.add(observers.size(), observer);
    }

    /**
     * remover um observer
     * @param observer  o observer a remover
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * notificar os observers
     */
    public void notifyObservers() {
        if (changedState) {
            for (int i = 0; i < observers.size(); i++) {
                observers.get(i).update(this);
            }
            changedState = false;
        }
    }
    
    /**
     * referir que algo foi alterado para que quando os observers forem notificados, realizarem o update
     */
    public void changedState() {
        this.changedState = true;
    }
}
