var sequence = [3, 2, 5, 3, 7, 6, 5]; 


function run(){
    console.log(longestZigZag(sequence, sequence.length)); 
}

function longestZigZag(seq, length){
   var Zig = [length][2];
   var result = 1; 

   for(var i = 0; i < length; i++){
       Zig[i][0] = 1; 
       Zig[i][1] = 1; 
   }

   for(var i = 1; i < length; i++){

        for(var j = 0; j < i; j++){

            if(seq[j] < seq[i] && Zig[i][0] < Zig[j][1] + 1){
                Zig[i][0] = Zig[j][1] + 1; 
            }

            if(seq[j] > seq[i] && Zig[i][1] < Zig[j][0] + 1){
                Zig[i][1] = Zig[j][0] + 1; 
            }
        }

        if(result < Math.max(Zig[i][0], Zig[i][1])){
            result = Math.max(Zig[i][0], Zig[i][1]); 
        }
   }

   return result; 

}