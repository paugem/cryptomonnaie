<div class="container">
	<h1>Créer une cryptomonnaie</h1>

	<form action="currency_new.html" method="POST">
		<label>Nom : </label> <input type="text" name="name"> <br>
		<label>Label : </label> <input type="text" name="label"> <br>
		<label>Prix Actuel : </label> <input type="number" name="currentPrice"> <br> 
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