console.log("Hello tool-controller");
var toolApp = angular.module('toolApp',[]);
toolApp.controller('toolController',function($scope,$http){
	
	//Esto hace una llamada a la clase TaskController
	//Los datos de respuseta se devuelven en "response.data"
	//Y se asignan a la variable toolList
	
	$scope.populateToolPanel = function(){
	    
		$http.get("/tool")
			.then(function(response)
			{
				$scope.toolList = response.data
				
				//cuando haya un cambio en la variable "toolList", entonces se ejecuta estaa funcion
				$scope.$watch('toolList', function() {
					 $('.collapsible').collapsible();
				}, true);
			});
			

    	
		};
	$scope.populateToolPanel();
		
});


angular.element(document).ready(function() {
	angular.bootstrap(document.getElementById("toolPanel"), ['toolApp']);
});
