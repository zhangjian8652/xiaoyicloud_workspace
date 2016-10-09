/**
 * Created by zhangjian on 2016/1/4.
 */



$(function(){
    /*          $('#user-table').DataTable({
     "paging": true,
     "lengthChange": false,
     "searching": false,
     "ordering": true,
     "info": true,
     "autoWidth": true
     });*/
    var url = $path + "/admin/user/list";
    /*$("#user-table").DataTable( {
        bSort: false,
        serverSide: true, //服务端处理
        processing: true, //table在处理状态时显示友好信息
        //deferRender: true, //延迟渲染，可以提高初始化的速度
        stateSave: true, //保存状态
        searching: false,//关闭搜索
        ordering: false,//关闭排序
        //paginationType: full_numbers,//分页效果
        //lengthChange: false, //不可改变每页显示的大小
        displayLength: 10,//每页显示10条
        sPaginationType: "full_numbers",//全页，默认为two_buttons
        language: {
            /!*汉化*!/
            lengthMenu: "每页显示 _MENU_ 条记录",
            zeroRecords: "没有检索到数据",
            // info: "第 _START_ 条 到 _END_ 条用户&nbsp;&nbsp;&nbsp;共 _TOTAL_ 用户",
            info: ";共 _TOTAL_ 个用户",
            infoEmpty: "没有数据",
            infoFiltered: ("从 _MAX_ 条记录过滤"),
            processing: "正在加载...",
            paginate: {
                first: "首页",
                last: "尾页",
                previous: "上一页",
                next: "下一页"
            }
        },
        ajax: {
            url:url,
            type:'get'
        },
        columns: [
            { data: "no" },
            { data: "username" },
            { data: "sex" },
            { data: "email" },
            { data: "mobile" },
            { data: "id" }
        ],
     columnDefs:[
                 {
                     defaultContent:"<div align='center'><input id='btnDelete' class='btnDel btn btn-danger' type='button' value='编辑'/></div>",
                     targets:[5]
                 },
                {
                    // The `data` parameter refers to the data for the cell (defined by the
                    // `data` option, which defaults to the column being worked with, in
                    // this case `data: 0`.
                    render:function ( data, type, row ) {
                        return "<div align='center'><input id='btnDelete' class='btnDel btn btn-danger' type='button' value='编辑' data-id='" + data + "'/></div>";
                    },
                    targets: 5
                }
                ,
                {
                    visible: false,
                    targets: [ 2 ] //隐藏第六列，从第0列开始
                }
                ]
    } );*/

});