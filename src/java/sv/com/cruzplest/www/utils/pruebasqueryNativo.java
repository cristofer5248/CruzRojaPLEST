/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.utils;

import java.util.ArrayList;
import java.util.List;
import sv.com.cruzplest.www.model.PEDmodel;

/**
 *
 * @author cristofer5248
 */
public class pruebasqueryNativo {

    public static void main(String[] arg) {
        imprimir();

    }

//    public static void imprimir() {
//        try {
//
//            System.out.print("Iniciando...");
//            BeneficiadoModel modelo = new BeneficiadoModel();
//            List<Object[]> lista;
//            lista = modelo.obteneractividades("ingresar un id valido de proyecto");
////            System.out.print("... Total de beneficiados = " + lista.size());
//            
//
//            for (Object[] z : modelo.obteneractividadesdatos(lista,"dsad")) {
//                for (int i = 0; i < lista.size()+1; i++) {
//                    System.out.print(z[i] + "\n");
//                }
//                
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); 
//        }
//    }
    public static void imprimir() {
        try {

            System.out.print("Iniciando...");

            PEDmodel modelo = new PEDmodel();
            ArrayList<Integer> list = modelo.forRowSpam2();
            System.out.print(list);
//            int intentos = modelo.verificarIntentos("ADM123");
//            System.out.print("Numero de intentos>>>  "+intentos);

//            List<Object[]> lista;
//            lista = modelo.nativo();
//            System.out.print("... Total de beneficiados = " + lista.size());
//
//            List<String> aber = new ArrayList<String>();
//            aber.add(new String("Edades"));
//            aber.add(new String("Masculino"));
//            aber.add(new String("Femenino"));
//            
//            for(Object[] a :  lista){
//                
//                System.out.print(a[0]);
//        }
//                            for (Object[] z : modelo.obteneractividadesdatos(lista,"dsad")) {
//                for (int i = 0; i < lista.size()+1; i++) {
//                    System.out.print(z[i] + "\n");
//                }
//                
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
