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

function submitBlog(){
	var title = $.trim($("#blogTiletId").val());
	var content = $.trim($("#blogContentId").val());
	if(title=="" || title == '' || title == null){
		$("#blogTiletAlertId").text("标题内容不能为空！");
		$("#blogTiletAlertId").show();
		return;
	}
	$("#blogTiletAlertId").text("");
	$("#blogTiletAlertId").hide();
	if(content=="" || content == '' || content == null){
		$("#blogContentAlertId").text("正文内容不能为空！");
		$("#blogContentAlertId").show();
		return;
	}
	$("#blogContentAlertId").text("");
	$("#blogContentAlertId").hide();
	
	var blog = {"title":title,"content":content};
	$.ajax({
	    type:"POST",                      
	    url:host + "blog/submit.html",           
	    data:JSON.stringify(blog),   
	    dataType:"json", 
	    contentType:"application/json;charset=utf-8",
	    success:function(data){
	    	
	    },
	    error:function(data){
	    	
	    }
	});
}