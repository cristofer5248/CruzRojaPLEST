/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var samepass = function () {
    if (document.getElementById('input_form1:password1').value == document.getElementById('input_form1:confirm_password').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Las contraseñas coinciden';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Las contraseñas no coinciden';
    }
};

