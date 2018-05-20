/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arem.facturacion.procesador;

import edu.eci.arem.facturacion.Parser.Parser;

/**
 * @author Juan Camilo Mantilla
 */
public class ProcesadorInit {
    public static void main(String[] args) {
        FacturaExtractor extractor = new FacturaExtractor();
        Parser parser = new Parser();
        extractor.run();
        parser.run();
    }
}
