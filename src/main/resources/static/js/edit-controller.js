mhsApp.controller('EditController', 
		function($scope, $http, $window) {

	$scope.simpan = function() {
		$http.post('/tambah-data', $scope.mhs).then(sukses, gagal);

		function sukses(response) {
			$window.location.href = "/";	
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.batal = function() {
		$window.location.href = "/";
	};

	$scope.init = function() {
		var nim = $window.location.search.split("=")[1];

		$http.get('/ambil-data-mhs/' + nim).then(sukses, gagal);

		function sukses(response) {
			//console.log(response);
			$scope.mhs = response.data;
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.init();

});