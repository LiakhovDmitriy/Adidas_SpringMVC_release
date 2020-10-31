<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includ/header.jsp" %>

<div class="index-banner" style="padding: 0px 0;">
		<div class="wmuSlider example1" style="height: 560px;">
				<div class="wmuSliderWrapper">
						<article style="position: relative; width: 100%; opacity: 1;">
								<div class="banner-wrap">
										<div class="slider-left">
												<img src="<c:url value="/resources/images/indexHomeBanner/Home.jpg"/>" alt=""/>
										</div>
										<div class="slider-right">
												<h1>NMD_R1 V2 </h1>
												<h2>TOKYO NIGHTS SHOES</h2>
												<p>CORE BLACK / BOLD PINK / BOLD AQUA</p>
												<div class="btn"><a href="/shop">Shop Now</a></div>
										</div>
										<div class="clear"></div>
								</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
								<div class="banner-wrap">
										<div class="slider-left">

												<img src="<c:url value="/resources/images/indexHomeBanner/Home1.jpg"/>" alt=""/>
										</div>
										<div class="slider-right">
												<h1>SWIFT</h1>
												<h2>RUN X SHOES</h2>
												<p>CLOUD WHITE / CORE BLACK / BLUE</p>
												<div class="btn"><a href="/shop">Shop Now</a></div>
										</div>
										<div class="clear"></div>
								</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
								<div class="banner-wrap">
										<div class="slider-left">
												<img src="<c:url value="/resources/images/indexHomeBanner/home3.jpg"/>" alt=""/>
										</div>
										<div class="slider-right">
												<h1>SUPERSTAR</h1>
												<h2>20 RUNNING SHOES</h2>
												<p>CORE BLACK / CORE BLACK / SOLAR RED</p>
												<div class="btn"><a href="/shop">Shop Now</a></div>
										</div>
										<div class="clear"></div>
								</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
								<div class="banner-wrap">
										<div class="slider-left">
												<img src="<c:url value="/resources/images/indexHomeBanner/home5.jpg"/>" alt=""/>

										</div>
										<div class="slider-right">
												<h1>STAN</h1>
												<h2>SMITH SHOES</h2>
												<p>CLOUD WHITE / CLOUD WHITE / GREEN</p>
												<div class="btn"><a href="/shop">Shop Now</a></div>
										</div>
										<div class="clear"></div>
								</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
								<div class="banner-wrap">
										<div class="slider-left">
												<img src="<c:url value="/resources/images/indexHomeBanner/home4.jpg"/>" alt=""/>

										</div>
										<div class="slider-right">
												<h1>RAPIDARUN</h1>
												<h2>ELITE SHOES</h2>
												<p>ASH GREY / CLOUD WHITE / SOLAR RED</p>
												<div class="btn"><a href="/shop">Shop Now</a></div>
										</div>
										<div class="clear"></div>
								</div>
						</article>
				</div>
				<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
				<ul class="wmuSliderPagination">
						<li><a href="#" class="">0</a></li>
						<li><a href="#" class="">1</a></li>
						<li><a href="#" class="wmuActive">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
				</ul>
				<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
				<ul class="wmuSliderPagination">
						<li><a href="#" class="wmuActive">0</a></li>
						<li><a href="#" class="">1</a></li>
						<li><a href="#" class="">2</a></li>
						<li><a href="#" class="">3</a></li>
						<li><a href="#" class="">4</a></li>
				</ul>
		</div>
		<%--		<img src="<c:url value="/resources/images/indexHomeBanner/home4.jpg"/>" alt=""/>--%>

		<script src="<c:url value="/resources/js/jquery.wmuSlider.js"/>"></script>
		<%--		<script type="text/javascript" src="<c:url value="/resources/js/modernizr.custom.min.js"/>"></script>--%>
		<script>
        $('.example1').wmuSlider();
		</script>
</div>
<div class="main">
		<div class="wrap">
				<div class="content-top">
						<div class="lsidebar span_1_of_c1" style="font-size: 14px">
								<p>We are in social networks</p>
						</div>
						<div class="cont span_2_of_c1">
								<div class="social">
										<ul>
												<li class="facebook"><a href="#"><span> </span></a>

														<div class="radius"><img src="<c:url value="/resources/images/picEnought/radius.png"/>"
																										 alt=""><a
																		href="#"> </a>
														</div>
														<div class="border hide"><p class="num">1.51K</p></div>
												</li>
										</ul>
								</div>
								<div class="social">
										<ul>
												<li class="twitter"><a href="#"><span> </span></a>

														<div class="radius"><img src="<c:url value="/resources/images/picEnought/radius.png"/>"
																										 alt="">
														</div>
														<div class="border hide"><p class="num">1.51K</p></div>
												</li>
										</ul>
								</div>
								<div class="social">
										<ul>
												<li class="google"><a href="#"><span> </span></a>

														<div class="radius"><img src="<c:url value="/resources/images/picEnought/radius.png"/>">
														</div>
														<div class="border hide"><p class="num">1.51K</p></div>
												</li>
										</ul>
								</div>
								<div class="social">
										<ul>
												<li class="dot"><a href="#"><span> </span></a>

														<div class="radius"><img src="<c:url value="/resources/images/picEnought/radius.png"/>">
														</div>
														<div class="border hide"><p class="num">1.51K</p></div>
												</li>
										</ul>
								</div>
								<div class="clear"></div>
						</div>
						<div class="clear"></div>
				</div>

				<div class="content-bottom">
						<c:forEach var="warishee" items="${productListHomeP}" varStatus="сounter">

								<c:if test="${сounter.index == '0'}">
										<div class="box1">
								</c:if>
								<c:if test="${сounter.index == '3'}">
										<div class="box1">
								</c:if>

								<div class="col_1_of_single1 span_1_of_single1">
										<div class="view1 view-fifth1">
												<div class="top_box">
														<h3 class="m_1">${warishee.name}</h3>
														<p class="m_2">${warishee.description}</p>
														<div class="grid_img">
																<div class="css3"><img src="<c:url value="/resources/images/${warishee.photoUrlIcon}"/>"
																											 alt=""/></div>
																<div class="mask1">
																		<form action="/singleproduct" method="get">
																				<input type="hidden" name="idProduct" value="${warishee.id}"/>
																				<div class="info"><input type="submit"
																																 style="outline: none;border: none; background: none; color: white; margin: 5px;"
																																 value="Send"/></div>
																		</form>
																</div>
														</div>
														<div class="price">$ ${warishee.price}</div>
												</div>
										</div>
										<span class="rating1">
																<c:if test="${warishee.rating == '1'}">
																		<input type="radio" class="rating-input" id="rating-input-1-1"
																					 name="rating-input-1">
																		<label for="rating-input-1-1" class="rating-star"></label>
																</c:if>
																<c:if test="${warishee.rating == '2'}">
																		<input type="radio" class="rating-input" id="rating-input-1-2"
																					 name="rating-input-1">
																		<label for="rating-input-1-2" class="rating-star"></label>
																</c:if>
																<c:if test="${warishee.rating == '3'}">
																		<input type="radio" class="rating-input" id="rating-input-1-3"
																					 name="rating-input-1">
																		<label for="rating-input-1-3" class="rating-star1"></label>
																</c:if>
																<c:if test="${warishee.rating == '4'}">
																		<input type="radio" class="rating-input" id="rating-input-1-4"
																					 name="rating-input-1">
																		<label for="rating-input-1-4" class="rating-star1"></label>
																</c:if>
																<c:if test="${warishee.rating == '5'}">
																		<input type="radio" class="rating-input" id="rating-input-1-5"
																					 name="rating-input-1">
																		<label for="rating-input-1-5" class="rating-star1"></label>
																</c:if>
										        	  (45)
										    	      </span>
										<ul class="list2">
												<li>

														<ul class="icon1 sub-icon1 profile_img">
																<li>
																		<c:if test="${userPojo == null}">
																				<button id="show" class="button2"
																								style="outline: none;border: none; background: none; color: white; margin: 5px;">
																						Add To Bag
																				</button>
																		</c:if>

																		<c:if test="${userPojo != null}">
																				<%--																						Старе --%>
																				<%--																						<form action="/cart" method="post" class="button2">--%>
																				<%--																								<input type="hidden" name="idProduct" value="${warishee.id}"/>--%>
																				<%--																								<input type="button" class="button2"--%>
																				<%--																											 style="outline: none;border: none; background: none; color: white; margin: 5px;"--%>
																				<%--																											 value="Add To Bag" onclick="getData(${warishee.id})"/>--%>
																				<%--																						</form>--%>


																				<%--																							Нове --%>
																				<input type="hidden" name="prodId" value="${warishee.id}"/>
																				<input id="imgMinus" type="button" onclick="minus(${warishee.id})" value="-"
																							 style="outline: none;border: none; background: none; color: white; margin: 5px;"/>
																				<input type="text" id="qnt${warishee.id}" value="1" size="2"
																							 style="outline: none;border: none; background: none; color: white; text-align: center;"/>
																				<input id="imgPlus" type="button" onclick="plus(${warishee.id}) " value="+"
																							 style="outline: none;border: none; background: none; color: white; margin: 0px;"/>
																				<input type="button" class="buyButton" value="Buy"
																							 onclick="getData(${warishee.id})"
																							 style="outline: none;border: none; background: none; color: white; margin: 5px;"/>


																		</c:if>
																				<%--																		Це загулшка окна спливаючого --%>
																		<dialog>
																				<p> You must login or registration! <br>
																						<a style="color: black" href="/login">Login</a></p>
																				<a style="color: black">OR</a><br>
																				<a style="color: black" href="/registration">Registration</a></p><br>
																				<button id="close"
																								style="outline: none;border: none; background: none; color: black; margin: 5px;">
																						Close
																				</button>
																		</dialog>

																		<script type=text/javascript>
                                        <%--																						Функция заглушки--%>
                                        var dialog = document.querySelector('dialog');
                                        document.querySelector('#show').onclick = function () {
                                            dialog.showModal();
                                        };
                                        document.querySelector('#close').onclick = function () {
                                            dialog.close();
                                        };
                                        <%--																						Функция Add To Bag --%>

                                        function getData(numb) {
                                            var qnt = document.getElementById("qnt" + numb);
                                            // alert("id: " + numb + " quantity: " + qnt.value);

                                            $.ajax({
                                                url: './cart',
                                                type: 'POST',  // http method
                                                data: {idProduct: numb, amount: qnt.value},  // data to submit
                                                success: function (data) {
                                                    document.getElementById("amountField").innerHTML = data;
                                                }
                                            });
                                        }

                                        <%--																						Функция Количества товаров  --%>

                                        function minus(numb) {
                                            var qnt = document.getElementById("qnt" + numb);
                                            qnt.value = +qnt.value - 1;
                                        }

                                        function plus(numb) {
                                            var qnt = document.getElementById("qnt" + numb);
                                            qnt.value = +qnt.value + 1;
                                        }


																		</script>
																		<ul class="sub-icon1 list">
																				<li><h3>${warishee.description}</h3><a href=""></a></li>
																				<li>
																						<p>${warishee.shortDescription}
																								<a href="">adipiscing elit, sed diam</a>
																						</p>
																				</li>
																		</ul>
																</li>
														</ul>
												</li>
										</ul>
										<div class="clear"></div>
								</div>

								<c:if test="${сounter.index == '2'}">
										<div class="clear"></div>
										</div>
								</c:if>

								<c:if test="${сounter.index == '5'}">
										<div class="clear"></div>
										</div>
								</c:if>
						</c:forEach>

				</div>
		</div>
		<%--<%@include file="includ/footer.jsp" %>--%>
		<%@include file="/resources/includes/footer/footer.jsp" %>

		<%--		<%@include file="/WEB-INF/views/includ/footer.jsp" %>--%>
