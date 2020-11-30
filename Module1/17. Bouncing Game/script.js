class Board {
    constructor(width, height) {
        this._width = width;
        this._height = height;
    }

    get width() {
        return this._width;
    }

    get height() {
        return this._height;
    }
}

class Ball {
    constructor(coord_X, coord_Y, velocity, angle, radius) {
        this._radius = radius;
        this._X = coord_X;
        this._Y = coord_Y;
        this._velocity = velocity;
        this._angle = angle;
    }

    getBorder(x, y, ward) {
        switch (ward) {
            case 'top':
                return y - this._radius;
                break;
            case 'bot':
                return y + this._radius;
                break;
            case 'left':
                return x - this._radius;
                break;
            case 'right':
                return x + this._radius;
                break;
            default:
                break;
        }
    }

    bounce(ward) {
        switch (ward) {
            case 'right':
                this._angle = 180 - this._angle;
                break;
            case 'left':
                this._angle = 180 - this._angle;
                break;
            case 'top':
                this._angle = 360 - this._angle;
                break;
            case 'bot':
                this._angle = 360 - this._angle;
                break;
            default:
                break;

        }

    }

    move(border_top, border_bot, border_left, border_right) {

        let x = this._X + this._velocity * Math.cos(this._angle * Math.PI / 180);
        let y = this._Y + this._velocity * Math.sin(this._angle * Math.PI / 180);

        let min_velocity = this._velocity;

        if (this.getBorder(x, y, 'top') <= border_top) {
            let velocity = (border_top - this._radius - this._Y) / Math.sin(this._angle * Math.PI / 180);
            if (velocity < min_velocity) {
                min_velocity = velocity;
            }
        }

        if (this.getBorder(x, y, 'bot') >= border_bot) {
            let velocity = (border_bot - this._radius - this._Y) / Math.sin(this._angle * Math.PI / 180);
            if (velocity < min_velocity) {
                min_velocity = velocity;
            }

        }

        if (this.getBorder(x, y, 'left') <= border_left) {
            let velocity = (border_left - this._radius - this._X) / Math.cos(this._angle * Math.PI / 180);
            if (velocity < min_velocity) {
                min_velocity = velocity;
            }

        }

        if (this.getBorder(x, y, 'right') >= border_right) {
            let velocity = (border_right - this._radius - this._X) / Math.cos(this._angle * Math.PI / 180);
            if (velocity < min_velocity) {
                min_velocity = velocity;
            }
        }

        this._X = this._X + min_velocity * Math.cos(this._angle * Math.PI / 180);
        this._Y = this._Y + min_velocity * Math.sin(this._angle * Math.PI / 180);

        if (this.getBorder(this._X, this._Y, 'top') <= border_top) {
            this.bounce('top');
        }

        if (this.getBorder(this._X, this._Y, 'bot') >= border_bot) {
            this.bounce('bot');
            this._velocity += 0.2;
        }

        if (this.getBorder(this._X, this._Y, 'left') <= border_left) {
            this.bounce('left');
        }

        if (this.getBorder(this._X, this._Y, 'right') >= border_right) {
            this.bounce('right');
        }
    }

    get x() {
        return this._X;
    }

    get y() {
        return this._Y;
    }

    get radius() {
        return this._radius;
    }

}

class Bar {
    constructor(width, coord_X, coord_Y, velocity) {
        this._width = width;
        this._X = coord_X;
        this._Y = coord_Y;
        this._velocity = velocity
    }

    move(ward, border_left, border_right) {
        switch (ward) {
            case 'right':
                if (this._X + this.width + this._velocity < border_right) {
                    this._X += this._velocity;
                } else {
                    this._X = border_right - this.width;
                }
                break;
            case 'left':
                if (this._X - this._velocity > border_left) {
                    this._X -= this._velocity
                } else {
                    this._X = 0;
                }
                break;
            default:
                break;
        }
    }

    get x() {
        return this._X;
    }

    get y() {
        return this._Y;
    }

    get width() {
        return this._width;
    }

}

class Game {
    constructor() {
        this.board = new Board(600, 500);
        this.bar = new Bar(80, 175, 350, 20);
        this.ball = new Ball(60, 125, 2, 15+Math.random()*60, 10);
        this.score = 0;

        let autoMove = setInterval(() => {
            this.ball.move(0, ((this.ball.x < this.bar.x + this.bar.width) && (this.ball.x > this.bar.x)&&(this.ball.y <= this.bar.y)) ? this.bar.y : this.board.height, 0, this.board.width);
            if (this.ball.y + this.ball.radius > this.board.height - 1) {
                alert("Bạn đã thua cuộc");
                clearInterval(autoMove);
            }
        }, 10);

        let autoScore = setInterval(()=>{
            this.score ++;
            if (this.ball.y + this.ball.radius > this.board.height - 1) {
                clearInterval(autoScore);
            }
        }, 1000);
    }
}

class View {
    constructor(game) {
        this.canvas = document.createElement('canvas');
        this.canvas.width = game.board.width;
        this.canvas.height = game.board.height;
        this.canvas.style.border = '1px solid red';
        this.ctx = this.canvas.getContext('2d');

        this.display(this.canvas);

        setInterval(() => {
            this.create(game)
        }, 10);
    }

    create(game) {
        this.ctx.clearRect(0, 0, game.board.width, game.board.height)
        this.ctx.beginPath();
        this.ctx.arc(game.ball.x, game.ball.y, game.ball.radius, 0, 2 * Math.PI);
        this.ctx.rect(game.bar.x, game.bar.y, game.bar.width, 15);

        this.ctx.font = '10px Arial';
        this.ctx.strokeText(game.score,game.board.width- 30, 15);
        this.ctx.stroke();
    }

    display(canvas) {
        while (document.body.lastChild) {
            document.body.removeChild(document.body.lastChild);
        }
        document.body.appendChild(canvas);

    }

}

let game = new Game();
const view = new View(game);

window.addEventListener('keydown', (evt) => {
    let key;
    switch (evt.code) {
        case 'ArrowRight':
            key = 'right';
            break;
        case 'ArrowLeft':
            key = 'left';
            break;
        default:
            break;
    }
    game.bar.move(key, 0, game.board.width)
    setTimeout(game.bar.move, 1)
})

