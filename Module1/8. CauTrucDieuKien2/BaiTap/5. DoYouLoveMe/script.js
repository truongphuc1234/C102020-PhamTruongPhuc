document.getElementById("yes").addEventListener("click",clickYes);

function clickYes () {
    alert("Yes, you are right !");
}
document.getElementById('no').addEventListener("mouseover", clickNo);

function clickNo () {
    let x = Math.floor(Math.random() * window.innerWidth);
    let y = Math.floor( Math.random() * window.innerHeight);
    document.getElementById('no').style.left = (+x)+'px';
    document.getElementById('no').style.top = (+y)+'px';
}