package edu.eci.arem.facturacion.procesador;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcesadorInit {
    public static void main(String[] args) {
        FacturaExtractor extractor = new FacturaExtractor();
        System.out.println("Procesador de facturas está activo");
        extractor.start();
    }
}