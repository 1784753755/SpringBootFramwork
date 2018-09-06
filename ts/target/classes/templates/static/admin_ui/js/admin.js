function runlogin(){
	var obj=$('form').serializeArray();
	var name=obj['0'].value;
	var pwd=obj['1'].value;
	var verify=obj['2'].value;
	if($.trim(name)==""){
		layer.msg('帐号不能为空!',{icon:5,time:2000});
		$('input[name=user_name]').focus();
		return false;
	}
	if($.trim(pwd)==""){
		layer.msg('密码不能为空!',{icon:5,time:2000});
		$('input[name=user_pwd]').focus();
		return false;
	}
	if($.trim(verify)==""){
		layer.msg('验证码不能为空!',{icon:5,time:2000});
		$('input[name=verify]').focus();
		return false;
	}
	var login_url=$('form').attr('action');
	var data={'name':name,'pwd':pwd,'verify':verify};
	var layer_load="";
	$.ajax({
		'type':'post',
		'dataType':'json',
		'data':data,
		'url':login_url,
		'success':function(res){
			setTimeout(function(){
				layer.close(layer_load);
				if(res.code=="0"){
					layer.msg(res.msg,{icon:2,time:800});
					var src=$('#verify').attr('src');
					var src=src+'?'+Math.random();
					$('#verify').attr('src',src);
				}else{
					layer.msg('登录成功',{icon:1,time:800})
					window.location.href=res.url;
				}
			},800)
			
		},
		'error':function(){
			setTimeout(function(){
				layer.close(layer_load);
				layer.msg('请求出错咯',{icon:2,time:3000});
			},3000)

		},
		'beforeSend':function(){
			
			layer_load= layer.load(0,{shade:[0.1,'#fff'] });
		}

	})
	return false;
}

//添加商品
function goods_add(){
var obj=$('form').serializeArray();
console.log(obj);


   if($.trim(obj[0]['value'])==""){
   	layer.msg('商品名称不能为空',{icon:2,time:2000});
   	$("input[name='args[title]']").focus();
   return false;
   }
    if($.trim(obj[1]['value'])=="0"){
   	layer.msg('请选择商品分类',{icon:2,time:2000});

   return false;
   }
    if($.trim(obj[3]['name'])!="args[goods_label]"){
   	layer.msg('请选择商品标签',{icon:2,time:2000});
    return false;
   }
    if($.trim(obj[4]['value'])==""){
   	layer.msg('请输入商品单位',{icon:2,time:2000});
   	$("input[name='args[goods_unit]']").focus();	
   return false;
   }
    if($.trim(obj[10]['value'])=="0.00"){
   	layer.msg('请输入商品价格',{icon:2,time:2000});
   	$("input[name='args[goods_price]']").focus();
   return false;
   }
/*
   if(obj.length<14 || obj[14]['name']!="upload_img"){
   	layer.msg('请上传商品主图',{icon:2,time:2000});
   	return false;
   }
   if(obj.length<15 || obj[15]['name']=="args[is_top]"){
   	layer.msg('请上传商品相册',{icon:2,time:2000});
   return false;
   }*/

   var ajax_url=$('form').attr('action');

    $.ajax({
    	'type':'post',
    	'dataType':'json',
    	'data':obj,
    	'url':ajax_url,
    	'success':function(res){
    		console.log(res);
    		if(res.code=='0'){
    			layer.msg(res.msg,{icon:1,time:200})
    		}else{
    			layer.msg(res.msg,{icon:6,time:1000});
    			window.location.href=res.url;
    		}
    	},
    	'error':function(){
        layer.msg('请求出错咯',{icon:1,time:2000});
    	},
    	'beforeSend':function(){
    	// layer_load= layer.load(0,{shade:[0.1,'#fff'] });
    	}
    })
    return false;
}

//添加商品
function goods_edit(){
var obj=$('form').serializeArray();
   if($.trim(obj[1]['value'])==""){
   	layer.msg('商品名称不能为空',{icon:2,time:2000});
   	$("input[name='args[title]']").focus();
   return false;
   }
    if($.trim(obj[2]['value'])=="0"){
   	layer.msg('请选择商品分类',{icon:2,time:2000});

   return false;
   }
    if($.trim(obj[4]['name'])!="args[goods_label]"){
   	layer.msg('请选择商品标签',{icon:2,time:2000});
 
   return false;
   }
    if($.trim(obj[5]['value'])==""){
   	layer.msg('请输入商品单位',{icon:2,time:2000});
   	$("input[name='args[goods_unit]']").focus();	
   return false;
   }
      if($.trim(obj[10]['value'])=="0.00"){
        layer.msg('请输入单独购买价格',{icon:2,time:2000});
        $("input[name='args[goods_only_price]']").focus();
        return false;
    }
  
    if($.trim(obj[11]['value'])=="0.00"){
   	layer.msg('请输入商品价格',{icon:2,time:2000});
   	$("input[name='args[goods_price]']").focus();
   return false;
   }
   console.log(obj);
   /*
   if(obj.length<16 || obj[15]['name']!="file_upload"){
   	layer.msg('请上传商品主图',{icon:2,time:2000});
   	return false;
   }
   if(obj.length<17){
   	layer.msg('请上传商品相册',{icon:2,time:2000});
   return false;
   }*/
   var ajax_url=$('form').attr('action');
    $.ajax({
    	'type':'post',
    	'dataType':'json',
    	'data':obj,
    	'url':ajax_url,
    	'success':function(res){
    		if(res.code=='0'){
    			layer.msg(res.msg,{icon:1,time:2000})
    		}else{
    			layer.msg(res.msg,{icon:6,time:2000});
          setTimeout(function(){
              window.location.href=res.url;
          },2000)
    		

    		}


    	},
    	'error':function(){
      layer.msg('请求出错咯',{icon:1,time:2000});
    	},
    	'beforeSend':function(){
    		// layer_load= layer.load(0,{shade:[0.1,'#fff'] });
    	}
    })
    return false;

}

//编辑颜色属性
function edit_goods_color(goods_ids,res){
	var goods_id=goods_ids;
	var goods_url=$(res).attr('data_url');
	if($.trim(goods_id)==""){
		layer.mag('参数错误',{icon:1,time:2000});
		return false;
	}
    $.post(goods_url,{'id':goods_id},function(res){
    	console.log(res);
    },'json')
}
		

