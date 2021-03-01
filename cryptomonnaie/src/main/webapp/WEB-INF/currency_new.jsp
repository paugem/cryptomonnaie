<div class="container">
	<h1>Créer une cryptomonnaie</h1>

	<form action="currency_new.html" method="POST">
		<div class="container">
		<h4><label>Nom : </label> <input type="text" name="name"></h4> <br>
		</div>
		<div class="container">
		<h4><label>Label : </label> <input type="text" name="label"></h4> <br>
		</div>
		<div class="container">
		<h4><label>Prix Actuel : </label> <input type="number" name="currentPrice"></h4> <br>
		</div> 
		<br>
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