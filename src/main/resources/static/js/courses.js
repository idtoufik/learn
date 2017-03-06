
var app = angular.module('courses', []);

app.contoller("cours", function($scope, $http, $location){
	id = $location.search().id
	console.log(id)
	/*$http.get("/resources/courses/:id")
	.then( function(data){
		//$scope.cours = data.data;
		console.log(data.data)
	});*/
});