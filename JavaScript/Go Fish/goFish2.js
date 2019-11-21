var cards = {}; 
var other = {}; 
var players = []; 
class Player {
    name; 
    hand = []; 
    points; 
    updates; 
    constructor(name, type, hand, points){
        this.name = name; 
        this.type = type; 
        this.hand = hand; 
        this.points = points; //Gives you an update of what happened to your hand after every turn 
    }
    
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

function play(canvas, width, height, ctx){
    var nPlayers = document.getElementById('numPlayers').value 
    var numCPU = nPlayers - 1; //returns an int
    players = startGame(numCPU); //returns a map or array, user should be p1
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

function startGame(numCPU){
    var p1 = new Player("P1", "user", "", 0); 
    dealHand(p1); 
    checkForPairs(p1); 
    players.push(p1); 
    for(i = 2; i <=numCPU; i++){
        var playerName = "P" + i; 
        var player = new Player(playerName, "cpu", "", 0); 
        player = dealHand(player); 
        player = checkForPairs(player); 
        players.push(player); 
    } 
    return players; 
}

function dealHand(player){
    var hand = []; 
    for(i = 0; i < 5; i++){
        hand.push(getCard()); 
    }
    player.hand = hand; 
    return player;

}

function checkForPairs(player){
    var hand = player.hand; //use some other data structure to stor
    var points = player.points; 
    for(i = 0; i < hand.length; i++){
        var temp = hand[i].substring(0, str.length - 1); 
        for(j= i+1; j < hand.length; j++){
            var curr = hand[j].substring(0, str.length - 1); 
            if(temp === curr){
                if(player.)
            }
        }
    }

}

function getNumPlayers(canvas, width, height, ctx){
   
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