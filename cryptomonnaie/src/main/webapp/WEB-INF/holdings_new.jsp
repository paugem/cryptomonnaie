<div class="container">
	<h1>Créer un avoir</h1>

	<form action="holdings_new.html" method="POST">
		<label>Nom de la Cryptomonnaie : </label> 
		<select name="nameCurrency">
			<option value="">--Choisissez une cryptomonnaie--</option>
			<c:forEach items="${currencies}" var="currency">
			<option id="${currency.getIdCurrency()}"><c:out value="${currency.getNameCurrency() }"></c:out></option>
			</c:forEach>
		</select> <br>
		<label>Quantité : </label> <input type="number" name="quantity"> <br>
		<label>Prix d'Achat : </label> <input type="number" name="purchasePrice"> <br> 
		<label>Date d'Achat : </label> <input type="date" name="purchaseDate"> <br> 
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