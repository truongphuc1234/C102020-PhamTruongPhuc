// Bài 1

function convertTeperature() {
    let celcius = parseFloat(document.getElementById("celcius").value);
    let result = celcius * 9 / 5 + 32;
    document.getElementById("result_1").innerText = "Fahreinheit :" + result;
}

document.getElementById("check_1").addEventListener('click', convertTeperature);

// Bài 2

function convertMeter() {
    let meter = parseFloat(document.getElementById("meter").value);
    let result = meter * 3.2808;
    document.getElementById("result_2").innerText = "Số Feet là :" + result;
}

document.getElementById("check_2").addEventListener('click', convertMeter);

// Bài 3

function square() {
    let side = parseFloat(document.getElementById("side_square").value);
    let result = side * side;
    document.getElementById("result_3").innerText = "Diện tích hình vuông là : " + result;
}

document.getElementById("check_3").addEventListener('click', square);

// Bài 4

function rectangle() {
    let side_a = parseFloat(document.getElementById("side_a").value);
    let side_b = parseFloat(document.getElementById("side_b").value);
    let result = side_a * side_b;
    document.getElementById("result_4").innerText = "Diện tích chữ nhật là : " + result;
}

document.getElementById("check_4").addEventListener('click', rectangle);


// Bài 5

function triangle() {
    let side_a = parseFloat(document.getElementById("side_triangle_a").value);
    let side_b = parseFloat(document.getElementById("side_triangle_b").value);
    let result = side_a * side_b / 2;
    document.getElementById("result_5").innerText = "Diện tích tam giác vuông là : " + result;
}

document.getElementById("check_5").addEventListener('click', triangle);

// Bài 6

function equation_1() {
    let a = parseFloat(document.getElementById("a_6").value);
    let b = parseFloat(document.getElementById("b_6").value);
    let result;
    if (a == 0) {
        if (b == 0) {
            result = " Phương trình có vô số nghiệm";
        } else {
            result = "Phương trình vô nghiệm";
        }
    } else {
        let solution = (-1) * b / a;
        result = "Phương trình có nghiệm là x = " + solution;
    }
    document.getElementById("result_6").innerText = result;
}

document.getElementById("check_6").addEventListener('click', equation_1);


// Bài 7

function equation_2() {
    let a = parseFloat(document.getElementById("a_7").value);
    let b = parseFloat(document.getElementById("b_7").value);
    let c = parseFloat(document.getElementById("c_7").value);
    let result, solution, solution_2;
    if (a == 0) {
        if (b == 0) {
            if (c == 0) {
                result = " Phương trình có vô số nghiệm";
            } else {
                result = "Phương trình vô nghiệm";
            }
        } else {
            solution = (-1) * c / b;
            result = "Phương trình có nghiệm là x = " + solution;
        }
    } else {
        let lambda = b * b - 4 * a * c;

        if (lambda < 0) {
            result = "Phương trình vô nghiệm";
        } else if (lambda == 0) {
            solution = (-1) * b / (2 * a);
            result = "Phương trình có nghiệm kép x1 = x2  = " + solution;
        } else {
            solution = (-b + Math.pow(lambda, 0.5)) / (2 * a);
            solution_2 = (-b - Math.pow(lambda, 0.5)) / (2 * a);
            result = "Phương trình có 2 nghiệm x1 = " + solution + " ; x2 = " + solution_2;
        }
    }
    document.getElementById("result_7").innerText = result;
}

document.getElementById("check_7").addEventListener('click', equation_2);

// Bài 8
function checkAge() {
    let age = parseFloat(document.getElementById("age").value);
    let result;
    if (age - Math.floor(age) != 0) {
        result = "Đây không phải tuổi 1 người";
    } else if (age <= 120 && age >= 0) {
        result = "Đây là tuổi của 1 người"
    } else {
        result = "Dây không phải tuổi 1 người"
    }
    document.getElementById("result_8").innerText = result;
}
document.getElementById("check_8").addEventListener('click', checkAge);


//Bài 9
function checkTriangle() {
    let a = parseFloat(document.getElementById("a_9").value);
    let b = parseFloat(document.getElementById("b_9").value);
    let c = parseFloat(document.getElementById("c_9").value);
    let result;
    if (a > 0 && b > 0 && c > 0 && (a + b) > c && (b + c) > a && (a + c) > b) {
        result = "Đây là 3 cạnh của tam giác";
    } else
        result = " Đây không phải cạnh của tam giác";

    document.getElementById("result_9").innerText = result;
}

document.getElementById("check_9").addEventListener('click', checkTriangle);

// Bài 10
function electric() {
    let amount = parseFloat(document.getElementById("kWh").value);
    let level = [0,0,0,0,0,0];
    let rate =[1678,1734,2014,2536,2834,2927];
    let threshold = [50, 50, 100, 100, 100, 10000000];
    let money =[];
    for (let i = 0; i <6; i++) {
        level[i] = (amount >= threshold[i])? threshold[i]: amount;
        amount -= level[i];
        money[i] = level[i] * rate[i];
        document.getElementById("level_"+(i+1)).innerText = level[i];
        document.getElementById("amount_"+(i+1)).innerText = money[i];
    }
    document.getElementById("total_amount").innerText = money[0]+money[1]+money[2]+money[3]+money[4]+money[5];
}

document.getElementById("check_10").addEventListener('click', electric);

// Bài 11

function taxIncome() {
    let income = parseFloat(document.getElementById("income").value);
    let rate;
    if (income > 80000000)
        rate = 0.35;
    else if (income >= 52000000)
        rate = 0.3;
    else if (income >= 32000000)
        rate = 0.25;
    else if (income >= 18000000)
        rate = 0.2;
    else if (income >= 10000000)
        rate = 0.15;
    else if (income >= 5000000)
        rate = 0.1;
    else
        rate = 0.05;
    let result  = income * rate;

    document.getElementById("result_11").innerText = "Thuế thu nhập cá nhân phải nộp là :" + result;
}

document.getElementById("check_11").addEventListener('click', taxIncome);

// Bài 12


function interest() {
    let initial = parseFloat(document.getElementById("initial").value);
    let month = parseFloat(document.getElementById("month").value);
    let interest_rate = parseFloat(document.getElementById("interest_rate").value);
    let total = initial;
    for (let i = 1; i <= month; i++) total += interest_rate * total;
    document.getElementById("result_12").innerText = "Tổng số lãi phải trả là :" + total;

}

document.getElementById("check_12").addEventListener('click', interest);

