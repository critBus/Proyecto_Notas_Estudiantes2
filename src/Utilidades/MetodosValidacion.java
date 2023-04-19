/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import entidades.Usuario;
import java.awt.Component;

/**
 *
 * @author Rene2
 */
public class MetodosValidacion {

    private final static String MSG_NO_PUEDE_ESTAR_VACIO = "No puede estar vacio ";
    private final static String MSG_NO_PUEDE_TENER_NUMEROS = "No puede tener números ";
    private final static String MSG_TIENEN_QUE_SER_SOLO_LETRAS = "Tienen que ser solo letras ";
    private final static String MSG_CANTIDAD_MAXIMA_DE_CARACTERES = "Supera la cantidad máxima de caracteres ";
    private final static String MSG_NO_CARACTERES_ESTRANNOS = "No puede contener caracteres extraños ";
    private final static String MSG_DEBE_CONTENER_LETRAS = "Debe de contener letras ";
    private final static String MSG_YA_EXISTE_FACULTAD = "Ya existe una facultad con este nombre ";
    private final static String MSG_NOMBRES_CON_MAYUSCULA = "Las palabras deben de comenzar en mayúscula";
    private final static String MSG_NOMBRES_SOLO_PRIMERA_LETRA_MAYUSCULA = "Solo la primera letra de un nombre debe ser en mayúscula ";
    private final static String MSG_CANTIDAD_MINIMA_DE_CARACTERES = "No supera la cantidad mínima de caracteres ";
    private final static String MSG_CANTIDAD_CARACTERES_TELEFONO = "Un teléfono debe de contener 8 caracteres ";
    private final static String MSG_TODOS_DEBEN_DE_SER_NUMEROS = "Todos los caracteres deben de ser números ";
    private final static String MSG_YA_EXISTE_ENCARGADO_EN_LOCAL = "Ya existe un encargado en este local con este nombre ";
    private final static String MSG_CANTIDAD_MAXIMA_DE_ENCARGADOS_EN_EL_LOCAL = "Ya se alcanzó la cantidad máxima de encargados en este local ";
    private final static String MSG_DEBEN_TENER_NUMEROS = "Debe de contener números";
    private final static String MSG_YA_EXISTE_USUARIO = "Ya existe este usuario ";
    private final static String MSG_COINCIDIR_CONTRASENNAS = "Tienen que coincidir las contraseñas ";

    public static String obtener_validacion_seguridad_cantrasenna(String s, String confirmar) {
        s = s.trim();
        if (s.isEmpty()) {
            return MSG_NO_PUEDE_ESTAR_VACIO;
        }
        if (s.length() > 50) {
            return MSG_CANTIDAD_MAXIMA_DE_CARACTERES;
        }
        if (s.length() < 8) {
            return MSG_CANTIDAD_MINIMA_DE_CARACTERES;
        }
        confirmar = confirmar.trim();
        if (!confirmar.equals(s)) {
            return MSG_COINCIDIR_CONTRASENNAS;
        }

        boolean contieneLetras = false;
        boolean tieneNumeros = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                contieneLetras = true;
            }
            if (Character.isDigit(c)) {
                tieneNumeros = true;
            }
            if (tieneNumeros && contieneLetras) {
                break;
            }
        }
        if (!contieneLetras) {
            return MSG_DEBE_CONTENER_LETRAS;
        }
        if (!tieneNumeros) {
            return MSG_DEBEN_TENER_NUMEROS;
        }
        return null;
    }

    public static String obtener_validacion_con_letras(String s, int cantidad_minima_caracteres, int cantidad_maxima_caracteres) {
        s = s.trim();
        if (s.isEmpty()) {
            return MSG_NO_PUEDE_ESTAR_VACIO;
        }
        if (s.length() > cantidad_maxima_caracteres) {
            return MSG_CANTIDAD_MAXIMA_DE_CARACTERES;
        }
        if (s.length() < cantidad_minima_caracteres) {
            return MSG_CANTIDAD_MINIMA_DE_CARACTERES;
        }
        boolean contieneLetras = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                contieneLetras = true;
            }
        }
        if (!contieneLetras) {
            return MSG_DEBE_CONTENER_LETRAS;
        }
        return null;
    }

    public static String obtener_validacion_nombre(String s, int cantidad_minima_caracteres, int cantidad_maxima_caracteres) {
        s = s.trim();
        if (s.isEmpty()) {
            return MSG_NO_PUEDE_ESTAR_VACIO;
        }
        if (s.length() > cantidad_maxima_caracteres) {
            return MSG_CANTIDAD_MAXIMA_DE_CARACTERES;
        }
        if (s.length() < cantidad_minima_caracteres) {
            return MSG_CANTIDAD_MINIMA_DE_CARACTERES;
        }
        boolean contieneLetras = false;
        boolean elAnteriorFueEspacio = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            if (!(Character.isLetter(c)  || Character.isWhitespace(c))) {
//                return MSG_NO_CARACTERES_ESTRANNOS;
//            }
            if (Character.isLetter(c)) {
                contieneLetras = true;
                elAnteriorFueEspacio = false;
                if (i == 0 || elAnteriorFueEspacio) {
                    if (!Character.isUpperCase(c)) {
                        return MSG_NOMBRES_CON_MAYUSCULA;
                    }
                } else {
                    if (Character.isUpperCase(c)) {
                        return MSG_NOMBRES_SOLO_PRIMERA_LETRA_MAYUSCULA;
                    }
                }
                continue;
            }
            if (Character.isWhitespace(c)) {
                elAnteriorFueEspacio = true;

                continue;
            }
            return MSG_TIENEN_QUE_SER_SOLO_LETRAS;
        }
        if (!contieneLetras) {
            return MSG_DEBE_CONTENER_LETRAS;
        }
        return null;
    }

    public static String obtener_validacion_string_normal(String s, int cantidad_maxima_caracteres) {
        s = s.trim();
        if (s.isEmpty()) {
            return MSG_NO_PUEDE_ESTAR_VACIO;
        }
        if (s.length() > cantidad_maxima_caracteres) {
            return MSG_CANTIDAD_MAXIMA_DE_CARACTERES;
        }
        boolean contieneLetras = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || Character.isWhitespace(c))) {
                return MSG_NO_CARACTERES_ESTRANNOS;
            }
            if (Character.isLetter(c)) {
                contieneLetras = true;
            }
        }
        if (!contieneLetras) {
            return MSG_DEBE_CONTENER_LETRAS;
        }
        return null;
    }

    private static boolean validar_es_string_normal(Component parentComponent, String s, int cantidad_maxima_caracteres) {
        return validar_es_string_normal(parentComponent, s, cantidad_maxima_caracteres, null);
    }

    private static boolean validar_es_string_normal(Component parentComponent, String s, int cantidad_maxima_caracteres, String principioDeMensaje) {
        String respuesta = obtener_validacion_string_normal(s, cantidad_maxima_caracteres);
        if (respuesta != null) {
            if (principioDeMensaje != null) {
                respuesta = principioDeMensaje + respuesta;
            }
            DLG_Respuesta.mostrarDlgInvalido(parentComponent, respuesta);
        }
        return respuesta == null;
    }

    private static boolean validar_es_con_letras(Component parentComponent, String s, int cantidad_minima_caracteres, int cantidad_maxima_caracteres, String principioDeMensaje) {
        String respuesta = obtener_validacion_con_letras(s, cantidad_minima_caracteres, cantidad_maxima_caracteres);
        if (respuesta != null) {
            if (principioDeMensaje != null) {
                respuesta = principioDeMensaje + respuesta;
            }
            DLG_Respuesta.mostrarDlgInvalido(parentComponent, respuesta);
        }
        return respuesta == null;
    }

    private static boolean validar_es_nombre(Component parentComponent, String s, int cantidad_minima_caracteres, int cantidad_maxima_caracteres, String principioDeMensaje) {
        String respuesta = obtener_validacion_nombre(s, cantidad_minima_caracteres, cantidad_maxima_caracteres);
        if (respuesta != null) {
            if (principioDeMensaje != null) {
                respuesta = principioDeMensaje + respuesta;
            }
            DLG_Respuesta.mostrarDlgInvalido(parentComponent, respuesta);
        }
        return respuesta == null;
    }

    public static boolean validar_seguridad_cantrasenna(Component parentComponent, String contrasenna, String confirmar, String principioDeMensaje) {
        String respuesta = obtener_validacion_seguridad_cantrasenna(contrasenna, confirmar);
        if (respuesta != null) {
            if (principioDeMensaje != null) {
                respuesta = principioDeMensaje + respuesta;
            }
            DLG_Respuesta.mostrarDlgInvalido(parentComponent, respuesta);
        }
        return respuesta == null;
    }

    public static boolean validar_es_nuevo_usuario_correcto(Component parentComponent,
            String username, String contrasenna, String confirmar
    ) throws Exception {
        if (EnMemoria.BD.existeUsuario(username, contrasenna)) {
            DLG_Respuesta.mostrarDlgInvalido(parentComponent, MSG_YA_EXISTE_USUARIO);
            return false;
        }
        return validar_es_con_letras(parentComponent, username, 4, 50, "El username:")
                && validar_seguridad_cantrasenna(parentComponent, contrasenna, confirmar, "En las contraseñas:");
    }

    public static boolean validar_es_modificar_usuario_correcto(Component parentComponent,
            Usuario u, String username
    ) throws Exception {
        if ((!u.getUsername().equals(username)) && EnMemoria.BD.existeUsuario(username)) {
            DLG_Respuesta.mostrarDlgInvalido(parentComponent, MSG_YA_EXISTE_USUARIO);
            return false;
        }
        return validar_es_con_letras(parentComponent, username, 4, 50, "El username:");
    }
    
    public static boolean validar_es_nuevo_Facultad_correcto(Component parentComponent, String nombre) throws Exception {
        if (EnMemoria.BD.existeFacultad(nombre)) {
            DLG_Respuesta.mostrarDlgInvalido(parentComponent, MSG_YA_EXISTE_FACULTAD);
            return false;
        }
        return validar_es_string_normal(parentComponent, nombre, 50);
    }
}