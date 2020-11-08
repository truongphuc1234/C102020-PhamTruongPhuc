// Bài 1

document.getElementById("button_1").addEventListener("click",checkDivide);
function checkDivide() {
    let a = document.getElementById("ex1_a");
    let b = document.getElementById("ex1_b");

    let divide = a.value % b.value;
    let result;

    if (divide === 0)
        result = "a chia hết cho b";
    else
        result = "a không chia hết cho b";
    document.getElementById("result_1").innerText = result;
}

//Bài 2

document.getElementById("button_2").addEventListener("click",checkAge);
function checkAge() {
    let age = document.getElementById("ex2_age");
    let result;
    if (age.value >= 16)
        result = "Học sinh đủ tuổi vào lớp 10";
    else
        result = "Học sinh không đủ tuổi vào lớp 10";
    document.getElementById("result_2").innerText = result;
}

//Bài 3

document.getElementById("button_3").addEventListener("click",largeZero);
function largeZero() {
    let num = document.getElementById("ex3_num");
    let result;
    if (num.value > 0){
        result = "Số lớn hơn 0";
    } else if( num.value < 0){
        result = "Số nhỏ hơn 0";
    }  else {
        result = "Số bằng 0";}
    document.getElementById("result_3").innerText = result;
}

//Bài 4

document.getElementById("button_4").addEventListener("click",checkMax);
function checkMax() {
    let a = document.getElementById("ex4_a");
    let b = document.getElementById("ex4_b");
    let c = document.getElementById("ex4_c");
    let result;
    let max = a.value;
    if (max < b.value)
        max = b.value;
    if (max < c.value)
        max = c.value;
    result = "Số lớn nhất là " + max;
    document.getElementById("result_4").innerText = result;
}

// Bài 5

document.getElementById("button_5").addEventListener("click",rating);
function rating() {
    let test = document.getElementById("ex5_test");
    let mid = document.getElementById("ex5_mid");
    let end = document.getElementById("ex5_end");
    let result;
    let avg = (parseFloat(test.value) + parseFloat(mid.value) +parseFloat(end.value))/3;
    if (avg >=8)
        result = "Giỏi";
    else if(avg >= 6.5)
        result = "Khá";
    else if (avg >= 5)
        result = "Trung Bình";
    else
        result ="Yếu";
    document.getElementById("result_5").innerText = "Điểm trung bình là "+ avg +" - Xếp loại: "+result;
}

// bài 6

document.getElementById("button_6").addEventListener("click",commission);
function commission() {
    let amount = parseInt(document.getElementById("ex6_amount").value);

    let result;
    if (amount >= 1000000)
        result = "Hoa hồng là 5%";
    else if(amount >= 500000)
        result = "Hoa hồng là 4%";
    else if (amount >= 100000)
        result = "Hoa hồng là 1%";
    else
        result ="Không có hoa hồng";
    document.getElementById("result_6").innerText = result;
}

// bài 7

document.getElementById("button_7").addEventListener("click",ratePhone);
function ratePhone() {
    let minute = parseFloat(document.getElementById("ex7_minute").value);
    let service = document.getElementById("ex7_service").value;
    let result, rate;
    switch (service) {
        case "A":
            rate = 5000;
            break;
        case "B":
            rate = 7000;
            break;
        case "C":
            rate = 3000;
            break;
    }
    result = rate * minute;
    document.getElementById("result_7").innerText =" giá tiền là "+ result;
}


