var ellipse_x = 100;
var ellipse_y = 462;
var vel = 10;

var jump_vel = 10;
var isJumping = false;

var rect_x = 462;
var rect_y = 462;
var rect_vel = 5;

var end_game = false;
var running = false;
var score = 0;

function setup() {
  createCanvas(512, 512);
}

function draw() {
  if (running == false) {
    erase();
    fill(0, 0, 0);
    rect(0, 0, 512, 512);
    noErase();
    fill(0, 255, 0);
    textSize(30);
    text("Tekan tombol apapun", 128, 256);
    fill(0, 0, 0);
    textSize(18);
    text("Naufal Elliando Fatahillah (2117051007)", 50, 50);
    fill(0, 0, 0);
    textSize(18);
    text("Siti Hafijah Zahra Siregar (2157051005)",50 , 70);
  }

  if (keyIsPressed && running == false) running = true;

  if (running == true) {
    if (keyIsDown(32) && isJumping == false) {
      isJumping = true;
    }

    if (isJumping == true) {
      rect_vel = 8;
      if (jump_vel > -11) {
        ellipse_y -= jump_vel * 4;
        jump_vel -= 1;
      } else {
        jump_vel = 10;
        rect_vel = 5;
        isJumping = false;
      }
    }

    if (rect_x > -50) {
      rect_x -= rect_vel;
    } else if (rect_x <= -50) {
      rect_x = 512;
    }

    clear();
    background(0, 0, 0);

    if (
      rect_x + 50 > ellipse_x &&
      rect_x < ellipse_x + 50 &&
      rect_y + 50 > ellipse_y &&
      rect_y < ellipse_y + 50
    ) {
      end_game = true;
    }

    noErase();
    fill(148, 0, 211);
    rect(ellipse_x, ellipse_y, 50, 50);

    fill(128, 4, 0);
    rect(rect_x, rect_y, 50, 50);

    if (end_game == true) {
      erase();
      fill(0, 0, 0);
      rect(0, 0, 512, 512);
      noErase();
      fill(255, 0, 0);
      textSize(35);
      text("Game Selesai Dek BegBegBeg", 10, 256);
      textSize(30);
      text("Score = " + score, 10, 289);
    } else {
      fill(255, 255, 255);
      score++;
      textSize(30);
      text("Score = " + score, 50, 50);
    }
  }
}
