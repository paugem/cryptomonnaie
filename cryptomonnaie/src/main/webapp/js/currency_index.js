// redirect from the currencyList to a currency by clicking on its line:
const currencyShow = document.querySelectorAll('.currency_unit');

currencyShow.forEach(p => {
	p.addEventListener("click", redirectCurrencyShow);
});

function redirectCurrencyShow() {
	const idCurrency = parseInt(this.parentNode.id);
	window.location.replace("./currency_show.html?id=" + idCurrency);
}

// redirect from the currencyList to the currencyNew:
const currencyNew = document.querySelector('.currency_new');

currencyNew.addEventListener("click", redirectCurrencyNew);

function redirectCurrencyNew() {
	window.location.replace("./currency_new.html");
}