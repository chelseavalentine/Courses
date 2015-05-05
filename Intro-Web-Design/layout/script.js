//Confetti colors
var allColors = ['#ff1643', '#e81d62', '#9b26af', '#ff9700', '#4bae4f', '#02a8f3'];
var greenPurple = ['#4bae4f', '#2d7c31', '#8ac249', '#9b26af', '#a900ff', '#7d56c1'];
var blue = ['#3e50b4', '#2095f2', '#4ec2f6', '#00bbd3', '#00e4ff', '#2878ff'];
var redPink = ['#d22e2e', '#ff1643', '#ff3f80', '#f38eb0', '#c41061', '#ee524f'];

//Confetti shower functions
 //Heart confetti
  var heart = ['heart'];
  var heartConfetti = ['#ff1643', '#ff3f80', '#f48fB1'];

  //Shapes
  var square = [5, 5, 0];
  var circle = [5, 5, 5];
  var rectangle = [10, 2.5, 0];

  //Which shade of the balloon's color confetti
  function whichShade (color) {
    var shade = Math.floor( Math.random() * color.length );
    return shade;
  }

  function confettiDirection (){
    var num = Math.floor(Math.random() * 2);

    //Initialize variable 
    var direction = "";

    if (num === 0){
      direction = "confettiRight";
    }
    else{
      direction = "confettiLeft";
    }
    
    return direction;
  }

  function shower (){
    var count = 0;
    do{
    $("<div></div>")
    .appendTo("body")
    .css({
      "position": "absolute",
      "height": "2.5px",
      "width": "10px",
      "top": Math.floor(Math.random() * 75) + "%",
      "left": (1 + Math.floor(Math.random() * 98) )+ "%",
      "background-color": allColors[whichShade(allColors)],
      "z-index": "3",
      "-moz-transform": "rotate(-30deg)",
      "transform": "rotate(-30deg)",
      "-webkit-transform": "rotate(" + Math.floor(Math.random() * 180) + "deg)",
      "-webkit-animation": "fallFlat 5s ease-out 0s 1"
    })
    .animate({"top":"99%"}, 4000)
    .fadeOut(500);
    
    count++;
    } while (count< 20);
  }

  function multipleShowers(showerType){
    var count = 0;
    var delayed = 0;
    do {
      $(this).delay(delayed).queue(showerType()).dequeue();
      count ++;
      delayed += 1000;
    } while (count < 4);
  }

  function confetti( color, shape) {
      //Square confetti is added from inside the balloon
    var count = 0;
    
    var x = event.pageX;
    var y = event.pageY;
    do{
      $("<div></div>")
          .appendTo("body")
          .css({
              "position": "absolute",
              "width": shape[0] + "px",
              "height": shape[1] + "px",
              "border-radius": shape[2] + "px",
              "background": color[whichShade(color)],
              "top": y - 35 + Math.ceil(Math.random() * 70) + "px",
              "left": x - 30 + Math.ceil(Math.random() * 60) + "px",
              "-webkit-transform": "rotate(" + Math.floor(Math.random() * 180) + "deg",
              "z-index": "3",
              "-webkit-animation": confettiDirection() + " 5s ease-out 0s 1"
          })
          .animate({
              top: "99%"
          }, 5000)
          .fadeOut();
      count++;
    } while (count < 10);
  }

  function heartConfettis( color, shape) {
    var count = 0;

    do{
      $("<div></div>")
          .appendTo("body")
          .css({
              "position": "absolute",
              "width": shape[0] + "px",
              "height": shape[1] + "px",
              "border-radius": shape[2] + "px",
              "background": color[whichShade(color)],
              "top": Math.ceil(Math.random() * 99) + "%",
              "left": (1 + Math.floor(Math.random() * 98) )+ "%",
              "z-index": "3",
          })
          .animate({
              top: "99%"
          }, 5000)
          .fadeOut(500);
      count++;
    } while (count < 20);
  }

  function hearts(){
    var count = 0;

    var x = event.pageX;
    var y = event.pageY;

    do{
      $("<img src='img/" + heart[whichShade(heart)] + ".svg'>")
      .appendTo("body")
      .css({
        "position": "absolute",
        "width": "10px",
        "top": y - 35 + Math.ceil(Math.random() * 70) + "px",
        "left": x - 30 + Math.ceil(Math.random() * 60) + "px",
        "z-index": "3",
        "-webkit-animation": confettiDirection() + " 5s ease-out 0s 1"
      })
      .animate({
        top: "98%"
      }, 5000)
      .fadeOut(500);
      count++;
    } while (count < 10);
    heartConfettis(heartConfetti, circle);
  }

//Display confetti bro
$("#allConfetti").hover(function() {
  confetti(allConfetti, circle);
  shower();
  
})

$("#greenPurpleConfetti").hover(function() {
  confetti(greenPurple, circle);
})

$("#blueConfetti").hover(function() {
  confetti(blue, rectangle);  
})

$("#redPinkConfetti").hover(function() {
  confetti(redPink, square);
})

$("#valentine").click(function() {
  hearts();
})