let input = document.getElementById('input');

document.getElementById('0').addEventListener('click',addNumber);

function addNumber() {
    let input = document.getElementById('input').value;
    let result = input + '0';
    document.getElementById('input').value= result;
}