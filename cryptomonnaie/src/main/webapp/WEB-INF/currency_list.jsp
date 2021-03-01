<div class="container">
	<h1>Liste des cryptomonnaies</h1>
	<c:choose>
		<c:when test="${empty currencies or currencies.size() == 0 }">
			<h3>Aucune cryptomonnaie.</h3>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nom</th>
						<th scope="col">Label</th>
						<th scope="col">Prix Actuel</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${currencies}" var="currency">
						<tr id="${currency.getIdCurrency()}">
							<td class="currency_unit"><c:out value="${currency.getIdCurrency() }"></c:out></td>
							<td class="currency_unit"><c:out value="${currency.getNameCurrency() }"></c:out></td>
							<td class="currency_unit"><c:out value="${currency.getLabel() }"></c:out></td>
							<td class="currency_unit"><c:out value="${currency.getCurrentPrice() }"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
<button class="btn btn-success currency_new">Ajouter une nouvelle cryptomonnaie</button>
	<c:choose>
		<c:when test="${not empty error_message}">
			<h3>
				<c:out value="${error_message }" />
			</h3>
		</c:when>
	</c:choose>
</div>


<script type="text/javascript" src="./js/currency_index.js"></script>
