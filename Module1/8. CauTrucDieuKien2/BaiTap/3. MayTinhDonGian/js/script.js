let input =  document.getElementById("input");

document.querySelectorAll(".inputButton").forEach(item =>{
    item.addEventListener("click", event =>{
        clickEvent(item.value);
    });
});
function clickEvent(inputValue) {
    input.value = input.value + inputValue;
}


document.getElementById("reset").addEventListener("click",reset);
function reset() {
    input.value = "";
}

document.getElementById("calc").addEventListener("click",calculate);
function calculate () {
    input.value = eval(input.value);
}

