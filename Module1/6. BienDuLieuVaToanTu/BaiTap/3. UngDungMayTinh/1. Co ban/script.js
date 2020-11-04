
function addition() {
    let a =parseFloat(document.getElementById('a').value);
    let b =parseFloat(document.getElementById('b').value);
    let result = a + b;
    document.getElementById('result').innerText = 'Result Addition : ' +result;
}
document.getElementById('addition').addEventListener('click',addition)

function subtraction() {
    let a =parseFloat(document.getElementById('a').value);
    let b =parseFloat(document.getElementById('b').value);
    let result = a - b;
    document.getElementById('result').innerText = 'Result Subtraction : ' +result;
}
document.getElementById('subtraction').addEventListener('click',subtraction)

function multiplication() {
    let a =parseFloat(document.getElementById('a').value);
    let b =parseFloat(document.getElementById('b').value);
    let result = a * b;
    document.getElementById('result').innerText = 'Result Multiplication : ' +result;
}
document.getElementById('multiplication').addEventListener('click',multiplication)

function division() {
    let a =parseFloat(document.getElementById('a').value);
    let b =parseFloat(document.getElementById('b').value);
    let result = a / b;
    document.getElementById('result').innerText = 'Result Division : ' +result;
}
document.getElementById('division').addEventListener('click',division)