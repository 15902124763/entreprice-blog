function writeBlog(){
	$("#writeModal").modal("show");
}
//校验输入帖子标题
$(function(){
	$("#blogTiletId").keyup(function(){
		var len = $(this).val().length;
		if(len > 20){
			var num = len - 20;
			var msg = "标题超过"+num+"个字";
			$("#blogTiletAlertId").text(msg);
			$("#blogTiletAlertId").show();
		}else{
			$("#blogTiletAlertId").text("");
			$("#blogTiletAlertId").hide(); 
		}
	});
});
//校验输入帖子内容
$(function(){
	  $("#blogContentId").keyup(function(){
	   var len = $(this).val().length;
	   if(len > 100){
		   var num = len - 100;
		   var msg = "正文超过"+num+"个字";
		   $("#blogContentAlertId").text(msg);
		   $("#blogContentAlertId").show();
	   }else{
		   $("#blogContentAlertId").text("");
		   $("#blogContentAlertId").hide(); 
	   }
	  });
});