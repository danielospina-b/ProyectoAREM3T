package edu.eci.arem.facturacion.webapi.model;

/**
 *
 * @author daniel
 */
public class Factura {
    
    private Integer idFactura; // Numeracion consecutiva DIAN
    private String fecha; // "DD-MM-AA-MM-HH"
    private String nombre; // O Razon social
    private String nitFacturador;
    private String nitAdquiriente;
    private String descripcionMercancia;
    private Integer unidades;
    private Integer impuestos;
    private Integer valorUnitario;
    private Integer valorTotal;

    public Factura(Integer idFactura, String fecha, String nombre, String nitFacturador, String nitAdquiriente, String descripcionMercancia, Integer unidades, Integer impuestos, Integer valorUnitario, Integer valorTotal) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.nombre = nombre;
        this.nitFacturador = nitFacturador;
        this.nitAdquiriente = nitAdquiriente;
        this.descripcionMercancia = descripcionMercancia;
        this.unidades = unidades;
        this.impuestos = impuestos;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public Factura() {
        
    }
    
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNitFacturador() {
        return nitFacturador;
    }

    public void setNitFacturador(String nitFacturador) {
        this.nitFacturador = nitFacturador;
    }

    public String getNitAdquiriente() {
        return nitAdquiriente;
    }

    public void setNitAdquiriente(String nitAdquiriente) {
        this.nitAdquiriente = nitAdquiriente;
    }

    public String getDescripcionMercancia() {
        return descripcionMercancia;
    }

    public void setDescripcionMercancia(String descripcionMercancia) {
        this.descripcionMercancia = descripcionMercancia;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Integer impuestos) {
        this.impuestos = impuestos;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
    
}
