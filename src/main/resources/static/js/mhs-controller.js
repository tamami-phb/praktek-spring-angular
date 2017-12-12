mhsApp.controller('MhsController', 
		function($scope, $http, $window) {
	$scope.daftarMhs = [];

	$scope.ambilDaftarMahasiswa = function() {
		$http.get('/list-mahasiswa').then(sukses, gagal);

		function sukses(response) {
			console.log(response);
			console.log(response.data);
			$scope.daftarMhs = response.data;
		};
 
		function gagal(response) {
			console.log(response);
		};
	};

	$scope.bukaForm = function() {
		$window.location.href = "/form";
	};

	$scope.ubah = function(mhs) {
		//console.log("nim : " + mhs.nim);
		//console.log("nama : " + mhs.nama);
		//console.log("jurusan : " + mhs.jurusan);
		$window.location.href = "/form-edit?nim=" + mhs.nim;
	};

	$scope.hapus = function(mhs) {
		//console.log("nim : " + mhs.nim + " akan dihapus.");
		//console.log("nama : " + mhs.nama);
		//console.log("jurusan : " + mhs.jurusan);
		$http.delete('/hapus-data/' + mhs.nim).then(sukses, gagal);

		function sukses(response) {
			$scope.ambilDaftarMahasiswa();			
		};

		function gagal(response) {
			console.log(response);
		};
	};

	$scope.ambilDaftarMahasiswa();
});