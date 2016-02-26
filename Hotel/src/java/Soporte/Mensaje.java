package Soporte;

/**
 * @author angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Mensaje {

    private static final String MODIFICADO = "El %s ha sido modificado con exito.";
    private static final String MODIFICADA = "La %s ha sido modificada con exito.";
    private static final String AGREGADO = "El %s ha sido agregado.";
    private static final String AGREGADA = "La %s ha sido agregada.";
    private static final String ELIMINADO = "El %s ha sido eliminado.";
    private static final String ELIMINADA = "La %s ha sido eliminado.";
    private static final String ELEXISTE = "El %s ya existe!";
    private static final String LAEXISTE = "La %s ya existe!";
    private static final String USADOPORUNA = "El %s esta siendo utilizado por alguna %s, debe eliminarla o desvincularlos para poder eliminar este %s!";
    private static final String USADOPORUN = "El %s esta siendo utilizado por algun %s, debe eliminarlo o desvincularlos para poder eliminar este %s!";
    private static final String USADAPORUNA = "La %s esta siendo utilizada por alguna %s, debe eliminarla o desvincularlas para poder eliminar esta %s!";
    private static final String USADAPORUN = "La %s esta siendo utilizada por algun %s, debe eliminarlo o desvincularlos para poder eliminar esta %s!";
    private static final String CODIGOYAENVIADO = "Ya se ha enviado un email con el codigo a la direccion ingresada. En %d minutos podra generar otro codigo.";
    private static final String CUENTAAVISO = "Le recordamos que su suscripción actual está próxima a vencer. Vencera el %s";
    //************************************************************************//
    //Nombre de clases...//
    public static final String USUARIO = "Usuario";
    public static final String SEXO = "Sexo";
    public static final String TIPOPAGO = "Tipo Pago";
    public static final String PERSONAS = "Personas";
    public static final String PERSONA = "Persona";
    public static final String TIPODOCUMENTO = "Tipo Documento";
    public static final String MODULO = "Modulo";
    public static final String PLAN = "Plan";
    public static final String HOTEL = "Hotel";
    public static final String HABITACION = "Habitacion";
    public static final String TIPOHABITACION = "Tipo Habitacion";
    public static final String RESERVA = "Reserva";
    public static final String TEMPORADA = "Temporada";
    public static final String TARIFA = "Tarifa";
    //************************************************************************//
    //Mensajes de validacion//
    public static final String PAGO = "Pago";
    public static final String INGRESENOMBRE = "Ingrese un nombre.";
    public static final String INGRESESIMBOLO = "Ingrese un simbolo.";
    public static final String INGRESEDIRECCION = "Ingrese una dirección.";
    public static final String INGRESEUNCODIGO = "Ingrese un codigo.";
    public static final String SELECCIONEUBIACION = "Seleccione una ubicacion en el mapa.";
    public static final String INGRESETITULO = "Ingrese un título.";
    public static final String INGRESEAPELLIDO = "Ingrese un apellido.";
    public static final String INGRESENICK = "Ingrese un nick.";
    public static final String INGRESECLAVE = "Ingrese una clave.";
    public static final String INGRESEUSUARIO = "Ingrese el usuario.";
    public static final String INGRESECLAVEACTUAL = "Ingrese su clave actual.";
    public static final String USERCLAVEINCORRECTO = "Usuario o Contraseña incorrectos.";
    public static final String INGRESEMAIL = "Ingrese un email.";
    public static final String ERRORVALIDAR = "Error al validar el usuario.";
    public static final String CODIGOCREADO = "Se ha enviado un email con el codigo a la direccion ingresada. Verifique en la carpeta de SPAM.";
    public static final String INGRESECODIGO = "Ingrese el codigo.";
    public static final String CODIGOINCORRECTO = "El codigo ingresado no es correcto.";
    public static final String INGRESENUEVACLAVE = "Ingrese la nueva clave.";
    public static final String MINIMOCARACTERES = "Mínimo 5 caracteres.";
    public static final String REPITACLAVE = "Repita la clave.";
    public static final String CLAVENOCOINCIDE = "La clave no coincide.";
    public static final String CLAVECAMBIADA = "Clave cambiada con exito.";
    public static final String CLAVEINGRESADAMAL = "Su clave ingresada no es correcta.";
    public static final String CODIGOENUSO = "El codigo ingresado ya se encuentra en uso.";
    public static final String EMAILNOENVIADO = "Lo sentimos pero su consulta no ha sido enviado.";
    public static final String EMAILENVIADO = "Recibimos tu consulta correctamente.Nos comunicaremos a la brevedad.";
    public static final String INGRESETELEFONO = "Ingrese un teléfono.";
    public static final String INGRESECONSULTA = "Ingrese su consulta.";
    public static final String INGRESERECARGO = "Ingrese un recargo positivo.";
    public static final String INGRESECARACTERISTICA = "Ingrese una característica.";
    public static final String PRECIONOVALIDO = "Ingrese un precio valido.";
    public static final String IDINVALIDO = "Id invalido.";
    public static final String NICKNODISPONIBLE = "Este nombre de usuario no se encuentra disponible.";
    public static final String EMAILNODISPONIBLE = "Este email no se encuentra disponible.";
    public static final String PLANNOEXISTE = "El plan seleccionado no existe.";
    public static final String EMAILNOVALIDO = "El formato del email no es correcto.";
    public static final String INGRESECAPACIDAD = "Ingese la capacidad de la habitacion";
    public static final String INGRESENOMBREHABITACION = "Ingrese el nombre de la habitacion.";
    public static final String INGRESENOMBRETIPOHABITACION = "Ingrese el nombre del tipo de habitacion.";
    public static final String ELTIPOHABITACIONNOESVALIDO = "El " + TIPOHABITACION + " no es valido.";
    public static final String IDHOTELINVALIDO = "Usted no tiene acceso a este objeto.";
    public static final String INGRESENOMBRETEMPORADA = "Ingrese el nombre de la temporada.";
    public static final String INGRESEFECHAFIN = "Ingrese la fecha de finalizacion..";
    public static final String INGRESEFECHAINICIO = "Ingrese la fecha de inicio.";
    public static final String FORMATOFECHANOCORRECTO = "El formato de la fecha ingresada no es correcto.";
    public static final String SELECCIONEUNTIPODEHABITACION = "Seleccione almenos un " + TIPOHABITACION + ".";
    public static final String LATEMPORADANOESVALIDO="La " + TEMPORADA + " no es valida.";;

    /**
     * Crea un mensaje con el tiempo pasado por parametro. "Ya se ha enviado un
     * email con el codigo a la direccion ingresada. En %d minutos podra generar
     * otro codigo."
     *
     * @param arg El tiempo.
     * @return EL mensaje.
     */
    public static String getCodigoYaEnviado(long arg) {
        return String.format(CODIGOYAENVIADO, arg);
    }

    /**
     * Crea un mensaje que notifica que la cuenta esta proxima a vencer. "Le
     * recordamos que su suscripción actual está próxima a vencer. Vencera el
     * %s"
     *
     * @param arg La fecha que vencera.
     * @return El mensaje.
     */
    public static String getAviso(String arg) {
        return String.format(CUENTAAVISO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue modificado. "El %s ha sido
     * modificado con exito.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public static String getModificado(String arg) {
        return String.format(MODIFICADO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue modificado. "La %s ha sido
     * modificada con exito.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public static String getModificada(String arg) {
        return String.format(MODIFICADA, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue agregado. "El %s ha sido
     * agregado.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public static String getAgregado(String arg) {
        return String.format(AGREGADO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue agregado. "La %s ha sido
     * agregada.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public static String getAgregada(String arg) {
        return String.format(AGREGADA, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue eliminado. "El %s ha sido
     * eliminado.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public static String getEliminado(String arg) {
        return String.format(ELIMINADO, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto fue eliminado. "La %s ha sido
     * eliminado.";
     *
     * @param arg El objeto.
     * @return El mensaje.
     */
    public static String getEliminada(String arg) {
        return String.format(ELIMINADA, arg);
    }

    /**
     * Crea un mensaje que notifica que el nombre ingresado ya esta ocupado. "El
     * %s ya existe!"
     *
     * @param arg El objeto usado.
     * @return El mensaje.
     */
    public static String getElExiste(String arg) {
        return String.format(ELEXISTE, arg);
    }

    /**
     * Crea un mensaje que notifica que el nombre ingresado ya esta ocupado. "La
     * %s ya existe!"
     *
     * @param arg El objeto usado.
     * @return El mensaje.
     */
    public static String getLaExiste(String arg) {
        return String.format(LAEXISTE, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "El %s esta siendo utilizado por alguna %s, debe
     * eliminarla o desvincularlos para poder eliminar este %s!"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public static String getUsadoPorUna(String arg, String arg2) {
        return String.format(USADOPORUNA, arg, arg2, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "La %s esta siendo utilizada por alguna %s, debe
     * eliminarla o desvincularlas para poder eliminar esta %s!"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public static String getUsadaPorUna(String arg, String arg2) {
        return String.format(USADAPORUNA, arg, arg2, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "El %s esta siendo utilizado por algun %s, debe
     * eliminarlo o desvincularlos para poder eliminar este %s!"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public static String getUsadoPorUn(String arg, String arg2) {
        return String.format(USADOPORUN, arg, arg2, arg);
    }

    /**
     * Crea un mensaje que notifica que el objeto no se puede eliminar porque
     * está siendo usado. "La %s esta siendo utilizada por algun %s, debe
     * eliminarlo o desvincularlos para poder eliminar esta %s!"
     *
     * @param arg El objeto usado.
     * @param arg2 Quien usa al objeto.
     * @return El mensaje.
     */
    public static String getUsadaPorUn(String arg, String arg2) {
        return String.format(USADAPORUN, arg, arg2, arg);
    }

}//end Mensaje
