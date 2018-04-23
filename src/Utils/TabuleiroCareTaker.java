/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Collections.Stack;
import Collections.DynamicStack;

/**
 *
 * @author lbsilva
 */
public class TabuleiroCareTaker {

    private Stack<Memento> undos;
    private Stack<Memento> redos;

    public TabuleiroCareTaker() {
        this.undos = new DynamicStack<>();
        this.redos = new DynamicStack<>();
    }

    public void saveState(TabuleiroInfo tabuleiro) {
        undos.push(tabuleiro.save());
        if (!redos.isEmpty()) {
            redos = new DynamicStack<>();
        }
    }

    public void saveRedoState(TabuleiroInfo tabuleiro) {
        redos.push(tabuleiro.save());
    }
    
    public void undo(TabuleiroInfo tabuleiro) {
        tabuleiro.restore(undos.pop());
    }
    
    public void redo(TabuleiroInfo tabuleiro) {
        undos.push(tabuleiro.save());
        tabuleiro.restore(redos.pop());
    }
    
    public boolean hasUndos() {
        return !undos.isEmpty();
    }
    
    public boolean hasRedos() {
        return !redos.isEmpty();
    }
}
