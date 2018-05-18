/* global axios */

var MainModule = (function () {
    
    var testLogin = function () {
        var user = document.getElementById("inputUser").value;
        var password = document.getElementById("inputPassword").value;
        var code = user + ":" + password;
        var encoded = btoa(code);
        axios.get("/api/login")
        .then(function (response) {
            console.log(response);
        }).catch(function (error) {
            console.log(error);
        });
    };
    
    return {
        testLogin: testLogin
    };
    
}());

MainModule.test();