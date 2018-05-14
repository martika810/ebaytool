console.log("Hello product-controller");
var productApp = angular.module('productApp',[]);

productApp.controller('productController',function($scope,$http){
//
//    	//Crea un mapa que tiene como key el id del empleado y el valor(con nombre,apellidos,etc)
	$scope.createProductMap = function(){
	    var productMap = new Object();
	    $.each($scope.productList,function(index,value){
		productMap[value.id] = value;
	    });
	    return productMap;
	}

	$scope.activeModal = function(){
	 // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
		$('.modal').modal();
	}


	//Esto hace una llamada a la clase TaskController
	//Los datos de respuseta se devuelven en "response.data"
	//Y se asignan a la variable taskList
    	$scope.populatePanel = function(){
    	    $http.get("/products")
    	    .then(function(response){
    		    $scope.productList = response.data

		    //cuando haya un cambio en la variable "taskList", entonces se ejecuta estaa funcion
        	    $scope.$watch('productList', function() {
        		$('.collapsible').collapsible();

        	    }, true);
    	    });


    	}
    	$scope.populatePanel();

});

//angular.element(document).ready(function() {
//	angular.bootstrap(document.getElementById("productPanel"), ['productApp']);
//	//angular.bootstrap(document.getElementById("newTaskPanel"), ['taskApp']);
//});
