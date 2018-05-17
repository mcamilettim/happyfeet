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
 $scope.cargaChartBarra=function(){
	  var configChartDataBarras = {
		      type: 'bar',  // Specify your chart type here.
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
		      id: 'chartBarraDiv',
		      data: configChartDataBarras,
		      height: 400,
		      width: '100%'
		    });
 }
 $scope.cargaChartPieRespondidosPendientes=function(respondido,pendiente){
	  var  myConfig = {
   		  "type":"pie3d",
   		  "title":{
   		    "text":"Respondidos Vs Pendientes"
   		  },
   		  "series":[
   			  {
	    			  values : [respondido],
	    			  text: "Respondidos",
	    			  backgroundColor: '#50ADF5',
	    			},
	    			{
	    			  values: [pendiente],
	    			  text: "Pendientes",
	    			  backgroundColor: '#FF7965',
	    			  detached:true
	    			}
   		  ]
   		};
     zingchart.DEV.DEBOUNCESPEED = 50;
   	zingchart.render({ 
   		id : 'myChartRespondidosPendientes', 
   		data : myConfig, 
   		  height: '100%',
		      width: '100%'
   	});
 }
 $scope.cargaChartPieAprobacion=function(satisfecho,insatisfecho,tipo){
	    var myConfigAprobacion = {
	    		  "type":"pie3d",
	    		  "title":{
	    		    "text":"Aprobación de "+tipo.toUpperCase()
	    		  },
	    		  "series":[
	    			  {
		    			  values : [satisfecho],
		    			  text: "Satisfechos",
		    			  backgroundColor: '#50ADF5',
		    			},
		    			{
		    			  values: [insatisfecho],
		    			  text: "Insatisfechos",
		    			  backgroundColor: '#FF7965',
		    			  detached:true
		    			}
	    		  ]
	    		};
	    	zingchart.DEV.DEBOUNCESPEED = 50;
	    	zingchart.render({ 
	    		id : 'myChartConformidad', 
	    		data : myConfigAprobacion, 
	    		  height: '100%',
			      width: '100%'
	    	});
 }
 		$scope.cargaGraficos=function(){
	     $scope.cargaChartBarra();
		 if( $scope.cuestionario.tipo==="paciente"){
			 $scope.cargaChartPieRespondidosPendientes( $scope.cuestionario.total_cuestionario_paciente_respondido, $scope.cuestionario.total_cuestionario_paciente_pendiente);
			 $scope.cargaChartPieAprobacion($scope.cuestionario.total_paciente_satisfecho,$scope.cuestionario.total_paciente_insatisfecho,$scope.cuestionario.tipo);
		 }else{
			 $scope.cargaChartPieRespondidosPendientes( $scope.cuestionario.total_cuestionario_podologo_respondido, $scope.cuestionario.total_cuestionario_podologo_pendiente);
			 $scope.cargaChartPieAprobacion($scope.cuestionario.total_podologo_satisfecho,$scope.cuestionario.total_podologo_insatisfecho,$scope.cuestionario.tipo);
		 }

 }
	 
	  $scope.buscarCuestionario=function(){
		  $scope.setPromesaCuestionario().then(
		  function(response){		
			  $scope.cuestionario=response[0].data;
			  console.log( $scope.cuestionario);
			  $scope.cargaGraficos();  
		  })
     } 

	  //ejecucion
	  $scope.buscarCuestionario();
	   
  
})
 
