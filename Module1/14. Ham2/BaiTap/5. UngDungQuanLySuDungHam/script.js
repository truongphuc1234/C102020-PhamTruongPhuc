let arrayProduct = [];
let tableProduct = document.getElementById("table");
let addButton = document.getElementById("add");
let inputProduct = document.getElementById("product-input");
let count = document.getElementById("count");

addButton.addEventListener("click", addProduct);

function addProduct() {
    if (inputProduct.value) {
        arrayProduct.push();
        tableProduct.innerHTML += `<tr class="row" id="row-${arrayProduct.length}">
                                       <td id="text-${arrayProduct.length}">${inputProduct.value}</td>
                                       <td><button id="edit-${arrayProduct.length}">Edit</button></td>
                                       <td><button id="remove-${arrayProduct.length}">Remove</button></td>
                                   </tr>`;
    }
    inputProduct.value = "";
    document.getElementById(`edit-${arrayProduct.length}`).addEventListener("click",editProduct);
    document.getElementById(`remove-${arrayProduct.length}`).addEventListener("click",removeProduct);
    updateCount();
}

function editProduct() {
    let id = parseInt(this.id);
    document.getElementById(`text-${id}`).innerHTML = `<input id="input-${id}" type="text"/>`;
    document.getElementById(`edit-${id}`).innerText = "Confirm";
    document.getElementById(`edit-${id}`).addEventListener("click",updateProduct);
}

function removeProduct() {
    updateCount();
}

function updateProduct() {
    let id = parseInt(this.id);

    if(document.getElementById((`input-${id}`).value){
    document.getElementById(`edit-${id}`).innerText = "Edit";
    document.getElementById(this.id).addEventListener("click",editProduct);
        {
}
function updateCount() {

}