function takeInput() {
    var str = document.getElementById("numberInput").value;
    var isValid = false;
    var n = parseInt(str, 10);
    if (isNaN(n)) {
        alert("Input invalid")
    } else {
        if(n < 0){
            n *= -1; 
        }
        document.getElementById("output").innerHTML = nQueens(n);
    }
}

function nQueens(numQueens) {
    var qStack = [];
    var n = numQueens;
    if(n == 0)
        return "There are no solutions"; 
    qStack.push(new Queen(0, 0));
    var isBacktracking = false;
    for (var filled = 0; filled < n;) {
        if (filled == -1) {
            return "There are no solutions.";
        } else if (checkForConflict(qStack[qStack.length - 1]) && !roomToSpare(qStack[qStack.length - 1], n)) {
            filled--;
            qStack.pop();
            filled = backtrack(filled);
        } else if (checkForConflict(qStack[qStack.length - 1]) && roomToSpare(qStack[qStack.length - 1], n)) {
            shiftQueen();
        } else if (!checkForConflict(qStack[qStack.length - 1])) {
            filled++;
            if (filled == n) {} else {
                addQueen(filled);
            }
        }
    }
    return printBoard(n, qStack); 

    function printBoard(n, stack){
        var a = ""; 
        for(var y = 0; y < n; y++){
            var queen = qStack[y]; 
            for(var x = 0; x < n; x++){
                if(queen.xPos == x){
                    a += "Q "; 
                }else{
                    a += "X "; 
                }
            }
            a += "<br>"; 
        }
        return a; 
    }

    function shiftQueen() {
        qStack[qStack.length - 1].xPos += 1; 
    }

    function backtrack(filled) {
        if (!checkForConflict(qStack[qStack.length - 1]) && roomToSpare(qStack[qStack.length - 1], n)) {
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
        var temp = qStack.slice(0);
        temp.pop(); // pops the current queen off of the stack
        var conflict = false;
        try {
            while (!conflict) {
                if (temp[temp.length - 1].xPos === curr.xPos || Math.abs(temp[temp.length - 1].xPos - curr.xPos) === Math.abs(temp[temp.length - 1].yPos - curr.yPos)) {
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

    function addQueen(filled) {
		qStack.push(new Queen(0, filled));
	}
}
class Queen {
    constructor(xPos, yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}