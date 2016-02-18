/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.TipoDocumento;
import Persistencia.ORM.DAOImplementacion.TipoDocumentoDAO;
import Persistencia.ORM.DAOInterface.ITipoDocumento;
import java.util.List;

/**
 *
 * @author flore
 */
public interface IControladorTipoDocumento {

    final ITipoDocumento TIPODOCUMENTODAO = new TipoDocumentoDAO();

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el
     * del propio tipo de documento devolvera true.
     *
     * @param id
     * @param nombre
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre);

    /**
     * modifica los datos de un tipo de documento.
     *
     * @param id
     * @param nombre
     */
    public void actualizar(int id, String nombre);

    /**
     * guarda un tipo de documento.
     *
     * @param nombre
     */
    public void guardar(String nombre);

    /**
     * verifica si el tipo de documento esta asociado a alguna persona.
     *
     * @param id el tipo de documento a verificar
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * Busca todos los tipos de documentos existenes.
     *
     * @return
     */
    public List<TipoDocumento> getTodos();

    /**
     * elimina el tipo de documento
     *
     * @param id
     */
    public void eliminar(int id);

    /**
     * recupera un tipo de pago de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public TipoDocumento getUno(int id);
}
