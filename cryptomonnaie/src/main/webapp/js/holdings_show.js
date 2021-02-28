// redirect from the holdingShow to its holdingUpdate by clicking on modify:
const holdingModify = document.querySelector('.holding_modify');

holdingModify.addEventListener("click", redirectholdingModify);

function redirectholdingModify() {
	const idHolding = parseInt(this.id);
	window.location.replace("./holdings_update.html?id=" + idHolding);
}



// Display a modal which ask to confirm the removal:
const holdingDeleteApproval = document.querySelector('.popup');

function holdingDeleteApprovalOpen() {
	holdingDeleteApproval.setAttribute('aria-hidden', false);
};

function holdingDeleteApprovalClose() {
	holdingDeleteApproval.setAttribute('aria-hidden', true);
};

const holdingDelete = document.querySelector('.holding_delete');

holdingDelete.addEventListener("click", holdingDeleteApprovalOpen);



// Confirm or not the holding removal:
const holdingDeleteYes = document.querySelector('.holding_delete_yes');
const holdingDeleteNo = document.querySelector('.holding_delete_no');


holdingDeleteYes.addEventListener("click", redirectholdingDelete);
holdingDeleteNo.addEventListener("click", holdingDeleteApprovalClose);

function redirectholdingDelete() {
	const id = parseInt(this.id);
	holdingDeleteApprovalClose;
	window.location.replace("./holdings_delete.html?id=" + id);
}