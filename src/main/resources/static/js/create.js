export function createUser() {
    const createButton = document.querySelector(".add-user");
    createButton.addEventListener("click", e => {
        document.querySelector(".create-user-form").style.transform = "translate(0, -50%)";
        createButton.style.transform = "translate(-250%, 0)";
    })
}