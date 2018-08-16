$(function () {
    $("#jqGrid").jqGrid({
        url: '../category/list',
        datatype: "json",
        colModel:[{
            label: 'id', name: 'id', index: 'id', key: true, hidden: true
        },
            {
                label: '商品编号', name:'productid', index:'productid', width: 80
            },
            {
                label: '供应商', name:'username', index:'username', width: 80
            },{
            label: '商品名称', name:'name', index:'name', width: 80
        },{
            label: '商品类别', name:'goodstyle', index:'goodstyle', width: 80
        },
            {
                label: '品牌', name:'brand', index:'brand', width: 80
            }
            ,
            {
                label: '型号', name:'model', index:'model', width: 80
            },
            {
                label: '规格', name:'specification', index:'specification', width: 80
            },{
                label: '单价', name:'price', index:'price', width: 80
            },
            {
                label: '缩略图', name: 'imgurl', index: 'imgurl', width: 80, formatter: function (value) {
                    return transImg(value);

                }
            },
            {
                label: '操作', width: 80, align: 'center', sortable: false, formatter: function (value, col, row) {
                    return '<button class="btn btn-outline btn-info" onclick="vm.lookDetail(' + row.id + ')"><i class="fa fa-info-circle"></i>&nbsp;查看详情</button>';
                }
            }],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        detail:false,
        title: null,
        category: {
            imgurl: ''
        },
        erewr: {},
        goodsType: [],
        model2List: [],
        model3List: [],
        model2: '',
        model3: '',
        model4: '',
        username:'category.username',
        goodsTypeing:[],
        ids:'category.id',
        ruleValidate: {
            name: [
                {required: true, message: '商品名字不能为空', trigger: 'blur'}
            ],
            level: [
                {required: true, message: '级别不能为空', trigger: 'blur'}
            ]
        },
        q: {
            name: ''
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        getGoodsType: function () {
            $.get("../goodsType/list", function (r) {
                vm.goodsType = r.list;
            });
        },
        getGoodsTypeFor: function () {
            $.get("../provider/least", function (r) {
                vm.goodsTypeing = r.list;
            });
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.getGoodsTypeFor();
            vm.getGoodsType();
            vm.category={
                imgurl: ''
            };
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";
            vm.getGoodsTypeFor();
            vm.getGoodsType();
            vm.getInfo(id);
        },
        saveOrUpdate: function (event) {
            var url = vm.category.id == null ? "../category/save" : "../category/update";
            if(this.model3==0){
                alert("请选择商品类型");
                return
            }
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.category),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../category/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get("../category/info/" + id, function (r) {
                vm.category = r.category;
            });
        },
        reload: function (event) {
            vm.showList = true;
            vm.detail=false;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        },
        handleFormatError: function (file) {
            this.$Notice.warning({
                title: '文件格式不正确',
                desc: '文件 ' + file.name + ' 格式不正确，请上传 jpg 或 png 格式的图片。'
            });
        },
        handleMaxSize: function (file) {
            this.$Notice.warning({
                title: '超出文件大小限制',
                desc: '文件 ' + file.name + ' 太大，不能超过 2M。'
            });
        },
    lookDetail: function (rowId) { //第三步：定义编辑操作
        vm.detail = true;
        vm.title = "详情";
        $.get("../category/info/" + rowId, function (r) {
            vm.category = r.category;
        });
    },
        handleSuccessPicUrl: function (res, file) {
            vm.category.imgurl = file.response.url;

        },
        eyeImageUrl: function () {
            var url = vm.category.imgurl;
            eyeImage(url);
        },
        eyeImage: function (e) {
            eyeImage($(e.target).attr('src'));
        },
        maxModel: function (){
            var model2 = this.model2;
            if(model2==""){
                return;
            }
            $.get("../goodsType/listMax?parentId=" + model2, function (r) {
                vm.model2List = r.list;
            });
        },
        minModel: function (){
            var model3 = this.model3;
            if(model3==""){
                return;
            }
            $.get("../goodsType/listMin?parentId=" + model3, function (r) {
                vm.model3List = r.list;
            });

        }

    }
});
