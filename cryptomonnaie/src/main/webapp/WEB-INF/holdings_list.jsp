<div class="container">
	<h1>Liste des avoirs</h1>
	<c:choose>
		<c:when test="${empty holdings or holdings.size() == 0 }">
			<h3>Aucun avoir.</h3>
		</c:when>
		<c:otherwise>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nom de la Cryptomonnaie</th>
						<th scope="col">Quantité</th>
						<th scope="col">Prix d'Achat</th>
						<th scope="col">Date d'Achat</th>
						<th scope="col">Prix Actuel</th>
						<th scope="col">Delta</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${holdings}" var="holding">
						<tr id="${holding.getIdHolding()}">
							<td class="holding_unit"><c:out value="${holding.getIdHolding() }"></c:out></td>
							<td class="holding_unit"><c:out value="${holding.getNameCurrency() }"></c:out></td>
							<td class="holding_unit"><c:out value="${holding.getQuantity() }"></c:out></td>
							<td class="holding_unit"><c:out value="${holding.getPurchasePrice() }"></c:out></td>
							<td class="holding_unit"><c:out value="${holding.getPurchaseDate() }"></c:out></td>
							<td class="holding_unit"><c:out value="${holding.getCurrentPrice() }"></c:out></td>
							<td class="holding_unit delta"><c:out value="${holding.getDelta() }"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
<button class="btn btn-success holding_new">Ajouter un nouvel avoir</button>
</div>


<script type="text/javascript" src="./js/holdings_index.js"></script>
