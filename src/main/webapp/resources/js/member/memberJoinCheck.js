/**
 * 
 */
 
 // let, const
 // 함수선언
 //function 함수명(매개변수 선언) {

 //   return
 //}
 
 const btn = document.getElementById("btn");
 const join_info = document.getElementsByClassName("join_info");
 const frm = document.getElementById("frm");
 const member_id = document.getElementById("member_id");
 const password = document.getElementById("member_pwd");
 const passwordCheck = document.getElementById("member_pwd_check");
 const passwordError = document.getElementById("password-error");
 const passwordCheckError = document.getElementById("password-eqError");



 password.addEventListener("blur", function() {
    if(password.value == "") {
        passwordError.innerHTML="Password는 필수입니다";
        return;
    }else {
    	passwordError.innerHTML="";
    }
 	if(password.value.length<6) {
        passwordError.innerHTML="Password는 6글자 이상이어야 합니다";
        return;
    }
 })


 passwordCheck.addEventListener("blur", function() {	    
    if(passwordCheck.value != member_pwd.value) {
        passwordCheckError.innerHTML="Password가 일치하지 않습니다";
        passwordCheck.value="";
        return;
    }else{
    	passwordCheckError.innerHTML="Password 일치";
    }
 })
 
 password.addEventListener("change", function() {
    if(passwordCheck.value != member_pwd.value) {
        passwordCheckError.innerHTML="Password가 일치하지 않습니다";
        passwordCheck.value="";
        return;
    }else{
    	passwordCheckError.innerHTML="Password 일치";
    }
 })

 


 btn.addEventListener("click", function() {
    if(member_id.value == "") {
        alert("ID는 필수입니다");
        member_id.focus();
        return;
    }

    if(member_pwd.value == "") {
        passwordError.innerHTML="Password는 필수입니다";
        member_pwd.focus();
        return;
    }else {
    	passwordError.innerHTML="";
    }

    if(member_pwd.value.length<6) {
        passwordError.innerHTML="Password는 6글자 이상이어야 합니다";
        member_pwd.focus();
        return;
    }
    
    if(member_pwd_check.value != member_pwd.value) {
        passwordCheckError.innerHTML="Password가 일치하지 않습니다";
        member_pwd_check.value="";
        member_pwd_check.focus();
        return;
    }else{
    	passwordCheckError.innerHTML="";
    }

 })


