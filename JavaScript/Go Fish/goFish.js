function loadImages() {
    var suits = ['clubs', 'hearts', 'spades', 'diamonds',];
    var highCard = ['A', 'J', 'Q', 'K']; 
    for (var c of suits) { //loads all cards from 1 to 10
        var suit = c;
        for (var i = 2; i <= 10; i++) {
            var img = new Image();
            img.src = "images/cards/clubs" + i + ".png";
            cards[suit + i] = img;
        }
        for (var t of highCard){
            
        }
    }

}