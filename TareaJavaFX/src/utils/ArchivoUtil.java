package utils;

import model.Paquete;
import model.Destino;
import java.io.*;
import java.util.*;

public class ArchivoUtil {
    public static boolean guardarPaquete(Paquete paquete) {
        try{
            FileWriter fw = new FileWriter("Paquetes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(paquete.getCodigo() + " - " + paquete.getDestinatario() + " - " + paquete.getPeso() + " - " + paquete.getDestino());
            bw.newLine();
            bw.close();
            fw.close();
            return true;

        } catch (IOException e) {
            System.out.println("Error al guardar el paquete: " + e.getMessage());
            return false;
        }
    }

    public static boolean guardarDestino(String destino) {
        try{
            FileWriter fw = new FileWriter("Destinos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(destino);
            bw.newLine();
            bw.close();
            fw.close();
            return true;

        } catch (IOException e) {
            System.out.println("Error al guardar el destino: " + e.getMessage());
            return false;
        }
    }

    public static ArrayList<Paquete> LeerListaPaquetes() {
        ArrayList<Paquete> listaPaquetes = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Paquetes.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" - ");
                
                if (datos.length == 4) {
                    Paquete paquete = new Paquete(
                        datos[0], 
                        datos[1], 
                        Integer.parseInt(datos[2]), 
                        datos[3]);
                    listaPaquetes.add(paquete);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer la lista de paquetes: " + e.getMessage());
        }
        return listaPaquetes;
    }

    public static ArrayList<Destino> LeerListaDestinos() {
        ArrayList<Destino> listaDestinos = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Destinos.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                Destino destino = new Destino(linea);
                listaDestinos.add(destino);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer la lista de destinos: " + e.getMessage());
        }
        return listaDestinos;
    }
}
