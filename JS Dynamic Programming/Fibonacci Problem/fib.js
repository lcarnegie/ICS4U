var storedSolutions = []; 
function getInput(){
    var input = document.getElementById("recIn").value; 
    var out = recFib(input); 
    //var out = memFib(input); 
    //var out = dynFib(input);
    document.getElementById('out').innerHTML = out; 
}

function recFib(input){
    if(input < 2){
        return input; 
    } 
 return recFib(input - 1) + recFib(input - 2); 
    
}

function memFib(input) {
    if(storedSolutions[input] != undefined){
        return storedSolutions[input]; 
    }
    if(input < 2){
        return input; 
    }
    var r = memFib(input - 1) + memFib(input - 2); 
    storedSolutions[input] = r; 
    return r; 
    
}

function dynFib(input){
    var storedSolns = [];
    storedSolns[1] = 1;   
    storedSolns[2] = 1; 
    for(var i = 3; i <= input; i++){
        storedSolns[i] = storedSolns[i-1] + storedSolns[i-2]; 
    }
    return storedSolns[input]; 
}