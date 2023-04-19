/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;
import java.util.Base64;
import java.util.Random;
import java.util.stream.IntStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author Rene2
 */
public class MetodoEncriptar {
    public static String encriptar(String strClearText)throws Exception{
         return Base64.getEncoder().encodeToString(strClearText.getBytes("utf-8"));

    }
}
