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
@RequestMapping("/trasabilidad")
public class TrazabilidadController {
    private final CsvReaderService csvReaderService;
    private final FileService fileService;

    public TrazabilidadController(CsvReaderService csvReaderService, FileService fileService) {
        this.csvReaderService = csvReaderService;
        this.fileService = fileService;
    }
    @PostMapping("/ver")
    public String verTrasabilidad()throws IOException {
        List<Producto> producto = csvReaderService.readCsv();
        List<String> matchingProducto = new ArrayList<>();


        StringBuilder contentBuilder = new StringBuilder();

        for (Producto productos : producto) {
            matchingProducto.add(productos.toString());
        }


      contentBuilder.append("Información de trasabilidad:\n");
        for (String productos : matchingProducto){
            contentBuilder.append(productos).append("\n");
        }
        try {
            String content = contentBuilder.toString();
            fileService.generateTextFile("trasabilidad.txt", content);
            return "Archivo de texto generado correctamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al generar el archivo de texto.";
        }
}
}
