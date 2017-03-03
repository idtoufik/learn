
//var app = angular.module('app2', []);

app.controller('AppCtrl2', function($http) {
	var app = this;
	$http.get("/resources/courses")
	.then( function(data) {
		app.sujet = data.data;
		console.log(data.data);
	});
});

