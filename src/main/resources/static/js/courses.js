
var app = angular.module('courses', []);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
	when('/services/courses/course#/id/{{c.id}}', {
		templateUrl: '/services/courses/course.html',
		controller: 'ListController'
	});
}]);

app.contoller("cours", function($scope, $http, $routePrams){
	$http({
		url : "/resources/courses/:id",
		params : {id:$routeParams.id},
		methode:"get"
	})
	.then( function(data){
		$scope.cours = data.data;
		console.log(data.data)
	});
});