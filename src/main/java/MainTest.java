
import com.alunos.agendamentopetshop.model.dao.ClienteDao;
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
        
        
        ClienteDao dao = new ClienteDao();
        
        Cliente cliente = new Cliente("zaza", "16641035471", "981155288", null, "zaza@gmail.com", "1234");
        
        dao.salvar(cliente);
    }
}
