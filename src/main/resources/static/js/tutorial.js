
var app = angular.module('app', []);

app.controller('AppCtrl', function($http) {
	var app = this;
	$http.get("/resources/courses")
	.then( function(data) {
		app.sujet = data.data;
		console.log(data.data);
	});
});