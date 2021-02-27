<div class="container">
	<h1>Information d'une cryptomonnaie</h1>

	<c:choose>
		<c:when test="${empty currency or currency.size() == 0 }">
			<h5>Aucune cryptomonnaie n'a cet ID.</h5>
		</c:when>
		<c:otherwise>
			<ul>
				<li><c:out value="${currency.getIdCurrency() }"></c:out></li>
				<li><c:out value="${currency.getNameCurrency() }"></c:out></li>
				<li><c:out value="${currency.getLabel() }"></c:out></li>
				<li><c:out value="${currency.getCurrentPrice() }"></c:out></li>
			</ul>
			<button id="currency_modify" class="btn btn-primary">
				Modifier</button>
			<button id="currency_delete" class="btn btn-danger">
				Supprimer</button>
		</c:otherwise>
	</c:choose>

	<!-- delete approval popup page -->
	<div aria-hidden="true" class="popup">
		<div class="popup-box">
			<h1 class="d-flex justify-content-center">Supprimer une
				cryptomonnaie</h1>

			<h3>Desirez vous supprimer cette cryptomonnaie?</h3>

			<button class="btn btn-secondary" id="currency_delete_yes" type="button">Oui</button>
			<button class="btn btn-danger" id="currency_delete_np" type="button">Non</button>
		</div>
	</div>

</div>