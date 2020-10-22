$(document).ready(function () {
	
        $(".sumarItem").on("click",function () {
        	
        	var idItem = $(this).attr('id');
        	        	        	
        	$.ajax({
				type : "PUT",
				url : "/api/carrito/sumarAlItem/"+ idItem,
		        cache: false,
		        timeout: 600000,
				success : function(result) {
										
					var id = '#input-number-'+idItem;
					var idItemP = $(id).text();
															
					$(id).html(parseInt(idItemP) + 1);
					
					$("#subtotal").html('$'+result);

				},
				error : function(e) {
					alert("Error!");
				}
			}); 

        });
        
        $(".restarItem").on("click",function () {
        	
        	var idItem = $(this).attr('id');
        	
        	$.ajax({
				type : "PUT",
				url : "/api/carrito/restarAlItem/"+ idItem,
		        cache: false,
		        timeout: 600000,
				success : function(result) {
					
					var id = '#input-number-'+idItem;
					var idItemP = $(id).text();
															
					$(id).html(parseInt(idItemP) - 1);
					
					$("#subtotal").html('$'+result);
					
				},
				error : function(e) {
					alert("Error!");
				}
			});

        });
            
});