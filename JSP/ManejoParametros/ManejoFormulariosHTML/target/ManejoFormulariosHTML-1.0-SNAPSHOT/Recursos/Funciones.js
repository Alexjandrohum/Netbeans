function validarForma(forma){
    var usuario = forma.usuario;
    if(usuario === "" || usuario.value === "Ingresa el usuario"){
        usuario.focus();
        usuario.select();
        return false;
    }
    
    var password = forma.password;
    if(password === "" || password.value === "Ingresa la contraseña"){
        password.focus();
        password.select();
        return false;
    }
    
    var tecnologias = forma.tecnologia;
    var checkSelected = false;
    
    for(var i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){
            checkSelected = true;
        }
    }
    if(!checkSelected){
        alert("Debe de seleccionar una tecnología");
        return false;
    }
    
    var genero = forma.genero;
    var radioSelected = false;
    
    for(var i = 0; i < genero.length; i++){
        if(genero[i].checked){
            radioSelected = true;
        }
    }
    
    if(!radioSelected){
        alert("Debe de seleccionar un género");
        return false;
    }
    
    var ocupacion = forma.ocupacion;
    if(ocupacion.value === ""){
        alert("Debe de seleccionar una ocupacion");
        return false;
    }
    
    alert("Datos registrados exitosamente.");
    return true;
    
}