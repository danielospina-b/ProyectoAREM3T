package edu.eci.arem.facturacion.webapi.services;

import edu.eci.arem.facturacion.webapi.model.Factura;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class FacturacionServicesStub implements FacturacionServices {
    
    private ConcurrentHashMap<Integer, Factura> facturas;
    private ConcurrentLinkedQueue<Integer> nuevasFacturas;
    
    public FacturacionServicesStub() {
        facturas = new ConcurrentHashMap<>();
        nuevasFacturas = new ConcurrentLinkedQueue<>();
        addFacturasBase();
    }

    @Override
    public Queue getNuevasFacturas() throws FacturacionServicesException {
        return nuevasFacturas;
    }

    @Override
    public void addNuevaFactura(Factura factura) throws FacturacionServicesException {
        if (!facturas.containsKey(factura.getIdFactura())){
            facturas.put(factura.getIdFactura(), factura);
            nuevasFacturas.add(factura.getIdFactura());
        } else {
            throw new FacturacionServicesException("ID de Factura ya existe.");
        }
    }

    @Override
    public Factura getAndDeleteFactura(Integer idFactura) throws FacturacionServicesException {
        Factura factura;
        if (facturas.containsKey(idFactura)) {
            factura = facturas.remove(idFactura);
            nuevasFacturas.remove(idFactura);
            return factura;
        } else {
            throw new FacturacionServicesException("Factura ID: " + idFactura + " no Existe");
        }
    }

    private void addFacturasBase() {
        facturas.put(1, new Factura(1, "05-05-18-18-00", "Danilo Jimenez", "123357421576", "10568413541", "Celulares Marca LG", 5, 200000, 500000, 2700000));
        facturas.put(2, new Factura(2, "06-03-18-12-30", "Camila Ramirez", "984516843546", "32485496519", "Hierro 95% Puro ..", 9, 445000, 400000, 2982000));
        facturas.put(3, new Factura(3, "12-11-17-15-10", "Juana Villalbe", "897413246674", "87413574654", "ServicioReparacion", 1, 900000, 100000, 1000000));
    }
}
