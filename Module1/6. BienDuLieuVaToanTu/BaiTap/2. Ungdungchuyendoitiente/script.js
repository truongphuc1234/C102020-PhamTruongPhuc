document.getElementById("convert").addEventListener("click",converter);

function converter() {

    let amount = document.getElementById('amount').value;
    let fromIndex = document.getElementById('fromCurrency').value;
    let toIndex = document.getElementById('toCurrency').value;

    let fromNumber, toNumber;

    switch (fromIndex) {
        case 'VND':
            fromNumber = 0.000043;
            break;
        case 'USD':
            fromNumber = 1;
            break;
        case 'GPB':
            fromNumber = 1.30;
            break;
        case 'EUR':
            fromNumber =1.17;
            break;
    }
    switch (toIndex) {
        case 'VND':
            toNumber = 0.000043;
            break;
        case 'USD':
            toNumber = 1;
            break;
        case 'GPB':
            toNumber = 1.30;
            break;
        case 'EUR':
            toNumber = 1.17;
            break;
    }
    let result = amount * fromNumber / toNumber;
    document.getElementById('result').innerText = 'Result: '+ result +' '+ toIndex;
}
