<div class="container">
	<h1>Modifier une cryptomonnaie</h1>

	<c:choose>
		<c:when test="${empty currency or currency.size() == 0 }">
			<h5>Aucune cryptomonnaie n'a cet ID.</h5>
		</c:when>
		<c:otherwise>
			<form action="currency_index.html" method="POST">
				<label>ID : </label> <input value="${currency.getIdCurrency() }" type="text" name="id"> <br>
				<label>Name : </label> <input value="${currency.getNameCurrency() }" type="text" name="name"> <br>
				<label>Label : </label> <input value="${currency.getLabelCurrency() }" type="text" name="label"> <br>
				<label>Prix Actuel : </label> <input value="${currency.getcurrentPrice() }" type="text"	name="currentPrice"> <br>
				<input type="submit" value="Valider">
			</form>
		</c:otherwise>
	</c:choose>
</div>