package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Agencia;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public interface IAgencia extends IGenericDAO<Agencia,Integer> {

	public List<Agencia> listar();

}