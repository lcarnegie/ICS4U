var cards = {};
var other = {};
var cpus = [];
var nPlayers;
var canvas;
var width;
var height;
var ctx;
var humanPlayer;
var isGameStarted = false; 
var isHumanTurn = false; 
var turn = 0;
function Player(name, hand, points) {
    this.name = name;
    this.hand = hand;
    this.points = points;

}
function loadImages() {
    var suits = ['clubs', 'hearts', 'spades', 'diamonds',];
    var highCard = ['A', 'J', 'Q', 'K'];
    var backImg = new Image(); 
    backImg.src = "images/cards/back.png"
    cards["back"] = backImg; 
    for (var c of suits) { //loads all cards from 1 to 10
        var suit = c;
        for (var i = 2; i <= 10; i++) {
            var img = new Image();
            img.src = "images/cards/" + suit + i + ".png";
            cards[suit + i] = img;
        }
        for (var h of highCard) {
            var img = new Image();
            img.src = "images/cards/" + suit + h + ".png";
            cards[suit + h] = img;
        }
    }
    var img = new Image();
    img.src = "images/tablebackground.jpg"
    other["background"] = img;
}

function load() {
    document.getElementById('numPlayers').disabled = true;
    document.getElementById('start').disabled = true;
    canvas = document.getElementById('myCanvas');
    width = canvas.width;
    height = canvas.height;
    ctx = canvas.getContext("2d");
    ctx = changeImageSmoothing(ctx);
    loadBackground(width, height, ctx);
    loadUI();
    play(canvas, width, height, ctx);
}

function changeImageSmoothing(ctx) {
    var nCtx = ctx;
    nCtx.mozImageSmoothingEnabled = false;
    nCtx.webkitImageSmoothingEnabled = false;
    nCtx.msImageSmoothingEnabled = false;
    nCtx.imageSmoothingEnabled = false;
    return nCtx;
}

function loadBackground(width, height, ctx) {
    var background = other["background"];
    ctx.drawImage(background, 0, 0, background.width, background.height, 0, 0, width, height);
}

function loadUI() {
    document.getElementById('playerSelector').hidden = false;
    document.getElementById('cardSelector').hidden = false;
    document.getElementById('finishTurn').hidden = false;
}

function play(canvas, width, height, ctx) {
    nPlayers = document.getElementById('numPlayers').options[document.getElementById('numPlayers').selectedIndex].value;
    initPlayers(nPlayers);
    drawCards(); 
    setInterval(game, 1500);
}

function game() {
    if (!isGameStarted) {
        drawCards();
        isGameStarted = true; 
    }
    if (turn >= nPlayers) {
        turn = 0;
    }
    checkForPairs(humanPlayer);
    updateGame(); 
    for (var i = 1; i < cpus.length; i++) {
        checkForPairs(cpus[i]);
        updateGame(); 
    }
    if (turn === 0) {//player turn 
        document.getElementById('playerSelector').disabled = false;
        document.getElementById('cardSelector').disabled = false;
        document.getElementById('finishTurn').disabled = false;
        if(playerTurn()){
            updateGame(); 
            checkForPairs(humanPlayer); 
            updateGame(); 
            turn++; 
        }
    }
    if(turn === 1){
        if(cpuTurn(cpus[1])){
            updateGame(); 
            checkForPairs(cpus[1]); 
            updateGame();
            turn++;  
        }
    }
    if (turn >= nPlayers) {
        turn = 0;
    }
    if(turn === 2){
        if(cpuTurn(cpus[2])){
            updateGame(); 
            checkForPairs(cpus[1]); 
            updateGame();
            turn++;  
        }
    }
    if (turn >= nPlayers) {
        turn = 0;
    }
    if(turn === 3){
        if(cpuTurn(cpus[3])){
            updateGame(); 
            checkForPairs(cpus[3]); 
            updateGame();
            turn++;  
        }
    }
    checkForEmptyHand(humanPlayer, cpus); 
    if(checkForWinner(humanPlayer, cpus)){
        clearInterval(); 
        displayWinner(checkForWinner(humanPlayer, cpus))
    }
}

function checkForEmptyHand(humanPlayer, cpus){
    if(humanPlayer.hand.length === 0){
        alert("You ran out of cards, so you were dealt 5 more from the pile.")
        dealHand(humanPlayer); 
    }
    for(var i = 1; i < cpus.length; i++){
        if(cpus[i].hand.length === 0){
            alert(cpus[i].name + " ran out of cards, so they were dealt 5 more from the pile.")
            dealHand(cpus[i]); 
        }
    }
}

function checkForWinner(humanPlayer, cpus){
    if(humanPlayer.points >= 10){
        return humanPlayer; 
    }
    for(var i = 1; i < cpus.length; i++){
        if(cpus[i].points >= 10){
            return cpus[i]; 
        }
    }
}

function displayWinner(player) {
    alert(player.name + " won! Reload the page to play again!") 
}

function updateGame() {
    ctx.clearRect(0, 0, width, height);
    loadBackground(width, height, ctx);
    displayPoints(humanPlayer); 
    for(i = 1; i < cpus.length; i++){
        displayPoints(cpus[i]); 
    }
    drawCards();
}

function drawCards(){
if(nPlayers > 3){
    drawHand(1, humanPlayer.hand); 
    drawHand(2, cpus[1].hand); 
    drawHand(3, cpus[2].hand);
    drawHand(4, cpus[3].hand);  
} else if(nPlayers > 2){
    drawHand(1, humanPlayer.hand); 
    drawHand(2, cpus[1].hand); 
    drawHand(3, cpus[2].hand); 
} else if(nPlayers > 1){
    drawHand(1, humanPlayer.hand); 
    drawHand(2, cpus[1].hand); 
}
}


function drawHand(pNumber, hand){
    if(pNumber === 1){
        for(i=0; i<hand.length; i++){
            var handNo = i; 
            var card = cards[hand[handNo]]; 
            drawCard(card, ctx, width/2 - 100 + i * (card.width/18), 420); 
        }
    }else if(pNumber === 2){
        for(i=0; i<hand.length; i++){
            var card = cards["back"]; 
            drawCard(card, ctx, 10, height/2 - 150 + i * card.height/18);
        }
    }else if(pNumber == 3){
        for(i=0; i<hand.length; i++){
            var card = cards["back"]; 
            drawCard(card, ctx, width/2 - 100 + i * (card.width/18), 10); 
        }
    }else if(pNumber == 4){
        for(i=0; i<hand.length; i++){
            var card = cards["back"]; 
            drawCard(card, ctx, 690, height/2 - 150 + i * card.height/18)
        }
    }
}

function displayPoints(player){
    var playerName = player.name; 
    var points = player.points; 
    if(playerName === "You"){
        document.getElementById("p1score").innerHTML = points; 
    }else if(playerName === "CPU1"){
        document.getElementById("p2score").innerHTML = points; 
    }else if(playerName === "CPU2"){
        document.getElementById("p3score").innerHTML = points; 
    }else if(playerName === "CPU3"){
        document.getElementById("p4score").innerHTML = points; 
    }
}

function playerTurn() {
    if(!isHumanTurn){
        return false; 
    }else if(isHumanTurn){
        document.getElementById('playerSelector').disabled = true;
        document.getElementById('cardSelector').disabled = true;
        document.getElementById('finishTurn').disabled = true;
        var cpuSelection = document.getElementById('playerSelector').options[document.getElementById('playerSelector').selectedIndex].value;
        var cardSelection = document.getElementById('cardSelector').options[document.getElementById('cardSelector').selectedIndex].value;
        transferCard(cpus[cpuSelection], humanPlayer, cardSelection); 
        isHumanTurn = false; 
        return true; 
    }

}

function cpuTurn(cpu) {
    var playerSelection = getRandomPlayer(cpu);  //picks a number between 1 and numPlayers - 1 (current player can't steal from themself)
    var cardSelection = getRandomSuitInHand(cpu);  
    transferCard(playerSelection, cpu, cardSelection); 
    return true; 
}

function getRandomSuitInHand(cpu){
    var randomCardIndex = Math.floor(Math.random() * (cpu.hand.length - 1)); 
    return cpu.hand[randomCardIndex].substring(cpu.hand[randomCardIndex].length - 1); 
}

function getRandomPlayer(cpu){
    var playersToChoose = []; 
    playersToChoose[0] = humanPlayer; 
    for(var i = 1; i < cpus.length; i++){
        if(cpus[i] === cpu){
        }else{
        playersToChoose.push(cpus[i]);
        }
    }
    var randomIndex = Math.floor(Math.random() * playersToChoose.length); 
    return playersToChoose[randomIndex];
}

function getRandomCard(){
    var card = getCard(); 
    return card.substring(card.length-1); 
}

function transferCard(playerFrom, playerTo, card){
    var playerFromHand = playerFrom.hand; 
    if(card == "0"){
        var card = "10"; 
    }
    for(var i = 0; i < playerFromHand.length; i++){
        var curr = playerFromHand[i].substring(playerFromHand[i].length-1); 
        if(curr == 0){
            curr = 10; 
        }
        if(curr === card){
            var cardToTransfer = playerFromHand.splice(i, 1)[0]; 
            playerTo.hand.push(cardToTransfer); 
            alert(playerTo.name + " asked " + playerFrom.name + " if there were any " + card + "'s in their hand. " + playerFrom.name + " had a " + curr + ", and gave it to " + playerTo.name); 
            return; 
        }
    }
    goFish(playerFrom, playerTo, card); 
}

function goFish(playerFrom, playerTo, card){
    alert(playerTo.name + " asked " + playerFrom.name + " for a " + card + ", but was told to \"Go Fish!\". A card was drawn from the pile."); 
    playerTo.hand.push(getCard());
}

function getInput(){
    var cpuSelection = document.getElementById('playerSelector').options[document.getElementById('playerSelector').selectedIndex].value;
    var cpuNumber = cpuSelection.substring(cpuSelection.length - 1); 
    var cardSelection = document.getElementById('cardSelector').options[document.getElementById('cardSelector').selectedIndex].value;
    isHumanTurn = validateSelection(cpuNumber, cardSelection); 
    
}

function validateSelection(cpu, card){
    if(cpu > nPlayers - 1){
        alert("Please select a CPU that is in the game!"); 
        return false; 
    }
    for(var i = 0; i < humanPlayer.hand.length; i++){// checks to see if the human player selected a card in their hand
        var curr = humanPlayer.hand[i].substring(humanPlayer.hand[i].length-1); 
        if(curr === card){
            return true; 
        }
    }
    alert("Please select a card in your hand!")
    return false; 
}

function initPlayers(nPlayers) {
    humanPlayer = new Player("You", [], 0);
    dealHand(humanPlayer);
    for (var i = 1; i < nPlayers; i++) {
        var player = new Player("CPU" + i, [], 0);
        dealHand(player);
        cpus[i] = player;
    }
}

function drawBoard(ctx, width, height) {
    clearRect(0, 0, width, height);
    loadBackground(width, height, ctx);
}

function dealHand(player) {
    var hand = [];
    for (var i = 0; i < 5; i++) {
        hand.push(getCard());
    }
    player.hand = hand;
}

function drawCard(card, ctx, xPos, yPos) {
    ctx.drawImage(card, xPos, yPos, card.width / 5, card.height / 5);
}

function checkForPairs(player) {
    var hand = player.hand;
    var points = 0; 
    for (i = 0; i < hand.length; i++) {
        if(hand[i] === null){
        }else{
        var temp = hand[i].charAt(hand[i].length - 1)
        for (j = i + 1; j < hand.length; j++) {
            if(hand[j] === null){
            } else {
            var handJ = hand[j]; 
            var curr = handJ.substring(handJ.length - 1);
            if (temp === curr) {
                alert(player.name + " got a pair!")
                points++;
                hand[i] = null, hand[j] = null, curr = null, temp = null;
                j = hand.length; //exit loop, no need to compare null. 
            }
            }
        }
    }
    }
    for (var i = hand.length; i >= 0; i--) {// remove all nulls
        if (hand[i] === null) {
            hand.splice(i, 1);
        }
    }
    player.hand = hand;
    player.points += points; 
}



function getCard() {
    var suits = ['clubs', 'hearts', 'spades', 'diamonds'];
    var randomSuit = suits[(Math.floor(Math.random() * 4))];
    var randomNumber = Math.floor((Math.random() * (14 - 2 + 1)) + 2)
    if (randomNumber > 10) {
        if (randomNumber === 11) {
            randomNumber = "J";
        }
        if (randomNumber === 12) {
            randomNumber = "Q";
        }
        if (randomNumber === 13) {
            randomNumber = "K";
        }
        if (randomNumber === 14) {
            randomNumber = "A";
        }
    }
    var card = randomSuit + "" + randomNumber;
    return card;
}
 