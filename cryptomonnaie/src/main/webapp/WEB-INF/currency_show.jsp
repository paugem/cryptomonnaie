<div class="container">
	<h1>Information d'une cryptomonnaie</h1>

	<c:choose>
		<c:when test="${empty currency}">
			<h3>Aucune cryptomonnaie n'a cet ID.</h3>
		</c:when>
		<c:otherwise>
			<ul>
				<li><c:out value="${currency.getIdCurrency() }"></c:out></li>
				<li><c:out value="${currency.getNameCurrency() }"></c:out></li>
				<li><c:out value="${currency.getLabel() }"></c:out></li>
				<li><c:out value="${currency.getCurrentPrice() }"></c:out></li>
			</ul>
			<button id="${currency.getIdCurrency() }"
				class="btn btn-primary currency_modify">Modifier</button>
			<button id="${currency.getIdCurrency() }"
				class="btn btn-danger currency_delete">Supprimer</button>
		</c:otherwise>
	</c:choose>

	<!-- delete approval popup page -->
	<div aria-hidden="true" class="popup">
		<div class="popup-box">
			<h1 class="d-flex justify-content-center">Supprimer une	cryptomonnaie</h1>

			<h3>Desirez vous supprimer cette cryptomonnaie?</h3>

			<button class="btn btn-success currency_delete_yes" id="${currency.getIdCurrency() }" type="button">Oui</button>
			<button class="btn btn-danger currency_delete_no" type="button">Non</button>
		</div>
	</div>
</div>

<script type="text/javascript" src="./js/currency_show.js"></script>