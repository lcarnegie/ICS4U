var donations = [1, 2, 3, 4, 5, 1, 2, 4, 4, 5]

function run(){
    console.log(maxDonations(donations, donations.length))
}

function maxDonations(donations, length){
    //first solve w/o including last element
    var solutions = []; 
    solutions[0] = donations[0]; 
    solutions[1] = Math.max(donations[0], donations[1]);
    for(var i = 2; i < length - 1; i++){
        solutions[i] = Math.max(donations[i] + solutions[i-2], solutions[i-1]); 
    }
    //then solve including last element but without 1st element (1st and last elements are neighbors)
    var solutions1 = []; 
    solutions1[0] = donations[1]; 
    solutions1[1] = Math.max(donations[1], donations[2])
    for(var i = 2; i < length - 1; i++){
        solutions1[i] = Math.max(donations[i+1] + solutions1[i-2], solutions1[i-1]); 
    }

    //take the larger solution
    return Math.max(solutions[length-2], solutions1[length-2])
}