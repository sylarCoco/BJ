$(function () {
    $("#jqGrid").jqGrid({
        url: '../provider/list',
        datatype: "json",
        colModel: [{
            label: 'id', name: 'id', index: 'id', key: true, hidden: true
        },
            { label: '供应商编号', name: 'brandId', index: 'brandId', width: 80
            },
            {
            label: '供应商', name: 'username', index: 'username', width: 80
        },
            {
            label: '简称', name: 'abbreviation', index: 'abbreviation', width: 80,hidden:true
        }, {
                label: '供应商地区',
                name: 'enterpriseServiceArea',
                index: 'enterpriseServiceArea',
                width: 80,
                formatter: function (value) {
                    if (value == '1') {
                        return '北京';
                    }
                    if (value == '2') {
                        return '上海';
                    }
                    if (value == '3') {
                        return '香港';
                    }
                }
            },
            {
            label: '服务类别', name: 'serviceCategory', index: 'serviceCategory', width: 80,
                formatter: function (value) {
                    if (value == '1') {
                        return '办公用品';
                    }
                }
        },
            {
                label: '省', name: 'province', index: 'province', width: 80,hidden:true
            },
            {
                label: '市', name: 'town', index: 'town', width: 80,hidden:true
            },
            {
                label: '区', name: 'region', index: 'region', width: 80,hidden:true
            },

            {
                label: '服务状态', name: 'supplyStatus', index: 'supplyStatus', width: 80, formatter: function (value) {
                    if (value == '1') {
                        return '正常';
                    }
                    if (value == '2') {
                        return '不足';
                    }
                    if (value == '3') {
                        return '预警';
                    }
                },
            },

            {
                label: '合作状态', name: 'stateCooperation', index: 'stateCooperation', width: 80 , formatter: function (value) {
                    if (value == '1') {
                        return '在线';
                    }
                    if (value == '2') {
                        return '下线';
                    }
                },
            },
            {
                label: '创建人', name: 'creator', index: 'creator', width: 80
            },

            {
                label: '最后创建人', name: 'lastCreator', index: 'lastCreator', width: 80
            },

            {
            label: '经营范围', name: 'scopeOperation', index: 'scopeOfOperation', width: 80,hidden: true
        },{
            label: '经营资质', name: 'businessQualification', index: 'businessQualification', width: 80,hidden: true
        },{
            label: '供货类型', name: 'area', index: 'area', width: 80,hidden: true
        },{
            label: '供货地址', name: 'supplyAddress', index: 'supplyAddress', width: 80,hidden: true
        },
            {
                label: '联系人', name: 'person', index: 'person', width: 80,hidden: true
            },
            {
                label: '邮箱', name: 'email', index: 'email', width: 80,hidden: true
            },{
                label: '联系方式', name: 'contact', index: 'contact', width: 80,hidden: true
            },
            {
                label: '开户行', name: 'opengingBank', index: 'opengingBank', width: 80,hidden: true
            },
            {
                label: '开户名', name: 'accountName', index: 'accountName', width: 80,hidden: true
            },{
                label: '开户账号', name: 'accountNumber', index: 'accountNumber', width: 80,hidden: true
            },
            {
                label: '操作', width: 80, align: 'center', sortable: false, formatter: function (value, col, row) {
                    return '<button class="btn btn-outline btn-info" onclick="vm.lookDetail(' + row.id + ')"><i class="fa fa-info-circle"></i>&nbsp;查看详情</button>';
                }
            }
            ],
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
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
           /* $("#jqGrid").open(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});*/
        }
    });
});


var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        detail:false,
        title: null,
        provider: {},
        area: [],
        model2List: [],
        model3List: [],
        model2: '',
        model3: '',
        model4: '',
        ruleValidates: {
            username: [
                {required: true, message: '名称不能为空', trigger: 'blur'}
            ],
            contact: [
                {required: true, message: '名称不能为空', trigger: 'blur'}
            ],
            person: [
                {required: true, message: '名称不能为空', trigger: 'blur'}
            ],
            email: [
                {required: true, message: '邮箱不能为空', trigger: 'blur'},
                {type: 'email', message: '邮箱格式不正确', trigger: 'blur'}
            ],
            opengingBank: [
                {required: true, message: '开户行不能为空', trigger: 'blur'}
           ],
           accountName: [
                {required: true, message: '开户名不能为空', trigger: 'blur'}
            ],
            accountNumber: [
                {required: true, message: '开户账号不能为空', trigger: 'blur'}
            ],
        },
        q: {
            username: ''
        },
        userLevels: []
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.area = [];
            vm.getGoodsType();
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id);
            vm.getGoodsType();
        },
        saveOrUpdate: function (event) {
            var url = vm.provider.id == null ? "../provider/save" :"../provider/update";
            if(this.model3==0){
                alert("请选择供货地址");
                return
            }
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.provider),
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
                    url: "../provider/delete",
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
        exportUser: function () {
            exportFile('#rrapp', '../user/export', {'username': vm.q.username});
        },
        getInfo: function (id) {
            $.get("../provider/info/" + id, function (o) {
                vm.provider =o.product;
            });
        },
        reload: function (event) {
            vm.showList = true;
            vm.detail=false;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'username': vm.q.username},
                page: page,
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        lookDetail: function (rowId) { //第三步：定义编辑操作
            vm.detail = true;
            vm.title = "详情";
            $.get("../provider/info/" + rowId, function (r) {
                vm.provider = r.product;
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        },
        maxModel: function (){
            var model2 = this.model2;
            if(model2==""){
                return;
            }
            $.get("../provider/listMax?parentId=" + model2, function (r) {
                vm.model2List = r.list;
                });

        },
        minModel: function (){
            var model3 = this.model3;
            if(model3==""){
                return;
            }
            $.get("../provider/listMin?parentId=" + model3, function (r) {
                vm.model3List = r.list;
                });
        },
        getGoodsType: function () {



            $.get("../provider/area", function (r) {

                vm.area = r.list;

            });
        }

    }
});