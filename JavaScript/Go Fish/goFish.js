var cards = {}; 
var otherImages = {}; 
var canvas = document.getElementById('canvas');   
var width = canvas.width;         
var height = canvas.height; 
var ctx = canvas.getContext("2d"); 

function loadImages() {
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
    img.src = "images/tablebackground.jpg"; 
    otherImages["background"] = img; 
}

function loadGame(canvas){
    loadImages(); 
    loadBackground(canvas); 
    //playGame(canvas);
}

function loadBackground(canvas){
    var background = cards['clubs10'];
    ctx.drawImage(background, 250, 250); 
}

function playGame(canvas){
  /* var numCPU = getNumPlayers(canvas) - 1; //returns an int
   var players = getPlayers(numCPU); //returns a map or array, user should be p1
   dealCards(players); 
   checkForPairs(players); 
   var gameFinished = false; 
   while(!gameFinished){
       
   }
    */
}




function displayRandomCard(){
    var randomCard = cards[getRandomCard()]; 
    ctx.drawImage(randomCard, 250, 250, randomCard.width/4, randomCard.height/4); 
}

function getRandomCard(){
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
    var image = randomSuit + "" + randomNumber; 
    return image;
}