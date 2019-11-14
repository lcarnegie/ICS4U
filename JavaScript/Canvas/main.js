var cards = {}; 
function loadImages(){
    for(var i = 2; i <= 10; i++){
        var img = new Image();
        img.src ="images/cards/clubs" + i + ".png";
        cards['clubs' + i] = img; 
    }

}

function createImage(elem){
  var canvas = document.getElementById(elem);   // used to get the canvas to draw on it
  var width = canvas.width;         // declares a variable called width and assigns it the width of the canvas
  var height = canvas.height;       // declares a variable called height and assigns it the height of the canvas
  
  var oCtx = canvas.getContext("2d");
  currCard = cards["clubs5"]; 
  oCtx.drawImage(currCard, 250, 100, currCard.width/4, currCard.height/4); 
  
  /*
  var i = 10; 
  for (var c in cards){
    var card = cards[c]; 
    ctx.drawImage(card, 5+i, 50, card.width/4, card.height/4);
    i+=250; 
  }
  */ 


}


