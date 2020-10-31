<%@ page isELIgnored="false" %>
<%@include file="includ/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="register_account">
		<div class="wrap">
				<h4 class="title">Create new PRODUCT</h4>
				<form:form action="/admin" method="POST" modelAttribute="Product" commandObject="Product">


						<div class="col_1_of_2 span_1_of_2">
								Name
								<div><form:input type="text" name="name" path="name"/></div>
								Price
								<div><form:input type="text" name="price" path="price"/></div>
								Discount
								<div><form:input type="text" name="discount" path="discount"/></div>
								Select a category
								<div>
										<form:select id="Category" name="categoryID" class="frm-field required" path="categoryID">
												<option value="0"></option>
												<option value="1">Man</option>
												<option value="2">Woman</option>
												<option value="3">Kids</option>
										</form:select>
								</div>
								Select a rating
								<div>
										<form:select id="Rating" name="rating" class="frm-field required" path="rating">
												<option value="0"></option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
										</form:select>
								</div>
						</div>
						<div class="col_1_of_2 span_1_of_2">
								Short Description
								<div>
										<form:input type="text" name="shortDescription" path="shortDescription"/>
								</div>
								Description
								<div>
										<form:input type="text" name="description" path="description"/>
								</div>


						</div>
						<div class="formLogoutS" style="margin-top: unset; ">
								<button class="grey" value="send" type="submit">Submit</button>
						</div>

						<p class="terms">By clicking 'Create Account' you agree to the <a href="#">Terms &amp; Conditions</a>.</p>
						<div class="clear"></div>


						<c:forEach var="errorList" items="${ERROR}">
								${errorList}
						</c:forEach>
				</form:form>
		</div>
</div>

<%@include file="/resources/includes/footer/footer.jsp" %>
