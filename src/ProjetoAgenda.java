
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import projetoagenda.View.Menus;
import projetoagenda.controler.AgendaControler;




public class ProjetoAgenda {

    
    public static void main(String[] args) {
        
        
        AgendaControler control = new AgendaControler();
        
        control.recuperarDadosClientes();
        Menus menu = new Menus();
        menu.menu();
    }
    
}
