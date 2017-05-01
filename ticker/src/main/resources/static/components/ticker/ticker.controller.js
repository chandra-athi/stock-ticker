tickerapp.controller('ticker-controller', function($http, $scope){
	
	$scope.stocks = [];
	$scope.stockDetails = {};
	
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
	
	
	 var handleCallback = function (msg) {
         $scope.$apply(function () {
             var modifiedStock = JSON.parse(msg.data)
             $scope.stockDetails[modifiedStock.symbol]['live-price'] = modifiedStock['live-price'];
         });
     }

     var source = new EventSource('/users/chandru/updates');
     source.addEventListener('message', handleCallback, false);

	
	
})