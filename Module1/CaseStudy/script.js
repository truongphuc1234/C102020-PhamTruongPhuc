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

let priceService = {
    villa: 500,
    house: 200,
    room: 100,
};

/*check & show info from input in right panel*/
function showInfo() {
    for (let item of document.getElementsByClassName("material-icons")) {
        item.style.display = "none";
    }
    let validation = true;
    let re_email = /^[A-Za-z0-9_]+@[A-Za-z0-9_]+\.[A-Za-z0-9_]+$/;
    if (re_email.test(email.value) === false) {
        validation = false;
        document.getElementById("alert_email").style.display = "inline";
    }
    let re_identity = /^[0-9]{8}$/;
    if (re_identity.test(identity.value) === false) {
        validation = false;
        document.getElementById("alert_identity").style.display = "inline";
    }
    let re_birthday = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/;
    if (re_birthday.test(birthday.value) === false) {
        validation = false;
        document.getElementById("alert_birthday").style.display = "inline";
    }
    if (parseInt(quantity.value) < 0) {
        validation = false;
        document.getElementById("alert_quantity").style.display = "inline";
    }
    if (parseInt(rentDay.value) < 1) {
        validation = false;
        document.getElementById("alert_rentDay").style.display = "inline";
    }

    let nameArr = name.value.split(/\s+/);
    for (let i = 0; i < nameArr.length; i++) {
        nameArr[i] = nameArr[i][0].toUpperCase() + nameArr[i].substr(1);
    }
    name.value = nameArr.join(" ");

    if (validation) {
        showName.innerText = name.value;
        showIdentity.innerText = identity.value;
        showBirthday.innerText = birthday.value;
        showEmail.innerText = email.value;
        showAddress.innerText = address.value;
        showCustomer.innerText = customer.value;
        showQuantity.innerText = quantity.value;
        showRentDay.innerText = rentDay.value;
        showService.innerText = service.value;
        showRoomType.innerText = roomType.value;
        document.getElementById("div-input").style.display = "none";
        document.getElementsByClassName("show-info-block")[0].style.display = "block"

        document.getElementById("showDiscount").innerText = "$ " ;
        document.getElementById("amount").innerText = "$ " ;
    }
}

/* get the demo info*/
function demoInfo() {
    name.value = "Phạm Trường Phúc";
    identity.value = "01234567";
    birthday.value = "08/12/1992";
    email.value = "truongphucdn@gmail.com";
    address.value = "Đà Nẵng";
    customer.value = "diamond";
    discount.disabled = true;
    quantity.value = 4;
    rentDay.value = 5;
    service.value = "villa";
    roomType.value = "business";
}

function calculate() {
    let price, discountByCity, discountByDays, discountByCustomer;
    switch (service.value) {
        case "villa":
            price = 500;
            break;
        case "house":
            price = 200;
            break;
        case "room":
            price = 100;
            break;
    }
    switch (address.value) {
        case "Đà Nẵng":
            discountByCity = 20;
            break;
        case "Huế":
            discountByCity = 10;
            break;
        case "Quảng Nam":
            discountByCity = 5;
            break;
        default:
            discountByCity = 0;
            break;
    }
    if (rentDay.value >= 7)
        discountByDays = 30;
    else if (rentDay.value >= 5)
        discountByDays = 20;
    else if (rentDay.value >= 2)
        discountByDays = 10;
    else
        discountByDays = 0;

    switch (customer.value) {
        case "diamond":
            discountByCustomer = 15;
            break;
        case "platinum":
            discountByCustomer = 10;
            break;
        case "gold":
            discountByCustomer = 5;
            break;
        case "silver":
            discountByCustomer = 2;
            break;
        default:
            discountByCustomer = 0;
            break;
    }
    let discount = (discountByCity + discountByDays + discountByCustomer);
    let paid = price * rentDay.value - discount;
    document.getElementById("showDiscount").innerText = "$ " + discount;
    document.getElementById("amount").innerText = "$ " + paid;
    document.getElementById("calculate").style.display = "block";

}

function modify() {
    document.getElementById("div-input").style.display = "block";
    document.getElementsByClassName("show-info-block")[0].style.display = "none";
}

/* add event click in checking */
document.getElementById("checkBtn").addEventListener('click', showInfo);
document.getElementById("demoInfo").addEventListener('click', demoInfo);
document.getElementById("calculation").addEventListener('click', calculate);
document.getElementById("modifyInfo").addEventListener('click', modify);
