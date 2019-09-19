
package projetoagenda.View;

import java.util.Scanner;
import projetoagenda.controler.AgendaControler;
import projetoagenda.model.Contato;
import projetoagenda.model.Endereco;

public class ContatoView {
    
    Scanner ent = new Scanner(System.in);
    AgendaControler controler = new AgendaControler();
    
    public void cadastroContatoView(){
        String nome;
        String celular;
        String rua;
        String complemento;
        String bairro,cidade,estado, pais;
        Endereco endereco;
        int num;
        Contato contato;
        String mensagem;
        
        System.out.print("Nome:");
        nome = ent.nextLine();
        System.out.print("Celular:");
        celular = ent.nextLine();
        System.out.print("Rua:");
        rua = ent.nextLine();
        System.out.print("Número:");
        num = ent.nextInt();
        System.out.print("Complemento:");
        complemento = ent.nextLine(); ent.nextLine();
        System.out.print("Bairro:");
        bairro = ent.nextLine();
        System.out.print("Cidade:");
        cidade = ent.nextLine();
        System.out.print("Estado:");
        estado = ent.nextLine();
        System.out.print("País:");
        pais = ent.nextLine();
        
        endereco = new Endereco(rua, num, complemento, bairro, cidade, estado, pais, rua);
        contato = new Contato(nome, celular, endereco);
        
        mensagem = controler.cadastroContatoControler(contato);
       
    }
    
    public void buscarContatoView(){
        String celular;
        Contato aux;
        System.out.print("Celular:");
        celular = ent.nextLine();
        
        aux = controler.buscaContatoControler(celular);
        if(aux == null){
            System.out.println("Contato não cadastrado!");
        }
        else{
            System.out.println(aux);
        }
    }
    
    public void removerContatoView(){
        String celular;
        boolean confirma;
        System.out.print("Informe o numero:");
        celular = ent.nextLine();
        confirma = controler.removeContato(celular);
        if(confirma == true){
            System.out.println("Contato removido com sucesso!");
        }
        else{
            System.out.println("Contato não cadastrado");
        }
    }
    
   /* public String alterarNumeroContatoView(){
        
    }
    
    public String alterarEnderecoContatoView(){
        return null;
    }*/
    
}
