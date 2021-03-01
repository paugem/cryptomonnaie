<div class="container">
	<h1>Modifier une cryptomonnaie</h1>

	<c:choose>
		<c:when test="${empty currency}">
			<h3>Aucune cryptomonnaie n'a cet ID.</h3>
		</c:when>
		<c:otherwise>
			<form action="currency_update.html?id=${currency.getIdCurrency() }" method="POST">
			<div class="container">
				<h4><label>Nom : </label></h4> <h4><input value="${currency.getNameCurrency() }" type="text" name="name" readonly></h4> <br>
			</div>
			<div class="container">
				<h4><label>Label : </label></h4> <h4><input value="${currency.getLabel() }" type="text" name="label" readonly> <br></h4>
			</div>
			<div class="container">
				<h4><label>Prix Actuel :</label></h4> <h4><input value="${currency.getCurrentPrice() }" type="number" name="currentPrice"></h4> <br>
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