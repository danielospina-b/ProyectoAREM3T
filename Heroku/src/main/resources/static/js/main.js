/* global axios */

var coded = "";

var MainModule = (function () {
    
    var testLogin = function () {
        var user = document.getElementById("inputUser").value;
        var password = document.getElementById("inputPassword").value;
        var code = user + ":" + password;
        var encoded = btoa(code);
        var config = {
            headers: {'authorization': "Basic " + encoded}
        };
        axios.get("/api/login", config)
        .then(function (response) {
            coded = encoded;
            console.log(response.data);
            window.location.href = "/api/formpage.html";
        }).catch (function (error) {
            alert("Credenciales Erroneas");
        });
    };
    
    var reportarFactura = function () {
        var idFactura = document.getElementById("idFactura").value;
        var fecha = document.getElementById("fecha").value;
        var nombre = document.getElementById("nombre").value;
        var nitFacturador = document.getElementById("nitFacturador").value;
        var nitAdquiriente = document.getElementById("nitAdquiriente").value;
        var descripcionMercancia = document.getElementById("descripcionMercancia").value;
        var unidades = document.getElementById("unidades").value;
        var impuestos = document.getElementById("impuestos").value;
        var valorUnitario = document.getElementById("valorUnitario").value;
        var valorTotal = document.getElementById("valorTotal").value;
        var factura = {idFactura:idFactura, fecha:fecha, nombre:nombre, nitFacturador:nitFacturador, nitAdquiriente:nitAdquiriente,
                        descripcionMercancia:descripcionMercancia, unidades:unidades, impuestos:impuestos, valorUnitario:valorUnitario, valorTotal: valorTotal};
        
        axios.post("/api/factura/nueva", factura)
        .then(function (response) {
            alert("Factura Enviada Correctamente");
            location.reload();
        }).catch (function (error) {
            alert("Error al enviar la Factura");
        });
        
    };
    
    return {
        testLogin: testLogin,
        reportarFactura: reportarFactura
    };
    
}());
