/**
 * Created by 1 on 2018/6/5.
 */
/*页面 全屏-添加*/
function duoweidu_edit(title,url){
    var index = layer.open({
        type: 2,
        title: title,
        content: url
    });
    layer.full(index);
}

/*添加或者编辑缩小的屏幕*/
function duoweidu_s_edit(title,url,w,h){
    layer_show(title,url,w,h);
}
/*-删除*/
function duoweidu_del(id,url){

    layer.confirm('确认要删除吗？',function(index){
        window.location.href=url;
    });
}

$('#btn-submit-add').click(function () {
    var data = $('#form-o2o-add').serialize();
    var url = SCOPE.add_url;
    $.post(url,data,function(result){
        if(result.code == 1) {
            layer.alert(result.msg, {icon:6}, function () {
                self.location=result.url;
            });
        }else if(result.code == 0) {
            layer.alert(result.msg, {icon:1});
        }
    },"JSON");
})

$('.listorder input').blur(function () {
    var id = $(this).attr('attr-id');
    var listorder = $(this).val();
    var postData = {
        'id':id,
        'listorder':listorder,
    }
    var url = SCOPE.listorder_url;
    $.post(url,postData,function(result){
        if(result.code == 1) {
            layer.alert(result.msg, {icon:6}, function () {
                self.location=result.data.jump_url;
            });
        }else if(result.code == 0) {
            layer.alert(result.msg, {icon:5});
        }
    },"JSON");
})

function add_save(form) {
    var data = $(form).serialize();
    console.log(data);
    // 将获取到的数据post给服务器
    url = $(form).attr('url');

    $.post(url,data,function(result){
        if(result.code == 1) {
            layer.alert(result.msg, {icon:6}, function () {
                self.location=result.url;
            });
        }else if(result.code == 0) {
            layer.alert(result.msg, {icon:5});
        }
    },"JSON");
}

$('.city').change(function () {
    var parent_id = $(this).val();
    var url = SCOPE.city_url;
    var postData = {'parent_id':parent_id};
    var city_html ="";
    $.post(url, postData, function (result) {
        if(result.status == 1){
            data = result.data;
            $(data).each(function(i){
                city_html+="<option value='"+this.name+"'>"+this.name+"</option>";
            })
            $('.region').html(city_html);
        }else if(result.status == 0){
            layer.alert(result.msg, {icon:5});
        }else if(result.status == -1){
            $('.region').html(" ");
        }
    },'JSON');
})