var app = angular.module('app', ['ngSanitize']);

app.directive('navBar', function($http) {
	return {
		templateUrl:"/navbar.html",
		scope : {
			page : "@page" 
		},
		link : function(scope, elt, attr){
			$http.get("/resources/members/loggedIn")
			.then( function(data) {
				scope.member = data.data;
				//console.log(data.data);
			})
			scope.member = ""
			scope.isUndefined = function(){
				return (typeof scope.member.id === "undefined")
			}
		}

	};
});

app.controller("controller", function($scope){
	
});



app.controller('AppCtrl2', function($scope, $http) {
	var app = this;
	$http.get("/resources/courses")
	.then( function(data) {
		$scope.sujet = data.data;
		console.log(data.data);
	});
});




