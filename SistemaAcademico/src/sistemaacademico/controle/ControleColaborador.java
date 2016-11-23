package sistemaacademico.controle;

import java.util.ArrayList;
import java.util.HashMap;
import sistemaacademico.dao.DaoColaborador;
import sistemaacademico.modelo.Colaborador;

public class ControleColaborador {

    public static ArrayList<HashMap<String, Object>> recuperarTodos() {
        ArrayList<Colaborador> colaboradores = DaoColaborador.recuperarTodos();
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (Colaborador c : colaboradores) {
            result.add(c.toHashMap());
        }

        return result;
    }

}
