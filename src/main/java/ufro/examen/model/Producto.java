package ufro.examen.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Producto {
    String nombre;
    String lote;
    Date fechaVencimiento;

    public Producto() {
    }

    public Producto(String nombre, String lote, Date fechaVencimiento) {
        this.nombre = nombre;
        this.lote = lote;
        this.fechaVencimiento = fechaVencimiento;
    }
}
