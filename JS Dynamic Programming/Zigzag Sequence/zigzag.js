function start(){
    console.log(longestZigZag([1, 6, 6, 6, 7, 4, 5])); 
}
function longestZigZag(seq){ 
    var differences = []
    var result = 0; 
    for(var i = 0; i < seq.length - 1; i++){
     differences[i] = seq[i+1] - seq[i]; 
    }
    // check for sign of first difference, use it to check if something should be (+) or (-)?
    for(var i = 1; i < differences.length - 1; i++){
        if(Math.sign(differences[i]) === 1){
            if(Math.sign(differences[i-1]) !== -1 || differences[i-1] === null){
                differences[i-1] = null; 
            }
            if(Math.sign(differences[i+1]) !== -1 || differences[i+1] === null){
                differences[i+1] = null; 
            }
        }
        if(Math.sign(differences[i]) === -1){
            if(Math.sign(differences[i-1]) !== 1 || differences[i-1] === null){
                differences[i-1] = null; 
            }
            if(Math.sign(differences[i+1]) !== 1 || differences[i+1] === null){
                differences[i+1] = null; 
            }
        }
        if(Math.sign(differences[i]) === 0){
            if(Math.sign(differences[i-1]) === 0 || differences[i-1] === null){
                differences[i-1] = null; 
            }
            if(Math.sign(differences[i+1]) === 0 || differences[i+1] === null){
                differences[i+1] = null; 
            }
        }
    }
    for(var i = 0; i < differences.length; i++){
        if(differences[i] !== null){
            result++; 
        }
    }
    result += 1; 
    return result; 
}