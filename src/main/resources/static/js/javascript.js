$(document)
		.ready(
				function() {
					// stick in the fixed 100% height behind the navbar but
					// don't wrap it
					$('#slide-nav.navbar .container').append(
							$('<div id="navbar-height-col"></div>'));
					// Enter your ids or classes
					var toggler = '.navbar-toggle';
					var pagewrapper = '#page-content';
					var navigationwrapper = '.navbar-header';
					var menuwidth = '100%'; // the menu inside the slide menu
											// itself
					var slidewidth = '80%';
					var menuneg = '-100%';
					var slideneg = '-80%';

					$("#slide-nav")
							.on(
									"click",
									toggler,
									function(e) {
										var selected = $(this).hasClass(
												'slide-active');
										$('#slidemenu').stop().animate({
											left : selected ? menuneg : '20px'
										});
										$('#navbar-height-col').stop().animate(
												{
													left : selected ? slideneg
															: '20px'
												});
										$(pagewrapper).stop().animate(
												{
													left : selected ? '20px'
															: slidewidth
												});
										$(navigationwrapper).stop().animate(
												{
													left : selected ? '20px'
															: slidewidth
												});
										$(this).toggleClass('slide-active',
												!selected);
										$('#slidemenu').toggleClass(
												'slide-active');
										$(
												'#page-content, .navbar, body, .navbar-header')
												.toggleClass('slide-active');
									});
					var selected = '#slidemenu, #page-content, body, .navbar, .navbar-header';
					$(window).on(
							"resize",
							function() {

								if ($(window).width() > 767
										&& $('.navbar-toggle').is(':hidden')) {
									$(selected).removeClass('slide-active');
								}
							});

					$(".navbar").addClass("slidemenu");
					$(".navbar").after("<a class=\"nav-toggle\">Menu</a>");

					$(".nav-toggle").click(function() {
						var altura = $(".active").height();
						if ($(".navbar").hasClass("slidemenu")) {
							$(".navbar").animate({
								height : altura
							}, {
								queue : false,
								duration : 200
							}).removeClass("slidemenu");
						} else {
							$(".navbar").animate({
								height : "0px"
							}, {
								queue : false,
								duration : 200
							}).addClass("slidemenu");
						}
					});
				});

// Menu lateral
function openNav() {
	// variaveis
	var largura = window.innerWidth;
	var altura = window.innerHeight;

	// Verifica Se a Tela esta minimizada
	if (largura < 750) {
		document.getElementById("mySidenav").style.width = "50%";
	} else {
		document.getElementById("mySidenav").style.width = "20%";

	}
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
}