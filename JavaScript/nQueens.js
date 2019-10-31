var qStack = [];
var n;

function takeInput() {
    var str = document.getElementById("numberInput").value;
    var isValid = false;
    while (isValid == false) {
        n = parseInt(str, 10);
        if (n != NaN){
            isValid = true; 
        }else {
            alert('Input invalid.')
        }
    } 
   
}

function nQueens(nQueens){
			qStack.push(new Queen(0, 0));
			var isBacktracking = false;
			for (var filled = 0; filled < n;) {
				if (filled == -1) { 
					console.log("There are no solutions.");
					return;
				} else if (checkForConflict(qStack.peek()) && !roomToSpare(qStack.peek(), n)) {
					filled--;
					qStack.pop();
					filled = backtrack(filled);
				} else if (checkForConflict(qStack.peek()) && roomToSpare(qStack.peek(), n)) {
					shiftQueen();
				} else if (!checkForConflict(qStack.peek())) {
					filled++;
					if (filled == n) {
					} else {
						qStack = addQueen(filled);
					}
				}
			}

		printBoard(qStack);
}




function shiftQueen() {
    qStack.peek().setxPos(qStack.peek().getxPos() + 1);
}

function backtrack(filled) {
    if (!checkForConflict(qStack.peek()) && roomToSpare(qStack.peek(), n)) {
        shiftQueen();
    } else {
        filled--;
        if (filled == -1) {
            return -1;
        } else {
            qStack.pop();
            filled = backtrack(filled);
        }
    }
    return filled;
}

function checkForConflict(curr) {
    var temp = qStack;
    temp.pop(); // pops the current queen off of the stack
    var conflict = false;
    try {
        while (!conflict) {
            if (temp.peek().xPos === curr.getxPos() || Math.abs(temp.peek().xPos - curr.xPos) === Math.abs(temp.peek().yPos) - curr.yPos) {
                conflict = true;
                return true;
            } else {
                temp.pop();
            }
        }
    } catch (e) {
        conflict = false;
    }

    return false;
}


function roomToSpare(queen, n) {
    return (queen.xPos + 1 < n);
}

function printBoard(qStack) {
    var stack = [
        [5]
    ];

}

class Queen {
    constructor(xPos, yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.symbol = "Q";
    }

    setXPos(xPos) {
        this.xPos = xPos
    }

    setYPos(yPos) {
        this.yPos = yPos;
    }

    equals(q) {
        return (this.xPos == q.xPos && this.yPos == q.yPos);
    }
}