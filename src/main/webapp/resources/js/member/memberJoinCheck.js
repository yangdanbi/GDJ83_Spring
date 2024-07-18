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
 const member_pwd = document.getElementById("member_pwd");
 const passwordError = document.getElementById("password-error");



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
    }

    if(member_pwd.value.length<6) {
        passwordError.innerHTML="Password는 6글자 이상이어야 합니다";
        member_pwd.focus();
        return;
    }
 })


