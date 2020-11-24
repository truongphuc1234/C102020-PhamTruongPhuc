class Model {
    constructor(row, col) {
        this.col = col;
        this.row = row;
        this.boardArray = [];
        for (let i = 0; i < this.row; i++) {
            this.boardArray[i] = []
            for (let j = 0; j < this.col; j++) {
                this.boardArray[i][j] = -1;
            }
        }
        this.player = 0;
    }

    update(row, col) {
        if (this.boardArray[row][col] === -1) {
            this.boardArray[row][col] = this.player;
            this.changePlayer();
            if (this.checkWin(row, col, this.boardArray[row][col]) && this.checkFull()) {
                this.reset();
            }

            this.onChanged(this);
            return true;
        }
        return false;
    }

    reset() {
        for(let i = 0 ; i < this.row; i ++){
            for (let j = 0 ; j < this.col; j ++){
                this.boardArray[i][j] = -1;
            }
        }
        this.player = 0;
    }

    checkWin(row, col, value) {

        //Check by row
        let count = 0;
        for (let i = -4; i <= 4; i++) {
            if (this.boardArray[row + i] && this.boardArray[row + i][col] === value) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        //Check by col
        count = 0;
        for (let i = -4; i <= 4; i++) {
            if (this.boardArray[row][col + i] === value) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        //Check by primary cross
        count = 0;
        for (let i = -4; i <= 4; i++) {
            if (this.boardArray[row + i] && this.boardArray[row + i][col + i] === value) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;
        for (let i = -4; i <= 4; i++) {
            if (this.boardArray[row + i] && this.boardArray[row + i][col - i] === value) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;

    }

    checkFull() {
        for (let item of this.boardArray) {
            for (let item2 of item) {
                if (item2 === -1) {
                    return true;
                }
            }
        }
        return false;
    }

    changePlayer() {
        this.player = 1 - this.player;
    }

    bindBoardChanged(callback) {
        this.onChanged = callback;
    }

}


class Controller {

    constructor() {
        this.view = new View();
        this.model = new Model(10, 10);

        this.displayBoard(this.model);

        this.model.bindBoardChanged(this.displayBoard);
    }

    displayBoard = board => {
        this.view.displayBoard(board);
        this.view.bindClick(this.handleClick);
    }

    handleClick = (row, col) => {
        this.model.update(row, col);
    }

}

class View {

    constructor() {
        this.table = document.createElement("table");
        document.getElementById("root").appendChild(this.table);
        this.arr = ['X','O',''];
    }

    displayBoard(board) {
        while (this.table.lastChild) {
            this.table.removeChild(this.table.lastChild);
        }
        for (let i = 0; i < board.row; i++) {
            let row = document.createElement("tr");
            for (let j = 0; j < board.col; j++) {
                let cell = document.createElement("td");
                cell.className = "cell";
                cell.id = i + "-" + j;
                cell.innerText = this.arr[board.boardArray[i][j]]||this.arr[2];
                row.appendChild(cell);
            }
            this.table.appendChild(row);
        }

    }

    bindClick(handler) {
        for (let row of this.table.childNodes) {
            for (let cell of row.childNodes) {
                cell.addEventListener('click', event => {
                    let [rowID, colID] = event.target.id.split("-").map(item => parseInt(item));
                    handler(rowID, colID);
                })
            }
        }
    }

}


const app = new Controller();



