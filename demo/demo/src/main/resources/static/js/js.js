const openCreateBookBtn = document.getElementById("openModal");
const closeCreateBookBtn = document.getElementById("closeModal");
const modalex333 = document.getElementById("modal-ex333");
const modalInner = document.getElementById("modal-inner")

openCreateBookBtn.addEventListener("click", () => {modalex333.classList.add("open");});
closeCreateBookBtn.addEventListener("click", () => {modalex333.classList.remove("open");});
    function redirectToHomePage() {
    window.location.href = '/';
}
    function redirectToMyProfile() {
            window.location.href = '/myprofile'
    }
    function logOut(){
        window.location.href = '/logout'
    }
