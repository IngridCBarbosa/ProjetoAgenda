
package projetoagenda.controler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import projetoagenda.dao.AgendaDao;
import projetoagenda.model.Contato;
import projetoagenda.model.Endereco;


public class AgendaControler {
    private List <Contato>agenda = new ArrayList<Contato>();
    private AgendaDao arq = new AgendaDao();
   
    
    public String cadastroContatoControler(Contato c){
        Contato busca;
        String mensagem1 ="Contato Cadastrado com sucesso";
        String mensagem2 = "Contato já existente na agenda";
        if(agenda == null){
            agenda.add(c);
        }
        else{
            busca = buscaContatoControler(c.getCelular());
            if(busca == null){
                agenda.add(c);
                return mensagem1;
            }
        }
        return mensagem2;
    }
    
    public Contato buscaContatoControler(String celular){
        Contato achou = null;
        for(Contato contato : agenda){
            if(contato.getCelular().equals(celular) == true){
                achou = contato;
                break;
            }
        }
        return achou;
    }
    
    public boolean removeContato(String celular){
        Contato aux;
        aux = buscaContatoControler(celular);
        if(aux == null){
            return false;
        }
        else{
            agenda.remove(aux);
            return true;
        }
    }
    public boolean atualizaEndereco(Endereco e,String c){
        Contato aux;
        aux = buscaContatoControler(c);
        if(aux == null){
            return false;
            
        }else{
            aux.setEndereco(e);
            return true;
        }
    }
    
    public boolean atualizaNumero(String celular){
      Contato aux;
      aux = buscaContatoControler(celular);
      if(aux == null){
          return false;
      }
      else{
          aux.setCelular(celular);
          return true;
      }
    }
    
    public void listarContato(){
        for(Contato c : agenda){
            System.out.println(c);
        }
    }
    
    
    // PARTE DO ARQUIVO
     public void recuperarDadosClientes(){
        File arq = new File("Contato.dat");
        Contato c;
        
        AgendaDao arqvo = new AgendaDao();
        if(arq.exists() == true){
            arqvo.openToRead("Clientes.dat");
            do{
                c = arqvo.lerObjeto();
                if(c != null){
                    cadastroContatoControler(c);
                }
            }while(c != null);
            arqvo.closeAfterRead();
        }
    }
     
    public void gravarArquivo(){
        arq.openToWrite("Contato.dat");
        for(Contato contato :agenda){
          arq.gravaObjeto(contato);
        }
        arq.closeAfterWrite();
    }
    
    
}
