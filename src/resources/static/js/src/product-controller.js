console.log("Hello product-controller");
var productApp = angular.module('productApp',[]);

productApp.controller('productController',function($scope,$http){
//
//     //Crea un mapa que tiene como key el id del empleado y el valor(con nombre,apellidos,etc)
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
           //$("#grid").remove();
           $http.get("/products")
           .then(function(response){
              $scope.productList = response.data
                $scope.createProductMap($scope.productList)
          //cuando haya un cambio en la variable "taskList", entonces se ejecuta estaa funcion
               $scope.$watch('productList', function() {
                    //$('#name').editable();

               }, true);
           });


    }

    $scope.populatePanel();

    $scope.createProductMap = function(productList){
        $("#grid").shieldGrid({
                dataSource: {
                    data: productList,
                    schema: {
                        fields: {
                            id: { path: "id", type: String },
                            name: { path: "name", type: String },
                            netPrice: { path: "netPrice", type: Number },
                            finalPrice: { path: "finalPrice", type: Number },
                            status: { path: "status", type: String }
                        }
                    }
                },
                sorting: {
                    multiple: true
                },
                rowHover: false,
                columns: [
                    { field: "name", title: "Product Name", width: "200px" },
                    { field: "netPrice", title: "Net price", width: "40px" },
                    { field: "finalPrice", title: "Final Price" , width: "40px"},
                    { field: "status", title: "Status", width: "80px",editor: myCustomEditor },
                    {
                        width: "104px",
                        title: "Delete Column",
                        buttons: [
                            { cls: "deleteButton", commandName: "delete", caption: "<img src='http://www.prepbootstrap.com/Content/images/template/BootstrapEditableGrid/delete.png' /><span>Delete</span>" }
                        ]
                    }
                ],
                editing: {
                    enabled: true,
                    event: "click",
                    type: "cell",
                    confirmation: {
                        "delete": {
                            enabled: true,
                            template: function (item) {
                                $http.delete('/products/'+item.id)
                                    .success(function (data, status, headers) {
                                        console.log('sucess');
                                        $scope.populatePanel();
                                    })
                                    .error(function (data, status, header, config) {
                                        console.log('error');
                                    });

                            }
                        }
                    }
                },
                events:
                {
                    getCustomEditorValue: function (e) {

                        $scope.productList = this.dataSource.data;
                        e.value = $("#dropdown").swidget().value();
                        $("#dropdown").swidget().destroy();
                        $http.put('/products',$scope.productList)
                            .success(function (data, status, headers) {
                               console.log('sucess');
                               $("#grid").children().remove();
                               $scope.populatePanel();

                           })
                           .error(function (data, status, header, config) {
                               console.log('error');
                           });

                    }
                }
            });

            function myCustomEditor(cell, item) {
                $('<div id="dropdown"/>')
                    .appendTo(cell)
                    .shieldDropDown({
                        dataSource: {
                            data: ["INTRANSIT","STOCK","SELLING","SOLD"]
                        },
                        value: !item["transport"] ? null : item["transport"].toString()
                    }).swidget().focus();
            }

    }

});

//angular.element(document).ready(function() {
// angular.bootstrap(document.getElementById("productPanel"), ['productApp']);
// //angular.bootstrap(document.getElementById("newTaskPanel"), ['taskApp']);
//});