var sequence = [1, 7, 4, 9, 2, 5]; 
var differences = []; 

function runThisThing(){
    differences = getDifferences(sequence); 
    console.log(isZigZag(differences)); 
}

function getDifferences(sequence){
    var res = []; 
    for(var i = 1; i < sequence.length; i++){
        res[i-1] = sequence[i] - sequence[i-1]; 
    }
    return res; 
}

function isZigZag(differences){
    var length = 0; 
    var lastSign = []; 
    //take the sign of the first difference in the sequence
    lastSign[1] = Math.sign(differences[0]), length++; //first number of the sequence is trivially a zigzag sequence
    for(var i = 1; i < differences.length; i++){
        //if the current sign is not the same as the stored last sign or not equal to 0 it's part of the zigzag
       if(Math.sign(differences[i]) != Math.sign(lastSign[i]) && Math.sign(differences[i]) != 0){
           length++; 
           lastSign[i+1] = Math.sign(differences[i]); 
       }
    }
    return length + 1; //length of sequence is length of the differences plus 1  
}