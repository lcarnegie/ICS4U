const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');

let scale = 1; // TO DO: Fix scaling and zooming in and out
let x = 300;
let y = 100;
let dx = 1; //speed of circle being drawn (or how many pixels are being added to x every time you draw the circle again) 
let dy = 1;
let radius = 20