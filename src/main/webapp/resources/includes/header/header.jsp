<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
		<title>Adidas | Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link href="../source/css/style.css" rel="stylesheet" type="text/css" media="all"/>
		<link href="../..rm.css" rel="stylesheet" type="text/css" media="all"/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		<script type="text/javascript" src="../..ery.min.js"></script>
		<script src="../..ery.easydropdown.js"></script>
		<script type="text/javascript">
        $(document).ready(function () {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function () {
                $(".dropdown dd ul").toggle();
            });

            $(".dropdown dd ul li a").click(function () {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });

            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function (e) {
                var $clicked = $(e.target);
                if (!$clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function () {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
		</script>
		<!-- start menu -->
		<link href="../..gamenu.css" rel="stylesheet" type="text/css" media="all"/>
		<script type="text/javascript" src="../..amenu.js"></script>
		<script>$(document).ready(function () {
        $(".megamenu").megamenu();
    });</script>
		<!-- end menu -->
		<!-- top scrolling -->
		<script type="text/javascript" src="../..e-top.js"></script>
		<script type="text/javascript" src="../..ing.js"></script>
		<script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
            });
        });
		</script>
</head>
<body>
<div class="header-top">
		<div class="wrap">
				<div class="logo">
						<a href="/home"><img src="../../picEnought/logo.png" alt=""/></a>
				</div>
				<div class="cssmenu">
						<ul>
								<c:if test="${login == null}">
										<li class="active"><a href="/registration">Sign up & Save</a></li>
										<li><a href="/login">My Account</a></li>
								</c:if>

								<c:if test="${login != null}">
										<li class="active">
												<form action="/login" method="post">
														<input class="cssmenuLogout" value="logout" type="submit"
																	 name="logout">
												</form>
										</li>
								</c:if>


								<c:if test="${login != null}">
										<li><a href="/login">${login}</a></li>

										<li><a href="/cart">Cart</a></li>
										<li><a>${countCart}</a></li>

										<c:if test="${userPojo.role == 'admin'}">
												<li class="active">
														<form action="/admin" method="get">
																<input class="cssmenuLogout" action="/admin" method="get" type="submit"
																			 value="Admin" style="">
														</form>
												</li>
										</c:if>
								</c:if>

						</ul>
				</div>
				<ul class="icon2 sub-icon2 profile_img">
						<li><a class="active-icon c2" href="#"> </a>
								<ul class="sub-icon2 list">
										<li><h3>Products</h3><a href=""></a></li>
										<style>
												.layer {
														overflow: scroll; /* Добавляем полосы прокрутки */
														overflow-x: hidden;
														/*width: 300px; !* Ширина блока *!*/
														height: 400px; /* Высота блока */
														padding: 5px; /* Поля вокруг текста */
														border: solid 0px black; /* Параметры рамки */
												}
										</style>
										<div class="layer">
												<c:forEach var="warishee" items="${cartProduct}" varStatus="сounter">
														<div style="margin: 15px">
																<div class="card mb-3">
																		<div style="display: flex;">
																				<img width="100" height="150" src="${warishee.photoUrlBig1}"
																						 alt="Card image cap" style="margin-left: 1%;">
																				<div class="card-body" style="margin-left: 1%">

																						<h5 class="card-title">${warishee.name}</h5>
																						<p class="card-text">${warishee.description}</p>
																						<p class="card-text">$ ${warishee.price}</p>
																						<form action="/cart" method="post">
																								<input type="hidden" name="removeId" value="${warishee.id}"/>
																								<input class="cssmenuLogout" type="submit" value="Remove">
																						</form>
																				</div>
																		</div>
																</div>
														</div>
												</c:forEach>
										</div>

								</ul>
						</li>
				</ul>
				<div class="clear"></div>
		</div>
</div>
<div class="header-bottom">
		<div class="wrap">
				<!-- start header menu -->
				<ul class="megamenu skyblue">
						<li><a class="color1" href="/home">Home</a></li>
						<li><a class="color1" href="/shop?categoryId=1">Man</a></li>
						<li><a class="color1" href="/shop?categoryId=2">Woman</a></li>
						<li><a class="color1" href="/shop?categoryId=3">Kids</a></li>
						<li><a class="color1" href="/shop">All product</a></li>
				</ul>
				<div class="clear"></div>
		</div>
</div>
