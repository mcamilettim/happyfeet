angular.module('myAppChart', [])
.controller('UserCtrlChart', function($rootScope,$scope, $http,$q) {
 $scope.showLoading = true;
 

 
 $scope.obtenerCuestionario = function(){
	 var url_string = window.location.href
	var url = new URL(url_string);
	var id = url.searchParams.get("id");
	 return $http.get('/servicesCuestionario/getCuestionario?id='+id);
}
 
 
 $scope.setPromesaCuestionario=function(){	   
	  var promesas=[];
	  promesas.push($scope.obtenerCuestionario());
	  return $q.all(promesas);
}
  
	 
	  $scope.buscarCuestionario=function(){
		  $scope.setPromesaCuestionario().then(
		  function(response){		
			  $scope.cuestionario=response[0].data;
			  $scope.cargaChart();
		  })
     } 
	 
	  $scope.buscarCuestionario();
	  
	  $scope.cargaChart=function(){
		  var chartData = {
			      type: 'bar',  // Specify your chart type here.
			      /*   "scale-y":{
			            "values":"0:1:2:3",
			            "decimals":0
			        },/*/
			      "scale-x":{     
			          "labels":["Preguna Uno","Pregunta dos","Pregunta Tres"]
			        },
			      title: {
			        text: $scope.cuestionario.nombre,
			        "font-size":15,
			        "width": '60%'// Adds a title to your chart
			      },
			      legend: {}, // Creates an interactive legend
			      series: [  // Insert your series data here.
			          {  "text":"SI", values: [$scope.cuestionario.total_respuesta_uno_si, $scope.cuestionario.total_respuesta_dos_si, $scope.cuestionario.total_respuesta_tres_si]},
			          {  "text":"NO",values: [$scope.cuestionario.total_respuesta_uno_no, $scope.cuestionario.total_respuesta_dos_no, $scope.cuestionario.total_respuesta_tres_no]}
			      ]
			    };
		  zingchart.DEV.DEBOUNCESPEED = 50;
			    zingchart.render({ // Render Method[3]
			      id: 'chartDiv',
			      data: chartData,
			      height: 400,
			      width: '100%'
			    });
		  
}
    
  
})
 

