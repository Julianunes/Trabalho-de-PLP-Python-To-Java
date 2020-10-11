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
public class ConditionalHelper implements PythonHelper{
    
    Lexer l = new Lexer();
    
    @Override
    public void nextLine(String line) {
    if(line.contains("if") && !line.contains("elif")){
            line = line.replaceAll(":", "");
            line = line.replaceAll("if", "");
            String [] parts = line.split(" ");
            String sent = "";
            for(int i=0;i<parts.length;i++){
                if(parts[i].compareToIgnoreCase("or")==0){
                    parts[i] = "||";
                }else if(parts[i].compareToIgnoreCase("and")==0){
                    parts[i] = "&&";
                }
                sent = sent + parts[i];
            }
            l.setLexema(l.getLexema() + "if(" + sent + "){" + "\r\n");
           
        }else if(line.contains("else")){
            line = line.replaceAll(":", "{");
            l.setLexema(l.getLexema() + "" +line + "\r\n");
           
        }else if(line.contains("elif")){
            line = line.replaceAll(":", "");
            line = line.replaceAll("elif", "");
            String [] parts = line.split(" ");
            String sent = "";
            for(int i=0;i<parts.length;i++){
                if(parts[i].compareToIgnoreCase("or")==0){
                    parts[i] = "||";
                }else if(parts[i].compareToIgnoreCase("and")==0){
                    parts[i] = "&&";
                }
                sent = sent + parts[i];
            }
            l.setLexema(l.getLexema() + "else if(" + sent + "){" + "\r\n");    
        }else if(line.contains("#fecha")){
            line = line.replaceAll(" ", "");
            line = line.replaceAll("#fecha", "}");
            l.setLexema(l.getLexema() + line + "\r\n");
        }
    }
    
}
