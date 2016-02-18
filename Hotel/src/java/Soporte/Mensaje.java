package Soporte;

/**
 * @author angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Mensaje {

    private static final String modificado = "El %s ha sido modificado con exito.";
    private static final String modificada = "La %s ha sido modificada con exito.";
    private static final String agregado = "El %s ha sido agregado.";
    private static final String agregada = "La %s ha sido agregada.";
    private static final String eliminado = "El %s ha sido eliminado.";
    private static final String eliminada = "La %s ha sido eliminado.";
    private static final String elExiste = "El %s ya existe!";
    private static final String laExiste = "La %s ya existe!";
    private static final String usadoPorUna = "El %s esta siendo utilizado por alguna %s, debe eliminarla o desvincularlos para poder eliminar este %s!";
    private static final String usadoPorUn = "El %s esta siendo utilizado por algun %s, debe eliminarlo o desvincularlos para poder eliminar este %s!";
    private static final String usadaPorUna = "La %s esta siendo utilizada por alguna %s, debe eliminarla o desvincularlas para poder eliminar esta %s!";
    private static final String usadaPorUn = "La %s esta siendo utilizada por algun %s, debe eliminarlo o desvincularlos para poder eliminar esta %s!";
    private static final String codigoYaEnviado = "Ya se ha enviado un email con el codigo a la direccion ingresada. En %d minutos podra generar otro codigo.";
    private static final String cuentaAviso = "Le recordamos que su suscripción actual está próxima a vencer. Vencera el %s";
    //************************************************************************//
    //Nombre de clases...//
    public static final String usuario = "usuario";
    public static final String sexo = "sexo";
    public static final String tipoPago = "Tipo Pago";
    public static final String personas = "Personas";
    public static final String persona = "Persona";
    public static final String tipoDocumento = "Tipo Documento";
    public static final String modulo = "Modulo";
    public static final String plan = "Plan";
    public static final String hotel = "Hotel";
    //************************************************************************//
    //Mensajes de validacion//
    public static final String pago = "Pago";
    public static final String ingreseNombre = "Ingrese un nombre.";
    public static final String ingreseSimbolo = "Ingrese un simbolo.";
    public static final String ingreseDireccion = "Ingrese una dirección.";
    public static final String ingreseUnCodigo = "Ingrese un codigo.";
    public static final String seleccioneUbicacion = "Seleccione una ubicacion en el mapa.";
    public static final String ingreseUnaImagen = "Ingrese al menos una imagen.";
    public static final String ingreseTitulo = "Ingrese un título.";
    public static final String ingreseApellido = "Ingrese un apellido.";
    public static final String ingreseNick = "Ingrese un nick.";
    public static final String ingreseClave = "Ingrese una clave.";
    public static final String ingreseUsuario = "Ingrese el usuario.";
    public static final String ingreseClaveActual = "Ingrese su clave actual.";
    public static final String userClaveIncorrecto = "Usuario o Contraseña incorrectos.";
    public static final String ingreseMail = "Ingrese un email.";
    public static final String errorValidar = "Error al validar el usuario.";
    public static final String codigoCreado = "Se ha enviado un email con el codigo a la direccion ingresada. Verifique en la carpeta de SPAM.";
    public static final String ingreseCodigo = "Ingrese el codigo.";
    public static final String codigoIncorrecto = "El codigo ingresado no es correcto.";
    public static final String ingreseNuevaClave = "Ingrese la nueva clave.";
    public static final String minimoCaracteres = "Mínimo 5 caracteres.";
    public static final String repitaClave = "Repita la clave.";
    public static final String claveNoCoincide = "La clave no coincide.";
    public static final String claveCambiada = "Clave cambiada con exito.";
    public static final String claveIngresadaMal = "Su clave ingresada no es correcta.";
    public static final String codigoEnUso = "El codigo ingresado ya se encuentra en uso.";
    public static final String emailNoEnviado = "Lo sentimos pero su consulta no ha sido enviado.";
    public static final String emailEnviado = "Recibimos tu consulta correctamente.Nos comunicaremos a la brevedad.";
    public static final String ingreseTelefono = "Ingrese un teléfono.";
    public static final String ingreseConsulta = "Ingrese su consulta.";
    public static final String ingreseRecargo = "Ingrese un recargo positivo.";
    public static final String ingreseCaracteristica = "Ingrese una característica.";
    public static final String precioNoValido = "Ingrese un precio valido.";
    public static final String idInvalido = "Id invalido.";
    public static final String nickNoDisponible = "Este nombre de usuario no se encuentra disponible.";
    public static final String emailNoDisponible = "Este email no se encuentra disponible.";
    public static final String planNoExiste = "El plan seleccionado no existe.";
    public static final String emailNoValido = "El formato del email no es correcto.";

    /**
     * Crea un mensaje con el tiempo pasado por parametro. "Ya se ha enviado un
     * email con el codigo a la direccion ingresada. En %d minutos podra generar
     * otro codigo."
     *
     * @param arg El tiempo.
     * @return EL mensaje.
     */
    public static String getCodigoYaEnviado(long arg) {
        return String.format(codigoYaEnviado, arg);
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
        return String.format(cuentaAviso, arg);
    }

    public static String getModificado(String arg) {
        return String.format(modificado, arg);
    }

    public static String getModificada(String arg) {
        return String.format(modificada, arg);
    }

    public static String getAgregado(String arg) {
        return String.format(agregado, arg);
    }

    public static String getAgregada(String arg) {
        return String.format(agregada, arg);
    }

    public static String getEliminado(String arg) {
        return String.format(eliminado, arg);
    }

    public static String getEliminada(String arg) {
        return String.format(eliminada, arg);
    }

    public static String getElExiste(String arg) {
        return String.format(elExiste, arg);
    }

    public static String getLaExiste(String arg) {
        return String.format(laExiste, arg);
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
        return String.format(usadoPorUna, arg, arg2, arg);
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
        return String.format(usadaPorUna, arg, arg2, arg);
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
        return String.format(usadoPorUn, arg, arg2, arg);
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
        return String.format(usadaPorUn, arg, arg2, arg);
    }

}//end Mensaje
