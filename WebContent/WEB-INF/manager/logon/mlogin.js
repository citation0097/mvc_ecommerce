$(document).ready(function(){
	$("#login").click(function(){
		var query = {id: $("#id").val(), passwd:$("#passwd").val()};
		$.ajax({
			type: "POST",
			url: "managerLoginPro.do",
			data: query,
			success: function(data){
				window.location.href("managerMain.do");
			}
		})
		
	})
	
	$("#logout").click(function(){
		$.ajax({
			type: "POST",
			url: "managerLogout.do",
			data: query,
			success: function(data){
				window.location.href("managerMain.do");
			}
		})
		
	})
	
	
	
})