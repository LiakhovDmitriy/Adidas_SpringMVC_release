<%@ page isELIgnored="false" %>
<%@include file="includ/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="<c:url value="/resources/css/etalage.css"/>">
<script src="<c:url value="/resources/js/jquery.etalage.min.js"/>"></script>
<script>
    jQuery(document).ready(function ($) {

        $('#etalage').etalage({
            thumb_image_width: 300,
            thumb_image_height: 400,

            show_hint: true,
            click_callback: function (image_anchor, instance_id) {
                alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
            }
        });
        // This is for the dropdown list example:
        $('.dropdownlist').change(function () {
            etalage_show($(this).find('option:selected').attr('class'));
        });

    });
</script>

<div class="single">
		<div class="wrap">
				<div class="rsidebar span_1_of_left">
						<section class="sky-form">
								<h4>Category</h4>
								<div class="row row1 scroll-pane">
										<div class="col col-4">
												<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Flats
														(70)</label>
										</div>
										<div class="col col-4">
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Athletic Shoes
														(48)</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Athletic Shoes
														(48)</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Heels (38)</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other (1)</label>
										</div>
								</div>
						</section>
						<section class="sky-form">
								<h4>Brand</h4>
								<div class="row row1 scroll-pane">
										<div class="col col-4">
												<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Adidas by
														Stella
														McCartney</label>
										</div>
										<div class="col col-4">
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Asics</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Bloch</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Bloch Kids</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Capezio</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Capezio Kids</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Nike</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Zumba</label>
										</div>
								</div>
						</section>

						<section class="sky-form">
								<h4>Price</h4>
								<div class="row row1 scroll-pane">
										<div class="col col-4">
												<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>$50.00 and
														Under
														(30)</label>
										</div>
										<div class="col col-4">
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$100.00 and Under
														(30)</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$200.00 and Under
														(30)</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$300.00 and Under
														(30)</label>
												<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>$400.00 and Under
														(30)</label>
										</div>
								</div>
						</section>

				</div>
				<div class="cont span_2_of_3">
						<div class="labout span_1_of_a1">
								<!-- start product_slider -->
								<ul id="etalage">
										<li>
												<a href="optionallink.html">

														<img class="etalage_thumb_image"
																 src="<c:url value="/resources/images/${product.photoUrlBig1}"/>"/>
														<img class="etalage_source_image"
																 src="<c:url value="/resources/images/${product.photoUrlBig1}"/>"/>

												</a>
										</li>
										<li>
												<img class="etalage_thumb_image"
														 src="<c:url value="/resources/images/${product.photoUrlBig2}"/>"/>
												<img class="etalage_source_image"
														 src="<c:url value="/resources/images/${product.photoUrlBig2}"/>"/>
										</li>
										<li>

												<img class="etalage_thumb_image"
														 src="<c:url value="/resources/images/${product.photoUrlBig3}"/>"/>
												<img class="etalage_source_image"
														 src="<c:url value="/resources/images/${product.photoUrlBig3}"/>"/>

										</li>
										<li>

												<img class="etalage_thumb_image"
														 src="<c:url value="/resources/images/${product.photoUrlBig4}"/>"/>
												<img class="etalage_source_image"
														 src="<c:url value="/resources/images/${product.photoUrlBig4}"/>"/>

										</li>

								</ul>


								<!-- end product_slider -->
						</div>
						<div class="cont1 span_2_of_a1">
								<h3 class="m_3">${product.name}</h3>

								<div class="price_single">
										<span class="reducedfrom">$${product.price}</span>
										<span class="actual">$${product.price}</span><a href="#">click for offer</a>
								</div>
								<ul class="options">
										<h4 class="m_9">Select a Size</h4>
										<li><a href="#">6</a></li>
										<li><a href="#">7</a></li>
										<li><a href="#">8</a></li>
										<li><a href="#">9</a></li>
										<div class="clear"></div>
								</ul>
								<div class="btn_form">
										<c:if test="${userPojo == null}">
												<button id="show" class="button2"
																style="outline: none;border: none; background: none; color: black; margin: 5px;">
														Add To Bag
												</button>
										</c:if>
										<c:if test="${userPojo != null}">

												<input type="hidden" name="prodId" value="${product.id}"/>
												<input id="imgMinus" type="button" onclick="minus(${product.id})" value="-"
															 style="outline: none;border: none; background: none; color: black; margin: 5px;"/>
												<input type="text" id="qnt${product.id}" value="1" size="2"
															 style="outline: none;border: none; background: none; color: black; text-align: center;"/>
												<input id="imgPlus" type="button" onclick="plus(${product.id}) " value="+"
															 style="outline: none;border: none; background: none; color: black; margin: 0px;"/>
												<input type="button" class="buyButton" value="Buy" onclick="getData(${product.id})"
															 style="outline: 1px;border: black; background: none; color: black; margin: 5px;"/>


										</c:if>

										<dialog>
												<p> You must login or registration! <br>
														<a style="color: black" href="/login">Login</a></p>
												<a style="color: black">OR</a><br>
												<a style="color: black" href="/registration">Registration</a></p><br>
												<button id="close"
																style="outline: none;border: none; background: none; color: black; margin: 5px;"> Close
												</button>
										</dialog>

										<script type=text/javascript>
                        var dialog = document.querySelector('dialog');
                        document.querySelector('#show').onclick = function () {
                            dialog.showModal();
                        };
                        document.querySelector('#close').onclick = function () {
                            dialog.close();
                        };

                        function getData(numb) {
                            var qnt = document.getElementById("qnt" + numb);
                            // alert("id: " + numb + " quantity: " + qnt.value);

                            $.ajax({
                                url: './cart',
                                type: 'POST',
                                data: {idProduct: numb, amount: qnt.value},
                            });
                        }

                        function minus(numb) {
                            var qnt = document.getElementById("qnt" + numb);
                            qnt.value = +qnt.value - 1;
                        }

                        function plus(numb) {
                            var qnt = document.getElementById("qnt" + numb);
                            qnt.value = +qnt.value + 1;
                        }
										</script>
								</div>
								<ul class="add-to-links">
										<li><a href="#">Add to wishlist</a></li>
								</ul>
								<p class="m_desc">${product.bigDescription}</p>
								<div class="social_single">
										<ul>
												<li class="fb"><a href="#"><span> </span></a></li>
												<li class="tw"><a href="#"><span> </span></a></li>
												<li class="g_plus"><a href="#"><span> </span></a></li>
												<li class="rss"><a href="#"><span> </span></a></li>
										</ul>
								</div>
						</div>
						<div class="clear"></div>
						<ul id="flexiselDemo3">

								<c:forEach var="warishee" items="${productList}">
										<li>
												<a href="<c:url value="/singleproduct?idProduct=${warishee.id}"/>">
														<img src="<c:url value="/resources/images/${warishee.photoUrlIcon}"/>"
																 alt="/singleproduct?idProduct=${warishee.id}"/></a>
												<div class="grid-flex">
														<a href="<c:url value="/singleproduct?idProduct=${warishee.id}"/>">${warishee.name}</a>
														<p>$ ${warishee.price}</p>
												</div>
										</li>
								</c:forEach>

						</ul>

						<script type="text/javascript">
                $(window).load(function () {
                    $("#flexiselDemo1").flexisel();
                    $("#flexiselDemo2").flexisel({
                        enableResponsiveBreakpoints: true,
                        responsiveBreakpoints: {
                            portrait: {
                                changePoint: 480,
                                visibleItems: 1
                            },
                            landscape: {
                                changePoint: 640,
                                visibleItems: 2
                            },
                            tablet: {
                                changePoint: 768,
                                visibleItems: 3
                            }
                        }
                    });

                    $("#flexiselDemo3").flexisel({
                        visibleItems: 5,
                        animationSpeed: 1000,
                        autoPlay: true,
                        autoPlaySpeed: 3000,
                        pauseOnHover: true,
                        enableResponsiveBreakpoints: true,
                        responsiveBreakpoints: {
                            portrait: {
                                changePoint: 480,
                                visibleItems: 1
                            },
                            landscape: {
                                changePoint: 640,
                                visibleItems: 2
                            },
                            tablet: {
                                changePoint: 768,
                                visibleItems: 3
                            }
                        }
                    });

                });
						</script>
						<script type="text/javascript" src="<c:url value="/resources/js/jquery.flexisel.js"/>"></script>
						<div class="toogle">
								<h3 class="m_3">Product Details</h3>
								<p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh
										euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis
										nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis
										autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore
										eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent
										luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta
										nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
						</div>
						<div class="toogle">
								<h3 class="m_3">Product Reviews</h3>
								<p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh
										euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis
										nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis
										autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore
										eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent
										luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta
										nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
						</div>

						<div class="toogle">
								<h3 class="m_3"></h3>
								<p class="m_text" hidden>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh
										euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis
										nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis
										autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore
										eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent
										luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta
										nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
						</div>
				</div>
				<div class="clear"></div>
		</div>
</div>

<%@include file="/resources/includes/footer/footer.jsp" %>
