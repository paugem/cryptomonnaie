<div class="container">
	<h1>Modifier un avoir</h1>

	<c:choose>
		<c:when test="${empty holding}">
			<h3>Aucun avoir n'a cet ID.</h3>
		</c:when>
		<c:otherwise>
				<form action="holdings_update.html?id=${holding.getIdHolding() }" method="POST">
				<div class="container">
					<h4><label>Nom de la cryptomonnaie : </label></h4> <h4><input value="${holding.getNameCurrency() }" type="text" name="nameCurrency" readonly></h4> <br>
				</div>
				<div class="container">
					<h4><label>Quantité : </label></h4> <h4><input value="${holding.getQuantity() }" type="number" name="quantity"></h4> <br>
				</div>
				<div class="container">
					<h4><label>Prix d'Achat : </label></h4> <h4><input value="${holding.getPurchasePrice() }" type="number" name="purchasePrice"></h4> <br>
				</div>
				<div class="container">
					<h4><label>Date d'Achat : </label></h4> <h4><input value="${holding.getPurchaseDate() }" type="date" name="purchaseDate"></h4> <br>
				</div>
				<br>
				<div class="container">
					<input class="btn btn-lg btn-success" type="submit" value="Valider">
				</div>
				</form>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${not empty error_message}">
			<h3><c:out value="${error_message }" /></h3>
		</c:when>
	</c:choose>
</div>