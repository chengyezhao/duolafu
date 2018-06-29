$(document).ready(function () {
	var activePos = $('.tabs-header .active').position();
	function changePos() {
		activePos = $('.tabs-header .active').position();
		$('.border').stop().css({
			left: activePos.left,
			width: $('.tabs-header .active').width()
		});
	}
	changePos();
	var tabHeight = $('.tab.active').height();
	function animateTabHeight() {
		tabHeight = $('.tab.active').height();
		$('.tabs-content').stop().css({ height: tabHeight + 'px' });
	}
	animateTabHeight();
	function changeTab() {
		var getTabId = $('.tabs-header .active a').attr('tab-id');
		$('.tab').stop().fadeOut(300, function () {
			$(this).removeClass('active');
		}).hide();
		$('.tab[tab-id=' + getTabId + ']').stop().fadeIn(300, function () {
			$(this).addClass('active');
			animateTabHeight();
		});
	}
	$('.tabs-header a').on('click', function (e) {
		e.preventDefault();
		var tabId = $(this).attr('tab-id');
		$('.tabs-header a').stop().parent().removeClass('active');
		$(this).stop().parent().addClass('active');
		changePos();
		tabCurrentItem = tabItems.filter('.active');
		$('.tab').stop().fadeOut(300, function () {
			$(this).removeClass('active');
		}).hide();
		$('.tab[tab-id="' + tabId + '"]').stop().fadeIn(300, function () {
			$(this).addClass('active');
			animateTabHeight();
		});
	});
	var tabItems = $('.tabs-header ul li');
	var tabCurrentItem = tabItems.filter('.active');
	$('[ripple]').on('click', function (e) {
		var rippleDiv = $('<div class="ripple" />'), rippleOffset = $(this).offset(), rippleY = e.pageY - rippleOffset.top, rippleX = e.pageX - rippleOffset.left, ripple = $('.ripple');
		rippleDiv.css({
			top: rippleY - ripple.height() / 2,
			left: rippleX - ripple.width() / 2,
			background: $(this).attr('ripple-color')
		}).appendTo($(this));
		window.setTimeout(function () {
			rippleDiv.remove();
		}, 1500);
	});
});