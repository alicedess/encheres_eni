let mp = document.getElementById("motDePasse");
let confirme = document.getElementById("confirmer")
let confirmeError = document.getElementById("confirmer-error")
let form = document.getElementById("registration-form")
confirme.addEventListener("keyup", () => {

    if (mp.value != confirme.value) {
        confirmeError.innerText = "Les mots de passe ne correspondent pas"
        console.log("Les mot de passe ne correspondent pas")
    } else {
        confirmeError.innerText = "";
        console.log("ça match")

    }
})

form.addEventListener('submit', (e) => {
    e.preventDefault()
    if (mp.value != confirme.value) {
        alert('Les mots de passe ne correspondent pas')
    } else if (mp.value === "") {
        alert('Veuillez rentrer un mot de passe')
    } else {
        form.submit()
    }
})

function checkPassword(e) {
    alert('ça marche ')
    e.preventDefault();
    // let password1 = form.motDePasse.value;
    // let password2 = form.confirmer.value;
    //
    // console.log(password1)
    // console.log(password2)
    // // If Not same return False.
    // if (password1 != password2) {
    //     alert("\nPassword did not match: Please try again...")
    // }
    // form.submit()

}