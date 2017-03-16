var homePageModule = angular.module('home', []);

homePageModule.controller('HomeController', function($scope, $http) {
	$http.get('http://localhost:8080/home').then(function(response) {
		$scope.data = response.data;
	});
});

homePageModule.controller("CreateUserController", function($scope, $http) {
	$scope.variable = "Create new user:";
	$scope.user = {};
	$scope.signup = function() {
		var response = $http.post('http://localhost:8080/signup', $scope.user);
		response.success(function(data, status, headers, config) {
			$scope.data = data;
			//Redirect login/home
		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});
	}
});

homePageModule.controller("LoginController", function($scope, $http) {
	$scope.variable = "Login Controller";
	$scope.user = {};
	$scope.signup = function() {
		var response = $http.post('http://localhost:8080/login', $scope.email, $scope.password);
		response.success(function(data, status, headers, config) {
			$scope.data = data;
			//redirect to home
		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});
	}
});
