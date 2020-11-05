
/* get DOm from left panel */
let name = document.getElementById("name");
let identity = document.getElementById("identity");
let birthday = document.getElementById("birthday");
let email = document.getElementById("email");
let address = document.getElementById("address");
let customer = document.getElementById("customer");
let discount = document.getElementById("discount");
let quantity = document.getElementById("quantity");
let rentDay = document.getElementById("rentDay");
let service = document.getElementById("service");
let roomType = document.getElementById("roomType");

/* catch DOM in right panel */
let showName = document.getElementById("showName");
let showIdentity = document.getElementById("showIdentity");
let showBirthday = document.getElementById("showBirthday");
let showEmail = document.getElementById("showEmail");
let showAddress = document.getElementById("showAddress");
let showCustomer = document.getElementById("showCustomer");
let showDiscount = document.getElementById("showDiscount");
let showQuantity = document.getElementById("showQuantity");
let showRentDay = document.getElementById("showRentDay");
let showService = document.getElementById("showService");
let showRoomType = document.getElementById("showRoomType");
let amount = document.getElementById("amount");

let priceService = {
    villa: 500,
    house: 200,
    room: 100,
};

/* show info from input in right panel*/
function showInfo() {
    showName.innerText = name.value;
    showIdentity.innerText = identity.value;
    showBirthday.innerText = birthday.value;
    showEmail.innerText = email.value;
    showAddress.innerText = address.value;
    showCustomer.innerText = customer.value;
    showDiscount.innerText = discount.value;
    showQuantity.innerText = quantity.value;
    showRentDay.innerText = rentDay.value;
    showService.innerText = service.value;
    showRoomType.innerText = roomType.value;
/* calculate amount of money from input */
    amount.innerText = priceService[service.value] * parseFloat(rentDay.value) * (1 - parseFloat(discount.value)/100);
}

/* add event click in checking */
document.getElementById("checkBtn").addEventListener('click', showInfo);