
	$(document).ready(function(){
		$(".deleteElement").click(function(){
			var url = $(this).data("delete-url");
			BootstrapDialog.show({
			    title: $(this).data("dialog-title"),
			    message: $(this).data("dialog-message"),
			    type: BootstrapDialog.TYPE_WARNING,
			    buttons: [{
	                label: $(this).data("dialog-yes-button"),
	                cssClass: 'btn-success',
	                action: function(dialogRef){
	                	window.location.replace(url);
	                }
	            }, {
	                label: $(this).data("dialog-no-button"),
	                cssClass: 'btn-warning',
	                action: function(dialogItself){
	                	dialogItself.close();
	                }
	            }]
			});
		});
	});