/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author lbsilva
 */
public class CardNotAllowedException extends RuntimeException {

    public CardNotAllowedException(String string) {
        super(string);
    }
    
}
