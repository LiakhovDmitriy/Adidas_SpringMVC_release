<%@include file="includ/header.jsp" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap.js"/>" type="text/javascript">

<c:forEach var="warishee" items="${sessionScope.cartProduct}" varStatus="сounter">
		<div style="margin: 15px">
				<div class="card mb-3">
						<div style="display: flex;">
								<img width="200" height="250" src="<c:url value="/resources/images/${warishee.photoUrlBig1}"/>"
										 alt="Card image cap"
										 style="margin-left: 10%">
								<div class="card-body" style="margin-left: 10%">

										<h5 class="card-title" inline-block>${warishee.name}</h5>
										<p class="card-text" inline-block>${warishee.bigDescription} </p>

										<span class="card-text">$ ${warishee.price} </span>
										<span class="card-text"> Quantity ${warishee.count}</span>
										<br>


										<form action="/cart" method="post">
												<input type="hidden" name="idProduct" value="${warishee.id}"/>
												<input type="text" value="1" name="amount"/>

												<input type="submit" class="buyButton" value="Change quantity"
															 style="outline: none;border: none; background: none; color: black; margin: 5px;"/>
										</form>

										<br>
										<br>
										<form action="/cart" method="post">
												<input type="hidden" name="removeId" value="${warishee.id}"/>
												<input class="cssmenuLogout" style="margin: 0px 0px" type="submit" value="Remove all">
										</form>
								</div>
						</div>
				</div>
		</div>

</c:forEach>

<c:if test="${countCart == 0}">
		<div style="margin: 15px">
				<div class="card mb-3">
						<div style="display: flex;">
								<div class="card-body">
										<h5 align="center">Cart is empty</h5>
								</div>
						</div>
				</div>
		</div>
</c:if>

<%@include file="/resources/includes/footer/footer.jsp" %>
