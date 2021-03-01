<div class="container">
	<h1>Modifier un avoir</h1>

	<c:choose>
		<c:when test="${empty holding}">
			<h3>Aucun avoir n'a cet ID.</h3>
		</c:when>
		<c:otherwise>
			<form action="holdings_update.html?id=${holding.getIdHolding() }" method="POST">
				<label>Nom de la cryptomonnaie : </label> <input value="${holding.getNameCurrency() }" type="text" name="nameCurrency" readonly> <br>
				<label>Quantité : </label> <input value="${holding.getQuantity() }" type="number" name="quantity"> <br>
				<label>Prix d'Achat : </label> <input value="${holding.getPurchasePrice() }" type="number" name="purchasePrice"> <br>
				<label>Date d'Achat : </label> <input value="${holding.getPurchaseDate() }" type="date" name="purchaseDate"> <br>
				<input type="submit" value="Valider">
			</form>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${not empty error_message}">
			<h3><c:out value="${error_message }" /></h3>
		</c:when>
	</c:choose>
</div>