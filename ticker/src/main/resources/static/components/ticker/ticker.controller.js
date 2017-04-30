tickerapp.controller('ticker-controller', function($http, $scope){
	
	$scope.stocks = [];
	$scope.stockDetails = [];
	
	$http.get('/users/chandru/stocks')
	.then(function(response){
		if(response.status == 200){
			angular.forEach(response.data, function(content){
				$scope.stockDetails[content.symbol] = content;
			});
			$scope.stocks = response.data;	
		}else{
			console.log('error'+response);	
		}
	});
	
	var source = new EventSource("/users/chandru/updates");
	source.onmessage = function(event) {
		console.log(JSON.parse(event.data));
	};

	
	
})