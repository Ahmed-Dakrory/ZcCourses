// Get the modal
var modalLogin = document.getElementById('popUpBoxLogin');
var modalComifrm = document.getElementById('comfirmBox');

//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
//Get the <span> element that closes the modal
var span1 = document.getElementsByClassName("close")[1];

// When the user clicks the button, open the modal 

function openLoginPopUpBox(){
	modalLogin.style.display = "block";
}

function opencomfirmPopUpBox(){
	modalComifrm.style.display = "block";
}
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
	modalLogin.style.display = "none";
}
span1.onclick = function() {
	modalComifrm.style.display = "none";
}
function dismiss(){

	modalLogin.style.display = "none";
	modalComifrm.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modalLogin ||event.target == modalComifrm ) {
	  modalLogin.style.display = "none";
	  modalComifrm.style.display = "none";
  }
}