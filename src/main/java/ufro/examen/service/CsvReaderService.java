package ufro.examen.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ufro.examen.model.Producto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {
    public List<Producto> readCsv() throws IOException{
        List<Producto> productos = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource("producto.csv");

        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        // Saltar la primera línea que contiene los encabezados
        String line = reader.readLine();

        while ((line = reader.readLine()) != null) {
            if (StringUtils.hasText(line)) {
                String[] data = line.split(";");
                if (data.length == 4) {
                    Producto producto = new Producto();
                    producto.setNombre(data[0]);
                    producto.setLote(data[1]);
                    producto.setFechaVencimiento(data[2]);
                    producto.setPrecio(Integer.parseInt(data[3]));

                    productos.add(producto);
                }
            }
        }
        reader.close();

        return productos;
    }
}
