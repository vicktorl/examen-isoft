package ufro.examen.model;

import lombok.Getter;
import lombok.Setter;
import ufro.examen.service.CsvReaderService;

@Getter
@Setter
public class Producto {

    String nombre;
    String lote;
    String fechaVencimiento;
    Integer precio;



    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", lote='" + lote + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", precio=" + precio +
                '}';
    }

    public boolean largoTexto(String principioActivo) {
        if(principioActivo.length() >= 20){
            return true;
        }else {
            return false;
        }
    }

    public boolean setSaldo(Integer saldo) {
     return true;
    }
    public boolean existeProducto(String nombre){
        return true;
    }
}
