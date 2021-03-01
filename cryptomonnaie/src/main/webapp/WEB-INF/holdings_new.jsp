<div class="container">
	<h1>Créer un avoir</h1>

	<form action="holdings_new.html" method="POST">
		<label>Nom de la Cryptomonnaie : </label> <input type="text" name="nameCurrency" required> <br>
		<label>Quantité : </label> <input type="number" name="quantity"required> <br>
		<label>Prix d'Achat : </label> <input type="number" name="purchasePrice" required> <br> 
		<label>Date d'Achat : </label> <input type="date" name="purchaseDate"required> <br> 
		<input type="submit" value="Valider">
	</form>

	<c:choose>
		<c:when test="${not empty error_message}">
			<h3>
				<c:out value="${error_message }" />
			</h3>
		</c:when>
	</c:choose>
</div>