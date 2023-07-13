package ufro.examen.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufro.examen.model.Producto;
import ufro.examen.service.CsvReaderService;
import ufro.examen.service.FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoProductoController {
    private final CsvReaderService csvReaderService;
    private final FileService fileService;

    public MovimientoProductoController(CsvReaderService csvReaderService, FileService fileService) {
        this.csvReaderService = csvReaderService;
        this.fileService = fileService;
    }

    @PostMapping("/cambiarPrecio")
    public String cambirPrecio(@RequestBody String requestBody)throws IOException {
        String[] params = requestBody.split(",");
        if (params.length ==2){
            String precio = params[0].trim();
            String nombre = params[1].trim();
            List<Producto> productos =csvReaderService.readCsv();
            List<String> matchingProductos = new ArrayList<>();

            for (Producto product:productos){
                if (product.getNombre().equalsIgnoreCase(nombre)){
                    matchingProductos.add(product.toString());
                }
            }
            if (!matchingProductos.isEmpty()){
                StringBuilder contentBuilder = new StringBuilder();
                contentBuilder.append("***** Información de la producto ****\n");
                contentBuilder.append("ajustar saldo de producto :\n");
                contentBuilder.append(nombre+"   ").append(precio).append("\n");
               String content = contentBuilder.toString();
                try {
                    fileService.generateTextFile("nuevoPrecio.txt", content);
                    return "Archivo de texto generado correctamente.";
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Error al generar el archivo de texto.";
                }
            } else {
                return "el producto no se encuentra";
            }
        }

        return "Formato de parámetros incorrecto";
    }
    @PostMapping("/creaMerma")
    public String crearMerma(@RequestBody String requestBody) throws IOException {
        String[] params = requestBody.split(",");
        if (params.length ==1){
            String fechaVencim = params[0].trim();
            List<Producto> productos =csvReaderService.readCsv();
            List<String> matchingProductos = new ArrayList<>();

            for (Producto product:productos){
                if (product.getFechaVencimiento().equalsIgnoreCase(fechaVencim)){
                    matchingProductos.add(product.toString());
                }
            }
            if (!matchingProductos.isEmpty()){
                StringBuilder contentBuilder = new StringBuilder();
                contentBuilder.append("***** Información de la merma ****\n");
                contentBuilder.append("por fecha de vencimiento :\n");
                for (String producto : matchingProductos) {
                    contentBuilder.append(producto).append("\n");

                } String content = contentBuilder.toString();
                    try {
                        fileService.generateTextFile("merma.txt", content);
                        return "Archivo de texto generado correctamente.";
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "Error al generar el archivo de texto.";
                    }
                } else {
                    return "no se encuantra resultados";
                }
            }

            return "Formato de parámetros incorrecto";
        }
}


