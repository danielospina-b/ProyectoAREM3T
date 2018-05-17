package edu.eci.arem.facturacion.webapi.services;

import edu.eci.arem.facturacion.webapi.model.Factura;
import java.util.Queue;

/**
 *
 * @author daniel
 */
public interface FacturacionServices {
    
    Queue getNuevasFacturas() throws FacturacionServicesException;
    
    void addNuevaFactura(Factura factura) throws FacturacionServicesException;
    
    Factura getAndDeleteFactura(Integer idFactura) throws FacturacionServicesException;
    
}
