/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arem.facturacion.procesador;

public class ProcesadorInit {
    public static void main(String[] args) {
        FacturaExtractor extractor = new FacturaExtractor();
        extractor.start();
    }
}
