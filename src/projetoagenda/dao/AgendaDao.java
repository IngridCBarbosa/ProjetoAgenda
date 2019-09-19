package projetoagenda.dao;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import projetoagenda.model.Contato;


public class AgendaDao {
    
    
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Contato contato;
    public void openToRead(String nomeArq){
        try{
            FileInputStream arq = new FileInputStream(nomeArq);
            input = new ObjectInputStream(arq);
            System.out.println("Arquivo aberto para leitura");
        }
        catch(IOException ioException){
            System.err.println("Erro ao tentar abrir o arquivo para leitura");
            System.exit(1);
        }
    }
    public void openToWrite(String nomeArq){
        try{
            FileOutputStream arq = new FileOutputStream(nomeArq);
            output = new ObjectOutputStream(arq);
            System.out.println("Arquivo aberto para escrita");
        }
        catch(IOException ioException){
            System.err.println("Erro ao tentar abrir o arquivo para gravação");
            System.exit(1);
        }
    }
    public void closeAfterWrite(){
        try{
            if(output != null){
                output.close();
                output = null;
                System.out.println("Arquivo fechado com secesso");
            }
        }
        catch(IOException ioException){
            System.err.println("Erro ao tentar fechar o arquivo");
        }
    }
   
    public void gravaObjeto(Contato contato){
        try{
            if(output != null){
                output.writeObject(contato);
                output.flush();
            }
        }
        catch(IOException ioExcetion){
            System.err.println("Erro ao tentar gravar no arquivo");
            System.exit(1);
        }
    }
    public Contato lerObjeto(){
       
        try{
            if(input != null){
                contato = (Contato)input.readObject();
                return contato;
            }
        }
        catch(EOFException eofException){
            
            return null;
        }
        catch(IOException ioException){
            System.err.println("Erro ao tentar ler o arquivo");
            return null;
        }
        catch(ClassNotFoundException classNotFounException){
            System.err.println("Classe não encontrada");
            return null;
        }
        return null;
    } 
    public void closeAfterRead(){
        try{
            if(input != null){
                input.close();
                input = null;
                System.out.println("Arquivo fechado com sucesso");
            }
        }catch(IOException ioException){
            System.err.println("Erro ao tentar fechar o arquivo");
            System.exit(1);
        }
    }
    
   
}
