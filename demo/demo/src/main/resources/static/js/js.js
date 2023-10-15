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
            window.location.href = '/users/myprofile'
    }
    function redirectToMyLibrary() {
        window.location.href = '/users/myprofile/mylibrary'
    }
    function logOut(){
        window.location.href = '/logout'
    }

// var friendBars = document.querySelectorAll(".friend-bar");
// friendBars.forEach(function(friendBar) {
//     friendBar.onclick = function() {
//         var formId = friendBar.getAttribute("data-formid");
//         var userId = friendBar.getAttribute("data-userid");
//         // Set the userId value in the hidden input field of the corresponding form
//         document.getElementById(formId).querySelector("#userIdInput").value = userId;
//
//         // Submit the form
//         document.getElementById(formId).submit();
//     }
// });