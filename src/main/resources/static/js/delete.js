import {sendUserDataToServer} from "./sendUserDataToServer.js";
export function showUserToDelete (e) {
    if (e.target.classList.contains("delete")) {
        const parent = e.target.parentElement;
        const photo= parent.querySelector(".user-photo");
        photo.classList.toggle("delete-user");
    }
}

export function deleteUser (e) {
    if (e.target.classList.contains("delete")) {
        const parent = e.target.parentElement;
        const id = parent.dataset.userId;
        sendUserDataToServer("/api/users/delete/" + id, "delete").then(id => console.log(id));
        parent.remove();
    }
}