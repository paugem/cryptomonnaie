// redirect from the currencyList to a currency by clicking on its line:
const currencyShow = document.querySelectorAll('.currency_unit');

cryptomoney.forEach(p => {
	p.addEventListener("click", redirectCurrencyShow);
});

function redirectCurrencyShow() {
	const id = parseInt(this.parentNode.id);
	window.location.replace("./currency_show.html?id=" + id);
}



// redirect from the currencyShow to its currencyUpdate by clicking on modify:
const currencyModify = document.querySelector('#currency_modify');

cryptomoney.forEach(p => {
	p.addEventListener("click", redirectCurrencyModify);
});

function redirectCurrencyModify() {
	const id = parseInt(this.parentNode.id);
	window.location.replace("./currency_update.html?id=" + id);
}



// Display a modal which ask to confirm the removal:
const currencyDeleteApproval = document.querySelector('#currency_delete');

const currencyDeleteApprovalOpen = function() {
	currencyDeleteApproval.setAttribute('aria-hidden', false);
};

const currencyDeleteApprovalClose = function() {
	currencyDeleteApproval.setAttribute('aria-hidden', true);
};

const currencyDelete = document.querySelectorAll('#currency_delete');
currencyDelete.addEventListener("click", currencyDeleteApprovalOpen);



// Confirm or not the cryptomoney removal:
const currencyDeleteYes = document.querySelector('#currency_delete_yes');
const currencyDeleteNo = document.querySelector('#currency_delete_No');

currencyDeleteYes.addEventListener("click", redirectCurrencyDelete);
currencyDeleteYes.addEventListener("click", currencyDeleteApprovalClose);

function redirectCurrencyDelete() {
	const id = parseInt(this.parentNode.id);
	window.location.replace("./currency_delete.html?id=" + id);
	currencyDeleteApprovalClose;
}