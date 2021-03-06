<div class="container">
	<h1>Information d'un avoir</h1>

	<c:choose>
		<c:when test="${empty holding}">
			<h3>Aucun avoir n'a cet ID.</h3>
		</c:when>
		<c:otherwise>
			<ul class="border border-secondary rounded" style="background-color:lightgrey">
				<li><h4>ID : <c:out value="${holding.getIdHolding() }"></c:out></h4></li>
				<li><h4>Nom : <c:out value="${holding.getNameCurrency() }"></c:out></h4></li>
				<li><h4>Quantit� : <c:out value="${holding.getQuantity() }"></c:out></h4></li>
				<li><h4>Prix d'Achat : <c:out value="${holding.getPurchasePrice() }"></c:out></h4></li>
				<li><h4>Date d'Achat : <c:out value="${holding.getPurchaseDate() }"></c:out></h4></li>
				<li><h4>Prix Actuel : <c:out value="${holding.getCurrentPrice() }"></c:out></h4></li>
				<li><h4>Delta : <c:out value="${holding.getDelta() }"></c:out></h4></li>
			</ul>
			<div>
			<button id="${holding.getIdHolding() }"
				class="btn btn-lg btn-primary holding_modify">Modifier</button>
			<button id="${holding.getIdHolding() }"
				class="btn btn-lg btn-danger holding_delete">Supprimer</button>
			</div>
		</c:otherwise>
	</c:choose>

	<!-- delete approval popup page -->
	<div aria-hidden="true" class="popup">
		<div class="popup-box">
			<h1 class="d-flex justify-content-center">Supprimer un avoir</h1>

			<h3>Desirez vous supprimer cet avoir?</h3>

			<button class="btn btn-success holding_delete_yes" id="${holding.getIdHolding() }" type="button">Oui</button>
			<button class="btn btn-danger holding_delete_no" type="button">Non</button>
		</div>
	</div>
</div>

<script type="text/javascript" src="./js/holdings_show.js"></script>