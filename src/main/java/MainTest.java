
import com.alunos.agendamentopetshop.model.dao.ClienteDaoImpl;
import com.alunos.agendamentopetshop.model.entidades.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class MainTest {
    public static void main(String[] args){
        
        
        ClienteDaoImpl dao = new ClienteDaoImpl();
        
        Cliente cliente = new Cliente("izack", "16541035471", "981155288", null, "izack@gmail.com", "4321");
        
        dao.salvar(cliente);
    }
}
