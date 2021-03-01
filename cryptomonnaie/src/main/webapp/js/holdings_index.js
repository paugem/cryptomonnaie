// redirect from the holdingsList to a holding by clicking on its line:
const holdingShow = document.querySelectorAll('.holding_unit');

window.onload = function() {
	const delta = document.querySelectorAll('.delta');

	delta.forEach(del => {
		if (parseFloat(del.innerHTML) > 0) {
			del.style.color = "green";
		} else if (parseFloat(del.innerHTML) < 0) {
			del.style.color = "red";
		}
	})
}

holdingShow.forEach(p => {
	p.addEventListener("click", redirectHoldingShow);
});

function redirectHoldingShow() {
	const idHolding = parseInt(this.parentNode.id);
	window.location.replace("./holdings_show.html?id=" + idHolding);
}

// redirect from the holdingList to the holdingNew:
const holdingNew = document.querySelector('.holding_new');

holdingNew.addEventListener("click", redirectHoldingNew);

function redirectHoldingNew() {
	window.location.replace("./holdings_new.html");
}