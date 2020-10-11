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
public class OutputHelper implements PythonHelper{
    
    Lexer l = new Lexer();
    
    @Override
    public void nextLine(String line) {
      String [] part = line.split("print");
      part[1] = part[1].replaceAll(",", "+");
      l.setLexema(l.getLexema()+ "System.out.println" + part[1] + ";" + "\r\n");
    }
    
}
