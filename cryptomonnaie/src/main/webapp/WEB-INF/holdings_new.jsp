<div class="container">
	<h1>Créer un avoir</h1>

	<form action="holdings_new.html" method="POST">
		<label>Nom de la Cryptomonnaie : </label> <input type="text" name="nameCurrency"> <br>
		<label>Quantité : </label> <input type="text" name="quantity"> <br>
		<label>Prix d'Achat : </label> <input type="text" name="purchasePrice"> <br> 
		<label>Date d'Achat : </label> <input type="text" name="purchaseDate"> <br> 
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