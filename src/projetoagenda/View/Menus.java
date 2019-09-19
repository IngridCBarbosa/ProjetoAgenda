package projetoagenda.View;

import java.io.File;
import java.util.Scanner;
import projetoagenda.controler.AgendaControler;
import projetoagenda.dao.AgendaDao;

public class Menus {
    
    private Scanner ent = new Scanner(System.in);
    private ContatoView cv = new ContatoView();
    AgendaControler c = new AgendaControler();
    public void menu(){
        int opc;
        
        do{
            System.out.println("1-Cadastrar contato");
            System.out.println("2-Alterar contato");
            System.out.println("3-Buscar contato");
            System.out.println("4-Remover contato");
            System.out.println("5-Sair do sistema");
            opc = ent.nextInt();
            switch(opc){
                case 1:
                    cv.cadastroContatoView();
                    break;
                case 2:
                    alterarContatoMenu();
                    break;
                case 3:
                    cv.buscarContatoView();
                    break;
                case 4:
                    cv.removerContatoView();
                case 5:
                    c.gravarArquivo();
                    break;
                default:System.err.print("Opção inválida. Digite novamente:");
            }
        }while(opc != 5);
    }
    
    private void alterarContatoMenu(){
        int opc;
        
        do{
            System.out.println("1- Alterar numero do contato");
            System.out.println("2- Alterar endereco do contato ");
            System.out.println("3-Sair do módulo de alteração");
            opc = ent.nextInt();
            
            switch(opc){
                case 1:
                   // cv.alterarNumeroContatoView();
                    break;
                case 2:
                    //cv.alterarEnderecoContatoView();
                    break;
                case 3:
                    break;
                default:System.err.print("Opção inválida. Digite novamente:");
            }
        }while(opc != 3);
    }
}
