package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Agencia;
import Persistencia.ORM.DAOInterface.IAgencia;
import Persistencia.ORM.Util.GenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class AgenciaDAO extends GenericDAO<Agencia, Integer> implements IAgencia {

    @Override
    public List<Agencia> listar() {
        return null;
    }

}//end AgenciaDAO
