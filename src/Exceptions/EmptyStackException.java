/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *
 * @author Pedro
 */
public class EmptyStackException extends RuntimeException {

    public EmptyStackException(String msg) {
        super(msg);
    }
}
