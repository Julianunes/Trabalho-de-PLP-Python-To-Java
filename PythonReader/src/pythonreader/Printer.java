/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pythonreader;

/**
 *
 * @author Júlia Nunes
 */
public class Printer {
    Lexer l = new Lexer();
    public void printcode(){
        System.out.print(l);
    }
}
