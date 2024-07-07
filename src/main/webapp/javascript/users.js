const checkEmail = document.getElementById("check-email");
const joinForm = document.getElementById("join-form").getElementsByTagName("form")[0];


const checkEmailClickEvent = (evt) => {
    const obj =  evt.target;
    const target = obj.dataset.target;

    const email = joinForm.email.value.trim();

    if (email.length === 0) {
        alert("이메일을 입력하세요.");
        joinForm.emailCheck.value = "none";
        return;
    }

    fetch(`${target}?email=${email}`)
        .then(response => { 
            console.log(response);
            return response.json();
        })
        .then(json => {
            console.log(json);
            if (json.exist) {
                alert("사용중인 이메일입니다.");
                joinForm.emailCheck.value = "false";
                throw new Error("중복 이메일");
            } else {
                alert("사용 가능합니다.");
                joinForm.emailCheck.value = "true";
            }
        })
};

const checkFormSubmitEvent = (evt) => {
    evt.preventDefault();
    if (joinForm.name.value.trim().length === 0) {
        alert("이름을 입력하세요.");
        joinForm.name.focus();
    } else if (joinForm.password.value.trim().length === 0) {
        alert("암호를 입력하세요.");
        joinForm.password.focus();
    } else if (joinForm.email.value.trim().length === 0) {
        alert("이메일을 입력하세요.");
        joinForm.email.focus();
    } else if (joinForm.emailCheck.value !== "true") {
        alert("이메일 중복체크를 해주세요.")
        joinForm.check-email.focus();
    } else if (joinForm.agree.checked === false) {
        alert("약관을 동의하세요.");
        joinForm.agree.focus();
    } else {
        joinForm.submit();
    }
};

window.addEventListener("load", () => {
    checkEmail.addEventListener("click", checkEmailClickEvent);
    joinForm.addEventListener("submit", checkFormSubmitEvent);
});
