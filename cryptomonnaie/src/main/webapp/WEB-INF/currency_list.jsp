<div class="container">
	<h1>Liste des cryptomonnaies</h1>

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
				<tr>
					<td><c:out value="${currency.getIdCurrency() }"></c:out></td>
					<td><c:out value="${currency.getNameCurrency() }"></c:out></td>
					<td><c:out value="${currency.getLabel() }"></c:out></td>
					<td><c:out value="${currency.getCurrentPrice() }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>