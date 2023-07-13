package ufro.examen.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ufro.examen.model.Bodega;
import ufro.examen.model.Producto;

public class TDDTest {
    Producto producto;
    Bodega bodega;

    @BeforeEach
    void setUp(){
        producto = new Producto();
        bodega = new Bodega();
    }
    @Test
    @DisplayName("Test nombre producto")
    public void testLargoMsje(){
    String principioActivo ="salbutamol";
        Assertions.assertTrue(producto.largoTexto(principioActivo));
    }
    @Test
    @DisplayName("ajustar saldo")
    public void testSaldo(){
        Integer saldo =3000;
        Assertions.assertTrue(producto.setSaldo(saldo));
    }
    @Test
    @DisplayName("buscar producto")
    public void testBusquedaProd(){
        String producto ="aspirina";
        Assertions.assertTrue(producto.existeProducto(producto));
    }
    @Test
    @DisplayName("buscar bodega")
    public void testBuscarBodega(){
        String bodega ="insumos";
        Assertions.assertTrue(bodega.buscarBodega(bodega));
    }
}
