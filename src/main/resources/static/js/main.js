import {updateUserData} from "./update.js";
import {showUserToDelete, deleteUser} from "./delete.js";
import {createUser} from "./create.js";

const itemsContainer = document.querySelector(".users-list");

itemsContainer.addEventListener("mouseover", e => {
    showUserToDelete(e);
})
itemsContainer.addEventListener("mouseout", e => {
    showUserToDelete(e);
})
itemsContainer.addEventListener("click", e => {
    updateUserData(e);
    deleteUser(e);
})

createUser();


