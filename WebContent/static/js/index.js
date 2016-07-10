$(document).ready(function () {

	$(window).scroll(function () {
		if ($(this).scrollTop() != 0) {
			$('#toTop').fadeIn();
		} else {
			$('#toTop').fadeOut();
		}
	});
	$('#toTop').click(function () {
		$('body,html').animate({
			scrollTop: 0
		}, 800);
	});


	var eleOffset = $('#production').offset().top;
	$(window).scroll(function () {
		if ($(this).scrollTop() > eleOffset) {
			$('#toOrderBy').fadeIn(0);
		} else {
			$('#toOrderBy').fadeOut(0);
		}
	});

	$("#owl-demo").owlCarousel({

		navigation: false, // Show next and prev buttons
		slideSpeed: 300,
		paginationSpeed: 400,
		singleItem: true,
		pagination: false,
		autoPlay: 3000, //Set AutoPlay to 3 seconds
	});


	$("#owl-partners-id").owlCarousel({
		autoPlay: 3000, //Set AutoPlay to 3 seconds
		items: 3,
		itemsDesktop: [1199, 3],
		itemsDesktopSmall: [979, 3]
	});



	lightbox.option({
		'resizeDuration': 200,
		'wrapAround': true
	});


	(function () {
		var myMap;
		ymaps.ready(init); // Ожидание загрузки API с сервера Яндекса
		function init() {
			myMap = new ymaps.Map("map", {
				center: [49.973, 36.3023], // Координаты центра карты
				zoom: 10 // Zoom
			});
			myPlacemark = new ymaps.Placemark([49.973, 36.3023], {
				hintContent: 'адрес выдачи',
				balloonContent: 'Харьков'
			});
			myMap.geoObjects.add(myPlacemark);
		}
	})()
});