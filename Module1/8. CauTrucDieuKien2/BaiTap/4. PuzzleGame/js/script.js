const imageArray = ['funny-cat1_part1x1',
    'funny-cat1_part2x1',
    'funny-cat1_part3x1',
    'funny-cat1_part4x1',
    'funny-cat1_part5x1',
    'monkey_part1x1',
    'monkey_part2x1',
    'monkey_part3x1',
    'monkey_part4x1',
    'monkey_part5x1',
    'panda_swap_part1x1',
    'panda_swap_part2x1',
    'panda_swap_part3x1',
    'panda_swap_part4x1',
    'panda_swap_part5x1'];
let position = [0, 0, 0, 0, 0];

let img = document.querySelectorAll(".puzzle");

function randomImage() {
    let i
    for (i = 0; i < 5; i++) {
        let random = 5 * Math.floor(Math.random() * 3) + i;
        img[i].setAttribute("src", "images/" + imageArray[random] + ".jpg");
        position[i] = random;
    }
}

window.addEventListener("load", randomImage, false);

function changeImg(imgId) {
    let id = position[imgId] + 5;
    if (id > 14)
        id = id - 15;
    img[imgId].setAttribute("src", "images/" + imageArray[id] + ".jpg");
    position[imgId] = id;
    let arr = JSON.stringify(position);
    if ((arr === '[0,1,2,3,4]')|| (arr === '[5,6,7,8,9]' )|| (arr === '[10,11,12,13,14]')) {
        img.forEach(item =>{
            item.setAttribute("style","border: 3px red solid");
        });
        } else {
        img.forEach(item =>{
            item.setAttribute("style","border: 3px blue solid");
        });
    }
}

img.forEach(item => {
    item.addEventListener("click", ev => {
        changeImg(parseInt(item.id));
    });
});




