$(document).ready(function(){
"use strict";

var flag = $('.leng-bt');

var styleArray = [{"featureType":"all"}];

$('.map').each(function(){

var $this = $(this),
x = ($this.attr('data-x')) ? $this.data('x') : 53.385873,
y = ($this.attr('data-y')) ? $this.data('y') : -1.471471,
z = ($this.attr('data-zoom')) ? parseInt($this.data('zoom')) : 18;

var options = {
center : new google.maps.LatLng(x, y),
zoom : z,
mapTypeId : google.maps.MapTypeId.ROADMAP,
styles : styleArray,
scrollwheel: false
};

var map = new google.maps.Map(document.getElementById($this.attr('id')), options);

if ($this.attr('data-marker')) {
var marker = new google.maps.Marker({ position: new google.maps.LatLng(x,y), map: map, icon: $this.data('marker')});
};

});

});