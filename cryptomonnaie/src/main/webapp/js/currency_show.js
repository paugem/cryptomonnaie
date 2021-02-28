// redirect from the currencyShow to its currencyUpdate by clicking on modify:
const currencyModify = document.querySelector('.currency_modify');

currencyModify.addEventListener("click", redirectCurrencyModify);

function redirectCurrencyModify() {
	const idCurrency = parseInt(this.id);
	window.location.replace("./currency_update.html?id=" + idCurrency);
}



// Display a modal which ask to confirm the removal:
const currencyDeleteApproval = document.querySelector('.popup');

function currencyDeleteApprovalOpen() {
	currencyDeleteApproval.setAttribute('aria-hidden', false);
};

function currencyDeleteApprovalClose() {
	currencyDeleteApproval.setAttribute('aria-hidden', true);
};

const currencyDelete = document.querySelector('.currency_delete');

currencyDelete.addEventListener("click", currencyDeleteApprovalOpen);



// Confirm or not the cryptomoney removal:
const currencyDeleteYes = document.querySelector('.currency_delete_yes');
const currencyDeleteNo = document.querySelector('.currency_delete_no');


currencyDeleteYes.addEventListener("click", redirectCurrencyDelete);
currencyDeleteNo.addEventListener("click", currencyDeleteApprovalClose);

function redirectCurrencyDelete() {
	const id = parseInt(this.id);
	window.location.replace("./currency_delete.html?id=" + id);
	currencyDeleteApprovalClose;
}