const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');

let scale = 1; // TO DO: Fix scaling and zooming in and out
let x = 300;
let y = 100;
let dx = 1; //speed of circle being drawn (or how many pixels are being added to x every time you draw the circle again) 
let dy = 1;
let radius = 20
let stop = false;

document.getElementById('stop').disabled = true;

document.getElementById('x').innerHTML = x;
document.getElementById('y').innerHTML = y;
ctx.clearRect(0, 0, canvas.width, canvas.height);
ctx.fillStyle = '#FE621D'
ctx.fillRect(0, 0, canvas.width, canvas.height);
ctx.beginPath();
ctx.arc(x, y, radius, 0, 2 * Math.PI, false)
ctx.fillStyle = '#00CFC1';
ctx.fill();


function animate() {
    let animation = requestAnimationFrame(animate);
    document.getElementById('x').innerHTML = x;
    document.getElementById('y').innerHTML = y;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.fillStyle = '#FE621D'
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    ctx.beginPath();
    ctx.arc(x, y, radius, 0, 2 * Math.PI, false)
    ctx.fillStyle = '#00CFC1';
    ctx.fill();

    if (stop) {
        cancelAnimationFrame(animation);
    }

    if (x >= canvas.width - radius || x <= 0 + radius) {
        dx = -dx; // change the sign of the velocity 
    }

    if (y >= canvas.height - radius || y <= 0 + radius) {
        dy = -dy; // change the sign of the velocity 
    }

    x += dx;
    y += dy;

}



function stopBall() {
    document.getElementById('go').disabled = false;
    document.getElementById('stop').disabled = true;
    stop = true;
}

function moveBall() {
    document.getElementById('stop').disabled = false;
    document.getElementById('go').disabled = true;
    stop = false;
    animate();
}

function increaseSpeed() {
    if (dx === 0) {
        dx = 1;
    }
    if (dy === 0) {
        dy = 1;
    }
    if (dx < 0) {
        dx -= 20
    }
    if (dy < 0) {
        dx -= 20
    }
    if (dx > 0) {
        dx += 20
    }
    if (dy > 0) {
        dx += 20
    }
}

function decreaseSpeed() {
    if (dx < 0) {
        dx += 20
    }
    if (dy < 0) {
        dx += 20
    }
    if (dx > 0) {
        dx -= 20
    }
    if (dy > 0) {
        dx -= 20
    }
}

function zoomIn() {
    scale += 0.5;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.beginPath();
    ctx.arc(x, y, radius, 0, 2 * Math.PI, false)
    ctx.fillStyle = 'orange';
    ctx.fill();
}

function zoomOut() {
    scale -= 0.5;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.beginPath();
    ctx.arc(x, y, radius, 0, 2 * Math.PI, false)
    ctx.fillStyle = 'orange';
    ctx.fill();
}









