<div class="container">
	<h1>Modifier une cryptomonnaie</h1>

	<c:choose>
		<c:when test="${false}">
			<h5>Aucune cryptomonnaie n'a cet ID.</h5>
		</c:when>
		<c:otherwise>
			<form action="currency_update.html?id=${currency.getIdCurrency() }" method="POST">
				<label>Name : </label> <input value="${currency.getNameCurrency() }" type="text" name="name" readonly> <br>
				<label>Label : </label> <input value="${currency.getLabel() }" type="text" name="label" readonly> <br>
				<label>Prix Actuel : </label> <input value="${currency.getCurrentPrice() }" type="text" name="currentPrice"> <br>
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