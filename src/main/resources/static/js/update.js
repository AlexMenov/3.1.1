import {sendUserDataToServer} from "./sendUserDataToServer.js";
export function updateUserData(e) {
    if (e.target.classList.contains("edit-user")) {
        const parent = e.target.parentElement;
        const editItems = parent.querySelectorAll(".user-data");

        switch (e.target.textContent) {
            case "Edit": {
                e.target.textContent = "Save";
                editItems.forEach(item => {
                    item.classList.add("editable");
                    item.contentEditable = true;
                });
                break;
            }
            case "Save": {
                const data = {
                    id: parent.dataset.userId,
                    photo: parent.querySelector(".user-photo img").dataset.source,
                    achievement: parent.querySelector("input[name='achievement']").value
                };
                console.log(parent.querySelector(".user-photo"));
                editItems.forEach(item => {
                    data[item.dataset.user] = item.textContent;
                    item.classList.remove("editable");
                    item.contentEditable = false;
                })
                sendUserDataToServer("/api/users/update", "post", data).then(data => console.log(data));
                e.target.textContent = "Edit";
                break;
            }
        }
    }
}
