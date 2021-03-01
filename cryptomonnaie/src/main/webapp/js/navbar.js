const avoirs = document.querySelector('#avoirs');
const crypto = document.querySelector('#cryptomonnaies');

function avoirActive(){
	crypto.classList.remove("active");
	avoirs.classList.add("active");
}

function cryptoActive(){
	avoirs.classList.remove("active");
	crypto.classList.remove("active");
}

avoirs.addEventListener("click", avoirActive);
crypto.addEventListener("click", cryptoActive);