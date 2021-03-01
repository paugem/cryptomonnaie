<div class="container">
	<h1>Créer un avoir</h1>

	<form action="holdings_new.html" method="POST">
		<div class="container">
		<h4><label>Nom de la Cryptomonnaie : </label> 
		<select name="nameCurrency">
			<option value="">--Choisissez une cryptomonnaie--</option>
			<c:forEach items="${currencies}" var="currency">
			<option id="${currency.getIdCurrency()}"><c:out value="${currency.getNameCurrency() }"></c:out></option>
			</c:forEach>
		</select></h4> <br>
		</div>
		<div class="container">
			<h4><label>Quantité : </label> <input type="number" name="quantity"></h4> <br>
		</div>
		<div class="container">
			<h4><label>Prix d'Achat : </label> <input type="number" name="purchasePrice"></h4> <br> 
		</div>
		<div class="container">
			<h4><label>Date d'Achat : </label> <input type="date" name="purchaseDate"></h4> <br> 
		</div>
		<div class="container">
		<input class="btn btn-lg btn-success" type="submit" value="Valider">
		</div>
	</form>

	<c:choose>
		<c:when test="${not empty error_message}">
			<h3>
				<c:out value="${error_message }" />
			</h3>
		</c:when>
	</c:choose>
</div>