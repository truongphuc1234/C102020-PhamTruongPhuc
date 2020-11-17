let productArray = [];

let productInput = document.getElementById("product-input");
let addButton = document.getElementById("add");
let bodyTable = document.getElementById("body-table");

addButton.addEventListener("click", addProduct);


function addProduct() {
    if (productInput.value) {
        productArray.push(productInput.value);
    }
    generateTable(productArray);
    productInput.value = "";
}

function editProduct() {
    let id = this.id.split("-")[1];
    document.getElementById(`edit-${id}`).removeEventListener("click",editProduct);
    document.getElementById(`edit-${id}`).innerText = "Confirm";
    document.getElementById(`displayName-${id}`).contentEditable = "true";
    document.getElementById(`edit-${id}`).addEventListener("click",confirmEdit);
}
function confirmEdit() {
    let id = this.id.split("-")[1];
    document.getElementById(`edit-${id}`).removeEventListener("click",confirmEdit);
    document.getElementById(`edit-${id}`).innerText = "Edit";
    document.getElementById(`displayName-${id}`).contentEditable = "false";
    document.getElementById(`edit-${id}`).addEventListener("click",editProduct);
    productArray[id] = document.getElementById(`displayName-${id}`).innerText;
}
function removeProduct() {
    let id = this.id.split("-")[1];
    productArray.splice(id,1);
    generateTable(productArray);
}

function generateTable(arr) {
    while (bodyTable.hasChildNodes()) {
        bodyTable.removeChild(bodyTable.lastChild)
    }

    for (let i = 0; i < arr.length; i++) {
        let row = bodyTable.insertRow();
        row.id = `row-${i}`;

        //product name
        let td_1 = document.createElement("td");
        td_1.innerText = arr[i];
        td_1.id = `displayName-${i}`;
        row.appendChild(td_1);

        //button edit

        let td_2 = document.createElement("td");
        let button_edit = document.createElement("button")
        button_edit.innerText = "Edit";
        button_edit.id = `edit-${i}`;
        button_edit.addEventListener("click",editProduct);
        row.appendChild(td_2);
        td_2.appendChild(button_edit);

        //button remove

        let td_3 = document.createElement("td");
        let button_remove = document.createElement("button")
        button_remove.innerText = "Remove";
        button_remove.id = `remove-${i}`;
        button_remove.addEventListener("click",removeProduct);
        row.appendChild(td_3);
        td_3.appendChild(button_remove);

    }
    document.getElementById('count').innerText = arr.length + ((arr.length >1)? " Products": " Product");
}
