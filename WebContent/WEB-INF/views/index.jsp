<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Водяные насосы в городе Харькове</title>

	<link href="${pageContext.request.contextPath}/static/css/bootstrap.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/lightbox.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/Glyphter.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/font-awesome.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/fonts.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/owl.carousel.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/owl.theme.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/style.css" type="text/css" rel="stylesheet">

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="${pageContext.request.contextPath}/static/images/favicon.ico" type="image/x-icon">
	<script type="text/javascript">
	   var pumps = {};
	   
	   pumps.siteSettings = {
	    baseUrl: '${pageContext.request.contextPath}',
	    imagesFolder: '${pageContext.request.contextPath}/static/images/staticImages'
	   }
  	</script>
</head>
<body>
	<section class="main-menu">
		<div class="logo-Global">
			<a href="#production"><img src="${pageContext.request.contextPath}/static/images/vodyanye_nasosy1.png" alt=""></a>
		</div>
		<div class="propose">
			<p>г. Харьков</p>
			<p class="we_are_working">Работаем ежедневно:</p>
			<p>9:00-21:00</p>
			<p>Оптом и в розницу</p>
		</div>
		<div class="contacts">
			<div>
				<i class="fa fa-mobile"></i>
			</div>
			<div class="phones">
				<p>063-105-97-51</p>
				<p>098-152-04-26</p>
				<p></p>
			</div>
		</div>
	</section>
	
	<section class="secMenu">
		<div class="content">
			<ul class="menu">
				<li><a href="#OurService">Наши Услуги</a></li>
				<li><a href="#production">Продукция и Цены</a></li>
				<li><a href="#partners">Наши Партнёры</a></li>
				<li><a href="#footer">Контакты</a></li>
			</ul>
		</div>
	</section>
	
	<section class="banner">
		<div id="owl-demo" class="owl-carousel owl-theme">
			<div class="item banner1">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 above-banner">
					<h1>Удобство</h1>
				</div>
			</div>
			<div class="item banner2">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 above-banner">
					<h1>Производительность</h1>
				</div>
			</div>
			<div class="item banner3">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 above-banner">
					<h1>Надёжность</h1>
				</div>
			</div>
		</div>
	</section>
	
	<section id="OurService" class="OurService">
		<div class="content-1">
			<h1 class="global-offers-H1"><span class="orrange-text">Наши преимущества</span></h1>
			<div class="infografic">
				<div class="picture price-label">
					<div class="pict">
						<img src="static/images/best_price-gold.png" alt="">
					</div>
					<div class="txt">
						<p>Самые низкие цены в Украине</p>
					</div>
				</div>
				<div class="picture">
					<div class="pict">
						<img src="static/images/number_one-gold.png" alt="">
					</div>
					<div class="txt">
						<p>№1 в обработке сверхкрупных заказов</p>
					</div>
				</div>
				<div class="picture">
					<div class="pict">
						<img src="static/images/in_time-gold.png" alt="">
					</div>
					<div class="txt">
						<p>Выполнение отгрузки в кратчайшие сроки</p>
					</div>
				</div>
				<div class="picture">
					<div class="pict">
						<img src="static/images/OK-gold.png" alt="">
					</div>
					<div class="txt">
						<p>Высокое качество и гарантия безопасности сделки</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	<section id="production" class="production">
		<div class="content-1">
			<h1 class="main-about"><span class="orrange-text">продукция, описание и</span> цены</h1>
			<ul class="prod">
			
			
				<c:forEach items="${products}" var="element">
					<li>
						<div class="foto">
							<c:choose>
							  <c:when test="${element.image != ''}">
							    <a href="${pageContext.request.contextPath}<c:out value="${element.image}"/>" data-lightbox="14" data-title="<c:out value="${element.nameOfPump}"/>">
									<img src="${pageContext.request.contextPath}<c:out value="${element.image}"/>" alt="<c:out value="${element.nameOfPump}"/>">
								</a>
							  </c:when>
							  <c:otherwise>
							    <a href="${pageContext.request.contextPath}/static/images/no-image.png" data-lightbox="14" data-title="<c:out value="${element.nameOfPump}"/>">
									<img src="${pageContext.request.contextPath}/static/images/no-image.png" alt="<c:out value="${element.nameOfPump}"/>">
								</a>
							  </c:otherwise>
							</c:choose>
						</div>
						<div class="discription">
							<p><span class="orrange-text">Наименование:</span> <c:out value="${element.nameOfPump}"/></p>
							<p><span class="orrange-text">Производительность, л/мин:</span> <c:out value="${element.machineCapacity}"/></p>
							<p><span class="orrange-text">Макс напор, м:</span> <c:out value="${element.fall}"/></p>
							<p><span class="orrange-text">Количество клапанов:</span> <c:out value="${element.quantityOfClacks}"/></p>
							<p><span class="orrange-text">Мощность, Вт:</span> <c:out value="${element.powerLevel}"/></p>
							<p><span class="orrange-text">Диаметр корпуса, мм:</span> <c:out value="${element.diameter}"/></p>
							<p><span class="orrange-text">Забор воды:</span> <c:out value="${element.typeOfDrawingOfWater}"/></p>
							<p><span class="orrange-text">Масса, кг:</span> <c:out value="${element.mass}"/></p>
							<p><span class="orrange-text">Напряжение питания, В:</span> <c:out value="${element.inputVoltage}"/></p>
							<p><span class="orrange-text">Изготовитель:</span> <c:out value="${element.maker}"/></p>
						</div>
						<div class="price"><p>335 грн</p></div>
					</li>
				</c:forEach>
			
			</ul>
		</div>
	</section>
	
	<section id="partners" class="section-partners">
		<div class="content-1">
			<h1 class="title-of-block" id="our-partners"><span class="orrange-text">наши партнеры</span></h1>
			<div id="owl-partners-id" class="partner-carousel owl-carousel">
				<div>
					<img class="partners-image" src="static/images/a_N_Post.jpg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/b_post.jpg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/c_bank.jpg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/d_bank.jpg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/e_bank.jpg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/f.jpg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/g.jpeg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/h.jpg" alt="">
				</div>
				<div>
					<img class="partners-image" src="static/images/i.jpg" alt="">
				</div>
			</div>
		</div>
	</section>
	
	
	<section class="map-section">
		<div class="content-1">
		<h1 class="title-of-block"><span class="orrange-text">Наши контакты</span></h1>
			<div class="contact-field">
				<div class="address">
					<p><span class="orrange-text">Адрес выдачи:</span></p>
					<p><span class="font-roman">пр-т Московский 199</span></p>
					<p><span class="font-roman">г. Харьков Украина</span></p>
					<p><span class="font-roman"></span></p>
					<p><span class="font-roman">Почтовый индекс: 61082</span></p>
				</div>
				<div class="contacts">
					<div class="fa">
						<i class="fa fa-phone"></i>
					</div>
					<div class="phones">
						<p><b>063-105-97-51</b></p>
						<p><b>098-152-04-26</b></p>
						<p></p>
					</div>
				</div>
			</div>
			<div class="write-fild">
				<div id="map"></div>
			</div>
		</div>
	</section>
	
	<section id="footer" class="footer">
		<div class="content-1">
			<div class="propose">
				<p>г. <b class="upper"> Хaрьков</b></p>
				<p>Работаем ежедневно:</p>
				<p>9:00-21:00</p>
			</div>
			<div class="propose">
				<p><b class="upper">Звоните договоримся!</b></p>
				<p>Оптом и в розницу.</p>
			</div>
			<div class="contacts">
				<div>
					<i class="fa fa-mobile"></i>
				</div>
				<div class="phones">
					<p>063-105-97-51</p>
					<p>098-152-04-26</p>
					<p></p>
				</div>
			</div>
		</div>
	</section>
	<div id="toTop"><i class="fa fa-arrow-circle-o-up"></i></div>
	<div id="toOrderBy" class="toOrderBy">
		<p>Для заказа звоните:</p>
		<p>(066) 266-81-80</p>
		<p>(063) 105-97-51</p>
		<p>(098) 152-04-26</p>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/owl.carousel.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/lightbox.js"></script>
	
	<script src="http://api-maps.yandex.ru/2.0/?load=package.full&mode=debug&lang=ru-RU"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/index.js"></script>
	
</body>
</html>