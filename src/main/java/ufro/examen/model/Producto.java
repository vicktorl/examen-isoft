package ufro.examen.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Producto {
    String nombre;
    String lote;
    String fechaVencimiento;
    Integer precio;

    public Producto() {
    }

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
        return true;
    }
}
