tickerapp.controller('ticker-controller', function($http, $scope){
	alert('hello');
	
	$scope.stocks = [];
	
	$http.get('/users/chandru/stocks')
	.then(function(response){
		if(response.status == 200){
			$scope.stocks = response.data;	
		}else{
			console.log('error'+response);	
		}
	});
	
})