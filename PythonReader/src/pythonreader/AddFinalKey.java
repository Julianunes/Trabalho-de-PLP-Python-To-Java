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
public class AddFinalKey {
    Lexer l = new Lexer();
    
    public void addkey(){
        String [] linha = l.getLexema().split("\r\n");
        for(int i=0;i<linha.length;i++){
            if(linha[i].contains("if")){
                String aux = linha[i].replaceAll("else ", "");
                String [] cond = null;
                if(linha[i].contains("==")){
                    cond = aux.split("==");
                }else if(linha[i].contains("<=")){
                    cond = aux.split("<=");
                }else if(linha[i].contains(">=")){
                    cond = aux.split(">=");
                }else if(linha[i].contains(">")){
                    cond = aux.split(">");
                }else if(linha[i].contains("<")){
                    cond = aux.split("<");
                }
                for(int j= i+1;j<linha.length;j++){
                    if(linha[j].contains("if")){
                    String aux2 = linha[i].replaceAll("else ", "");
                        String [] cond2 = null;
                        if(linha[i].contains("==")){
                             cond2 = aux2.split("==");
                        }else if(linha[i].contains("<=")){
                             cond2 = aux2.split("<=");
                        }else if(linha[i].contains(">=")){
                             cond2 = aux2.split(">=");
                        }else if(linha[i].contains(">")){
                             cond2 = aux2.split(">");
                        }else if(linha[i].contains("<")){
                             cond2 = aux2.split("<");
                        }
                          if(linha[i].contains(cond[0]) && linha[j].contains(cond2[0])){
                              if(linha[j-1].contains("if")){
                              linha[j-1] = "}" + "\r\n" + linha[j-1];
                              break;
                              }else{
                              linha[j] = "}" + "\r\n" + linha[j];
                              }
                          }
                        
                    } 
                }
            }else if(linha[i].startsWith("else")){
                for(int a=i; i<linha.length;a=a-1){
                    if(linha[a].contains("else if")){
                       linha[i] = "}" + "\r\n" + "}" + linha[i];
                       break;
                    }
                }
                linha[i+2] = "}" + "\r\n" + linha[i+2];
            }
        }
        l.setLexema("");
        for(int k = 0;k<linha.length;k++){
            l.setLexema(l.getLexema() + linha[k] + "\r\n");
        }
        l.setLexema(l.getLexema() + "}" + "\r\n");
    }
}
