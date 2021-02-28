<div class="container">
	<h1>Liste des cryptomonnaies</h1>
	<c:choose>
		<c:when test="${empty currencies or currencies.size() == 0 }">
			<h5>Aucune cryptomonnaie.</h5>
		</c:when>
		<c:otherwise>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
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
</div>