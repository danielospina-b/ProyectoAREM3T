package edu.eci.arem.facturacion.webapi.restcontrollers;

import edu.eci.arem.facturacion.webapi.model.Factura;
import edu.eci.arem.facturacion.webapi.services.FacturacionServices;
import edu.eci.arem.facturacion.webapi.services.FacturacionServicesException;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */
@Service
@RestController
@RequestMapping(value = "/api")
public class MainController {
    
    private FacturacionServices facturacionServices;
    
    @Autowired
    public void setFacturacionServices(FacturacionServices ros) {
        this.facturacionServices = ros;
    }
    
    //POST nueva Factura
    @RequestMapping(method = RequestMethod.POST, value = "/factura/nueva", consumes = "application/json")
    public ResponseEntity<?> postNuevaFactura(@RequestBody Factura factura) {
        try {
            facturacionServices.addNuevaFactura(factura);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FacturacionServicesException ex) {
            return new ResponseEntity<>("Error POST nueva Factura\n" + ex.getLocalizedMessage() + "\n", HttpStatus.BAD_REQUEST);
        }
    }
    
    //GET lista de ids de nuevas facturas en el API
    @RequestMapping(method = RequestMethod.GET, value = "/factura/nuevasFacturas", produces = "application/json")
    public ResponseEntity<?> getNuevasFacturas() {
        try {
            Queue<Integer> data = facturacionServices.getNuevasFacturas();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (FacturacionServicesException ex) {
            return new ResponseEntity<>("Error GET nuevas Facturas\n" + ex.getLocalizedMessage() + "\n", HttpStatus.NOT_FOUND);
        }
    }
    
    
    //DELETE get and delete una factura por su id
    @RequestMapping(method = RequestMethod.DELETE, value = "/factura/getAndDelete", produces = "application/json", consumes = "text/plain;charset=UTF-8")
    public ResponseEntity<?> getAndDeleteFactura(@RequestBody String idFactura) {
        try {
            Integer id = Integer.parseInt(idFactura);
            Factura factura = facturacionServices.getAndDeleteFactura(id);
            return new ResponseEntity<>(factura, HttpStatus.OK);
        } catch (FacturacionServicesException ex) {
            return new ResponseEntity<>("Error DELETE get and delete factura\n" + ex.getLocalizedMessage() + "\n", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/factura/{idFactura}", produces = "application/json")
    public ResponseEntity<?> getFacturaPorId(@PathVariable String idFactura) {
        try {
            Integer id = Integer.parseInt(idFactura);
            Factura factura = facturacionServices.getFacturaPorId(id);
            return new ResponseEntity<>(factura, HttpStatus.OK);
        } catch (FacturacionServicesException ex) {
            return new ResponseEntity<>("Error GET Factura por id\n" + ex.getLocalizedMessage() + "\n", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<?> getLogin() {
        return new ResponseEntity<>("Logged In", HttpStatus.OK);
    }
    
}
