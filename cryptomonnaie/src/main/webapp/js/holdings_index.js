// redirect from the holdingsList to a holding by clicking on its line:
const holdingShow = document.querySelectorAll('.holding_unit');

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