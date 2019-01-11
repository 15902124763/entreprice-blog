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
            $("#blogTiletId").val("");
            $("#blogContentId").val("");
	    	$("#writeModal").modal('hide');
            $('#writeBlogSuccessId').modal('show');
            setTimeout(function(){
                $("#writeBlogSuccessId").modal("hide")
            },1200);
            $("#contentId").children().remove();
            homePage();
        },
	    error:function(data){
	    	
	    }
	});
}

//获取分页默认数据
var pageSize=10; //注意这是全局变量
var pageNum=1; //注意这是全局变量
function getDataDefault(){
    $.ajax({
        type:'get',
        url:host + "blog/blogList.html?pageNum="+pageNum+"&pageSize="+pageSize,
        cache:false,
        dataType:'json',
        success:function(data){
            var sb='<div><textarea id="blogCommentId" class="blog-Comment" placeholder="请输入正文（最多 100 个字）"></textarea></div>';
            var commment = '<div id="CommentContentId"></div>';
            if(data.success){
                var html = "";
                var list = data.result.list;
                $.each(list,function(key,val){
                    console.log(key,val,this);
                    html +="<div><h2><a class='blog-page-title'>"
                        +val.title
                        +"</a></h2>"
                        +"<div class='blog-page-content'>"
                        +val.content
                        +"</div>"
                        +"</div>"
                        +"<div>"
                        +"<button class='blog-agree' onclick='agreeWith("+val.id+")'>"
                        +"点赞&nbsp;" + val.agreeCount
                        +"</button>"
                        +"<button class='blog-agree blog-click' value='"+val.id+"'>"
                        +"评论"
                        +"</button>"
                        + "<div style='display:none'>"
						+ sb
						+ "<div><button class='btn blog-comment-button' value='"+val.id+"'>发布</button></div>"
						+"</div>"
                        +"</div>";
                });
                $("#contentId").append(html);
                pageNum+=1;
                getCommentBlog();//添加点击
                commentBlog();//添加点击
            }
        }
    });
}
function search(){
    var searchId = $("#searchId").val();
    $.ajax({
        type:'get',
        url:host + "/search/q?q="+searchId,
        cache:false,
        dataType:'json',
        success:function(data){
            var sb='<div><textarea id="blogCommentId" class="blog-Comment" placeholder="请输入正文（最多 100 个字）"></textarea></div>';
            var commment = '<div id="CommentContentId"></div>';
            if(data.success){
                var html = "";
                var list = data.content.list;
                $.each(list,function(key,val){
                    console.log(key,val,this);
                    html +="<div><h2><a class='blog-page-title'>"
                        +val.title
                        +"</a></h2>"
                        +"<div class='blog-page-content'>"
                        +val.content
                        +"</div>"
                        +"</div>"
                        +"<div>"
                        +"<button class='blog-agree' onclick='agreeWith("+val.id+")'>"
                        +"点赞&nbsp;" + val.agreeCount
                        +"</button>"
                        +"<button class='blog-agree blog-click' value='"+val.id+"'>"
                        +"评论"
                        +"</button>"
                        + "<div style='display:none'>"
                        + sb
                        + "<div><button class='btn blog-comment-button' value='"+val.id+"'>发布</button></div>"
                        +"</div>"
                        +"</div>";
                });
                $("#contentId").remove();
                $("#contentId").append(html);
                pageNum+=1;
                getCommentBlog();//添加点击
                commentBlog();//添加点击
            }
        }
    });
}

$(function(){
	$("#main").scroll(function(){
		//滚动条位置
		var scrollTop = $("#main").scrollTop();
		//可视窗口的高度
		var viewportHeight = $("#main").height();
		//整个页面可以滚动的高度
		var scrollHeight = $("#main")[0].scrollHeight;
		if(scrollTop+viewportHeight==scrollHeight){
            getDataDefault();
		}
	});
});

$(function () {
	getDataDefault();
});

//首页
function homePage() {
	pageNum = 1;
	pageSize = 10;
	getDataDefault();
}
//点赞
function agreeWith(obj) {
	var data = {'blogId':obj};
    $.ajax({
        type:"POST",
        url:host + "blog/agreeWith.html",
        data:JSON.stringify(data),
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        success:function(data){
            $('#agreeResultModelId').modal('show');
            setTimeout(function(){
                $("#agreeResultModelId").modal("hide")
            },1200);
            $("#contentId").children().remove();
            homePage();
        },
        error:function(data){

        }
    });
}

//获取评论
function getCommentBlog() {
    $(".blog-click").click(function(){
        var obj = $(this);
        var blogId = obj.val();
        obj.next('div').show();
        $.ajax({
            type:'get',
            url:host + "blog/getComment.html?blogId="+blogId,
            cache:false,
            dataType:'json',
            success:function(data){
            }
        });
    });
}

//评论
function commentBlog() {
    $(".blog-comment-button").click(function(){
        var obj = $(this);
        var objCommment = obj.parent().prev("div").children("textarea");
        var comment = objCommment.val();
        var blogId = obj.val();
        var data = {'blogId':blogId,"comment":comment};
        alert(obj.val());
        $.ajax({
            type:"POST",
            url:host + "blog/comment.html",
            data:JSON.stringify(data),
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            success:function(data){
            },
            error:function(data){

            }
        });
    });
}