
var menu = 0;

$(".hamburger").click(function(){
  if (menu%2 !== 0){
    hideSide(500);
  }
  else{
    showSide(500);
  }
  menu++;
})

$(".hamburger").hover(function(){
  $(this).animate({opacity: "1"}, 0);
})

$(".hamburger").mouseout(function(){
  $(this).animate({opacity: "0.5"}, 0);
})

var cover = false;

function hideSide(time){
  $(".sidebar, .header").fadeOut(0);
  $(".headerContent").animate({left: "10px"}, time);
  if (cover === true){
    $(".cover").fadeOut(time);
    cover = false;
  }
}

function showSide(time){
  $(".sidebar, .header").fadeIn(0);
  $(".headerContent").animate({left: "250px"}, time);
  $(".cover")
    .show(0);
  cover = true;
}

$("div.cover").click(function(){
  hideSide(500);
  menu++;
});