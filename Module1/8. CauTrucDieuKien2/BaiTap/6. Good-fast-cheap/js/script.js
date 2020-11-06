let button_1= document.getElementById("checkbox_1");
let button_2= document.getElementById("checkbox_2");
let button_3= document.getElementById("checkbox_3");

document.querySelectorAll(".check-box").forEach(item =>{
    item.addEventListener("change", evt => {
        checkActive(item.id);
    });
});

function checkActive(itemId) {
    if ((button_1.checked == true)&&(button_2.checked == true)&&(button_3.checked == true)) {
        if(itemId == "checkbox_1"){
            button_3.checked = false;
        } else if(itemId == "checkbox_2"){
            button_1.checked = false;
        } else {
            button_2.checked = false;
        }
    }
}