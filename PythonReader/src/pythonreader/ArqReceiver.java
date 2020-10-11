/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pythonreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Júlia Nunes
 */
public class ArqReceiver {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Scanner in = new Scanner (System.in);
        BindingHelper b = new BindingHelper();
        OutputHelper o = new OutputHelper();
        ConditionalHelper c = new ConditionalHelper();
        PythonHelper p = null;
        Printer pr = new Printer();
        Lexer l = new Lexer();
        AddFinalKey add= new AddFinalKey();
        String dir = "C:\\Users\\Júlia Nunes\\Documents\\NetBeansProjects\\PythonReader\\src\\pythonreader\\PythonCode.txt";


        
        try(BufferedReader br = new BufferedReader(new FileReader(dir))) {
                    
		    for(String line; (line = br.readLine()) != null; ) {
		        if ((line.contains("=") && !line.contains("==") && !line.contains("<=") && !line.contains(">=") && !line.contains("!=")) ) {
                                p = b;
                                p.nextLine(line);
		        }else if(line.contains("print")){
                                p = o;
                                p.nextLine(line);
                        }else if(line.contains("if") || line.contains( "else") || line.contains("#fecha")){
                                p = c;
                                p.nextLine(line);
                        }
                        
    
                        
        		        //tratar outros casos
		        
		    }
                    
		}
        add.addkey();
        pr.printcode();
    }
    
}
