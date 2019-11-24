var cards = {}; 
var other = {}; 
var players = []; 
function Player (name, hand, points) {
   this.name = name; 
   this.hand = hand; 
   this.points = points;
    
}
function loadImages(){
    var suits = ['clubs', 'hearts', 'spades', 'diamonds',];
    var highCard = ['A', 'J', 'Q', 'K']; 
    for (var c of suits) { //loads all cards from 1 to 10
        var suit = c;
        for (var i = 2; i <= 10; i++) {
            var img = new Image();
            img.src = "images/cards/" + suit + i + ".png";
            cards[suit + i] = img;
        }
        for(var h of highCard){
            var img = new Image(); 
            img.src = "images/cards/" + suit + h + ".png";
            cards[suit + h] = img; 
        }
    }
    var img = new Image(); 
    img.src = "images/tablebackground.jpg"
    other["background"] = img; 
}

function displayRandomCard(){
    var card = other["background"]; 
    var canvas = document.getElementById('myCanvas'); 
    var width = canvas.width; 
    var height = canvas.height; 

    var ctx = canvas.getContext("2d");
    ctx.drawImage(card, 250, 250, card.width/4, card.height/4); 


}

function load(){
    document.getElementById('start').disabled = true; 
    var canvas = document.getElementById('myCanvas'); 
    var width = canvas.width; 
    var height = canvas.height; 
    var ctx = canvas.getContext("2d");
    ctx = changeImageSmoothing(ctx); 
    loadBackground(canvas, width, height, ctx); 
    loadUI(); 
    play(canvas, width, height, ctx); 
}

function changeImageSmoothing(ctx){
    var nCtx = ctx; 
    nCtx.mozImageSmoothingEnabled = false;
    nCtx.webkitImageSmoothingEnabled = false;
    nCtx.msImageSmoothingEnabled = false;
    nCtx.imageSmoothingEnabled = false;
    return nCtx; 
}

function loadBackground(canvas, width, height, ctx){
    var background = other["background"]; 
    ctx.drawImage(background, 0, 0, background.width, background.height, 0, 0, width, height); 
}

function loadUI() {
    document.getElementById('playerSelector').hidden = false; 
    document.getElementById('cardSelector').hidden = false; 
    document.getElementById('finishTurn').hidden = false; 
}

function play(canvas, width, height, ctx){
    //drawCards(ctx, cardArr, width/2 - 100, 420); //draws P1's cards *make sure to pass in the hand
    var nPlayers = document.getElementById('numPlayers').value 
    var numCPU = nPlayers - 1; //returns an int
    players = startGame(numCPU, ctx, width); //returns a map or array, user should be p1
    var gameFinished = false; 
   
    
}

function validateInput(input){
    var isValid = false; 
    while(!isValid){
    if(isNaN(input)){
        alert("Invalid Input. Please enter a whole number between 2 and 4")
    }else if(input > 4){
        aler
    }
}   
}

function startGame(numCPU, ctx, width){
    var players = []; 
    var p1 = new Player("P1", null, 0); 
    dealHand(p1); 
    checkForPairs(p1); 
    drawCards(ctx, p1.hand, width/2 - 100, 420);
    loadUIOptions(numCPU, p1.hand); 
    players.push(p1); 
    for(k = 2; k <= numCPU + 1; k++){
        var playerName = "P" + k; 
        var player = new Player(playerName, null, 0); 
        dealHand(player); 
        checkForPairs(player)
        players.push(player); 
    }
    return players; 

}

function loadUIOptions(numCPU, hand){
    var playerSelect = document.getElementById('playerSelector'); 
    var cardSelect = document.getElementById('cardSelector'); 
    for(i = numCPU; i >= 1; i--){
        var newOption = document.createElement("option"); 
        playerNumber = i+1; 
        newOption.text = "P" + playerNumber; 
        playerSelect.add(newOption); 
    }
    for(i = 0; i < hand.length; i++){
        var newOption = document.createElement("option"); 
        newOption.text = hand[i].substring(hand[i].length-1) + " of " + hand[i].substring(0,1).toUpperCase() + hand[i].substring(1, hand[i].length-1);
        cardSelect.add(newOption); 
    }
}


function dealHand(player){
    var hand = []; 
    for(i = 0; i < 5; i++){
        hand.push(getCard()); 
    }
    player.hand = hand; 
    
    return player
}



function drawCards(ctx, hand, startX, y){
    for(i = 0; i < hand.length; i++){
        hand[i] = cards[hand[i]]; //get the image of the card
    }
    for(i = 0; i < hand.length; i++){
        drawCard(hand[i], ctx, startX + i * (hand[i].width/18), y); 
    }

}


function drawCard(card, ctx, xPos, yPos){
    ctx.drawImage(card, xPos, yPos, card.width/5, card.height/5);
    
}

function checkForPairs(player){
    var hand = player.hand; 
    var points = player.points; 
    for(i = 0; i < hand.length; i++){
        try{
        var temp = hand[i].substring(0, hand[i].length - 1); 
        }catch(e){}
        for(j= i+1; j < hand.length; j++){
            try{
            var curr = hand[j].substring(0, hand[j].length - 1); 
            if(temp === curr){
                points++; 
                var card1 = hand[i].substring(hand[i].length-1) + " of " + hand[i].substring(0,1).toUpperCase() + hand[i].substring(1, hand[i].length-1); 
                var card2 = hand[j].substring(hand[j].length-1) + " of " + hand[j].substring(0,1).toUpperCase() + hand[j].substring(1, hand[j].length-1);  
                if(player.name === "P1"){
                    alert("Hooray! Your " + card1 + " and your " + card2 + " made a pair! You earned 1 point."); 
                }else{
                    alert(player.name +"'s " + card1 + " and " + card2 + " made a pair! They earned 1 point."); 
                }
                displayPoints(player.name, points); 
                hand[i] = null, hand[j] = null, temp = null, curr = null; 
                j = hand.length; 
            }
        }catch(e){}
        }
    }
    for(i = hand.length; i >= 0; i--){
        if(hand[i] === null){
            hand.splice(i, 1); 
        }
    }
    player.hand = hand; 
    player.points = points; 

    return player; 

}

function displayPoints(playername, points){
    if(playername === "P1"){
        document.getElementById("p1score").innerHTML = points; 
    }else if(playername === "P2"){
        document.getElementById("p2score").innerHTML = points; 
    }else if(playername === "P3"){
        document.getElementById("p3score").innerHTML = points; 
    }else if(playername === "P4"){
        document.getElementById("p4score").innerHTML = points; 
    }
}


function drawNumPlayers(ctx){ //work on this and card colour scheme
    ctx.font = "48px Arial Black";
    ctx.fillStyle = 
    ctx.fillText("How many players?", 190, 200);
    var nPOptions = ["two", "three", "four"]
    for (i = 195, j = 0; i < 496 && j < 2; i+=150, j++){
        roundedRect(ctx, i, 250, 100, 125, 5);
        ctx.fillStyle = "#801f1f";
        ctx.fill(); 
    }
    ctx.font = "55px Century Gothic";  
    ctx.fillStyle = "#ffffff";
    ctx.fillText("2", 205, 300)
}

function roundedRect(ctx, x, y, width, height, radius) {
    ctx.beginPath();
    ctx.moveTo(x, y + radius);
    ctx.lineTo(x, y + height - radius);
    ctx.arcTo(x, y + height, x + radius, y + height, radius);
    ctx.lineTo(x + width - radius, y + height);
    ctx.arcTo(x + width, y + height, x + width, y + height-radius, radius);
    ctx.lineTo(x + width, y + radius);
    ctx.arcTo(x + width, y, x + width - radius, y, radius);
    ctx.lineTo(x + radius, y);
    ctx.arcTo(x, y, x, y + radius, radius);
    ctx.stroke();
  }

function getCard(){
    var suits = ['clubs', 'hearts', 'spades', 'diamonds'];
    var randomSuit = suits[(Math.floor(Math.random() * 3))]; 
    var randomNumber = (Math.floor(Math.random() * 14) + 1); 
    if(randomNumber > 10){
        if(randomNumber === 11){
            randomNumber = "J"; 
        }
        if(randomNumber === 12){
            randomNumber = "Q"; 
        }
        if(randomNumber === 13){
            randomNumber = "K"; 
        }
        if(randomNumber === 14){
            randomNumber= "A"; 
        }
    }
    var card = randomSuit + "" + randomNumber; 
    return card;
}
