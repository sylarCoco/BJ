$(function () {
    $("#jqGrid").jqGrid({
        url: '../user/list',
        datatype: "json",
        colModel: [{
            label: 'id', name: 'id', index: 'id', key: true, hidden: true
        }, {
            label: '会员名称', name: 'username', index: 'username', width: 80, hidden: true
        },


            {
                label: '客户编号', name: 'custnumber', index: 'custnumber', width: 80
            },
            /*{
            label: '会员密码', name: 'password', index: 'password', hidden: true
        },*/ /*{
            label: '性别', name: 'gender', index: 'gender', width: 40, hidden: true,formatter: function (value) {
                return transGender(value);
            }
        },*/ /*{
            label: '出生日期', name: 'birthday', index: 'birthday', width: 80, hidden: true,formatter: function (value) {
                return transDate(value);
            }
        }, {
            label: '注册时间', name: 'registerTime', index: 'register_time', width: 80,hidden: true, formatter: function (value) {
                return transDate(value);
            }
        }, {
            label: '最后登录时间', name: 'lastLoginTime', index: 'last_login_time', width: 80, hidden: true,formatter: function (value) {
                return transDate(value);
            }
        }, {
            label: '最后登录Ip', name: 'lastLoginIp', index: 'last_login_ip', hidden: true,
        }, {
            label: '会员等级', name: 'levelName',hidden: true, width: 40
        }, */{
            label: '微信名', name: 'nickname', index: 'nickname', width: 80, hidden: true
        }, {
            label: '手机号码', name: 'mobile', index: 'mobile', width: 120, hidden: true
        }, /*{
            label: '注册Ip', name: 'registerIp', index: 'register_ip', hidden: true
        } ,
            {
             label: '微信Id', name: 'weixinOpenid', index: 'weixin_openid', width: 80, hidden: true
           },*/
            {label: '客户名称', name: 'clientName', index: 'client_name', width: 80},
            {label: '结算方式', name: 'clearingForm', index: 'clearing_form', width: 80, hidden: true,formatter: function (value) {
                    if (value == '1') {
                        return '日结';
                    } else if (value == '2') {
                        return '周结';
                    } else if (value == '3') {
                        return '月结';
                    } else if (value == '4') {
                        return '年结';
                    }
                    return value;
                }},
            {label: '所属管理区', name: 'area', index: 'area', width: 80,formatter: function (value) {
                    if (value == '北京') {
                        return '北京';
                    }
                    return value;
                }},
            {label: '城市', name: 'city', index: 'city', width: 80,formatter: function (value) {
                    if (value == '北京区') {
                        return '北京市区';
                    }
                    return value;
                }},
            {label: '客户地址', name: 'address', index: 'address', width: 80, hidden: true},
            {label: '联系人', name: 'principal', index: 'principal', width: 80},
            {label: '联系人邮箱', name: 'email', index: 'email', width: 80},
            {label: '联系人电话', name: 'mobile', index: 'mobile', width: 80},
            {label: '财务负责人', name: 'financePrincipal', index: 'finance_principal', width: 80, hidden: true},
            {label: '邮箱', name: 'financeEmail', index: 'finance_email', width: 80, hidden: true},
            {label: '电话', name: 'financeMobile', index: 'finance_mobile', width: 80, hidden: true}, {
                label: '会员头像', name: 'avatar', index: 'avatar', width: 80,  hidden: true,formatter: function (value) {
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
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        detail:false,
        details:false,
        area: [],
        model2List: [],
        model3List: [],
        model2: '',
        model3: '',
        model4: '',
        user: {
            gender: 1
        },
        ruleValidate: {
            username: [
                {required: true, message: '会员名称不能为空', trigger: 'blur'}
            ],
            clientName: [
                {required: true, message: '公司名称不能为空', trigger: 'blur'}
            ],
            financeMobile: [
                {required: true, message: '手机不能为空', trigger: 'blur'}
            ],
            email: [
                {required: true, message: '邮箱不能为空', trigger: 'blur'},
                {type: 'email', message: '邮箱格式不正确', trigger: 'blur'}
            ],
            financeEmail: [
                {required: true, message: '邮箱不能为空', trigger: 'blur'},
                {type: 'email', message: '邮箱格式不正确', trigger: 'blur'}
            ],
            peopleName: [
                {required: true, message: '用于客户在小程序、应用、网站等前端登录,中英文均可,不可重复注册,如需修改请通知客户', trigger: 'blur'},
            ],
            contactMobile: [
                {required: true, message: '可用于接收初始密码和找回密码,请填写正确', trigger: 'blur'},
            ],
            mangeName: [
                {required: true, message: '客户侧账号管理人姓名', trigger: 'blur'},
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
            vm.details=false;
            vm.detail=false;
            vm.title = "新增";
            vm.user = {gender: '1'};
            vm.userLevels = [];
            vm.getGoodsType();
            this.getUserLevels();
        },
        getGoodsType: function () {
            $.get("../provider/area", function (r) {
                vm.area = r.list;
            });
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.detail=false;
            vm.details=true;
            vm.title = "修改";
            vm.getInfo(id);
            this.getUserLevels();
            vm.getGoodsType();
        },
        saveOrUpdate: function (event) {
            var url = vm.user.id == null ? "../user/save" : "../user/update";
            if(this.model3==0){
                alert("请选择客户地址");
                return
            }
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.user),
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
                    url: "../user/delete",
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
        coupon: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            openWindow({
                title: '优惠券',
                type: 2,
                content: '../shop/usercoupon.html?userId=' + id
            })
        },
        address: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            openWindow({
                title: '收获地址',
                type: 2,
                content: '../shop/address.html?userId=' + id
            })
        },
        shopCart: function () {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            openWindow({
                title: '购物车',
                type: 2,
                content: '../shop/cart.html?userId=' + id
            })
        },
        getInfo: function (id) {
            $.get("../user/info/" + id, function (r) {
                vm.user = r.user;
            });
        },
        /**
         * 获取会员级别
         */
        getUserLevels: function () {
            $.get("../userlevel/queryAll", function (r) {
                vm.userLevels = r.list;
            });
        },
        reload: function (event) {
            vm.showList = true;
            vm.detail=false;
            vm.details=false;
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
        handleReset: function (name) {
            handleResetForm(this, name);
        },
        lookDetail: function (rowId) { //第三步：定义编辑操作
            vm.detail = true;
            vm.title = "详情";
            $.get("../user/infos/" + rowId, function (r) {
                vm.user = r.user;
            });
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
    }
});