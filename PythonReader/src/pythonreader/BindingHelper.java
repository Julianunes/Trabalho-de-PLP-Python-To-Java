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
public class BindingHelper implements PythonHelper{
    
    Lexer l = new Lexer();
    
    @Override
    public void nextLine(String line) {
       line = line.replaceAll(" ", "");
       String[] sides = line.split("=");
       
       if(line.contains("input") && !l.getLexema().contains("in")){
           l.setLexema("Scanner in = new Scanner (System.in);" + "\r\n" + l.getLexema());
       }
       
       if(sides[1].startsWith("int")){
           l.setLexema(l.getLexema() + "int " + sides[0] + " = in.nextInt(); \r\n");
       }else if(sides[1].startsWith("float")){
           l.setLexema(l.getLexema() + "float " + sides[0] + " = in.nextFloat(); \r\n");
       }else if(sides[1].startsWith("boolean")){
           l.setLexema(l.getLexema() + "boolean " + sides[0] + " = in.nextBoolean(); \r\n");
       }else if(sides[1].startsWith("input")){
           l.setLexema(l.getLexema() + "char " + sides[0] + " = in.next().charAt(0); \r\n");
       }else{ 
           String aux2 [] = l.getLexema().split(" ");
           boolean flag = false;
           for(int i = 0;i<aux2.length;i++){
               if(aux2[i].startsWith(sides[0])){
                   flag = true;
               }
           }
           if(flag){
           if(sides[1].matches("[0-9]+")){
               l.setLexema(l.getLexema() + sides[0] + " = " + sides[1] +  "; \r\n");
           }else if(sides[1].matches("[+-]?([0-9]*[.])?[0-9]+")){
               l.setLexema(l.getLexema() + sides[0] + " = " + sides[1] +  "f; \r\n");
           }else if(sides[1].compareToIgnoreCase("True")==0){
               l.setLexema(l.getLexema() + sides[0] + " = " + "true" +  "; \r\n");
           }else if(sides[1].compareToIgnoreCase("False")==0){
               l.setLexema(l.getLexema() + sides[0] + " = " + "false" +  "; \r\n");
           }else if(sides[1].matches("'[A-Za-z]'")){
               l.setLexema(l.getLexema() + sides[0] + " = " + sides[1]+  "; \r\n");
           }else{
               l.setLexema(l.getLexema() + sides[0] + " = " + sides[1] + ";" + "\r\n");
           }
           }else{
              if(sides[1].matches("[0-9]+")){
               l.setLexema(l.getLexema() + "int " + sides[0] + " = " + sides[1] +  "; \r\n");
           }else if(sides[1].matches("[+-]?([0-9]*[.])?[0-9]+")){
               l.setLexema(l.getLexema() + "float " + sides[0] + " = " + sides[1] +  "f; \r\n");
           }else if(sides[1].compareToIgnoreCase("True")==0){
               l.setLexema(l.getLexema() + "boolean " + sides[0] + " = " + "true" +  "; \r\n");
           }else if(sides[1].compareToIgnoreCase("False")==0){
               l.setLexema(l.getLexema() + "boolean " + sides[0] + " = " + "false" +  "; \r\n");
           }else if(sides[1].matches("'[A-Za-z]'")){
               l.setLexema(l.getLexema() + "char " + sides[0] + " = " + sides[1]+  "; \r\n");
           }else{
               String teste = sides[1];
               teste = teste.replaceAll("/", " ");
               teste = teste.replaceAll("\\+", " ");
               teste = teste.replaceAll("\\*", " ");
               teste = teste.replaceAll("-", " ");
               teste = teste.replaceAll("\\)", "");
               teste = teste.replaceAll("\\(", "");
               
               String [] aux = teste.split(" ");
               
               for(int i = 0;i <aux.length;i++){
                  if(l.getLexema().contains("int " + aux[i]) || l.getLexema().matches("[0-9]+")){
                      
                  }else if(l.getLexema().contains("float " + aux[i]) || l.getLexema().matches("[+-]?([0-9]*[.])?[0-9]+")){
                      l.setLexema(l.getLexema() + "float " + sides[0] + " = " + sides[1] + ";" + "\r\n");
                      return;
                  }
               }
               l.setLexema(l.getLexema() + "int " + sides[0] + " = " + sides[1] + ";" + "\r\n");
           } 
           }
       }
    }
        
}
    

