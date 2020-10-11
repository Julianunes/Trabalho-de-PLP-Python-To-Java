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
public class Lexer {
    private static String lexema = "";
    
    public String getLexema(){
        return lexema;
    }
    
    public void setLexema(String lexema){
        this.lexema = lexema;
    }
    
    @Override
    public String toString(){
        return lexema;
    }
}
