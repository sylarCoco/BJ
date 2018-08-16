$(function () {
    $("#jqGrid").jqGrid({
        url: '../majormajorbillnew/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
            {label: '账单编号', name: 'billNumber', index: 'bill_number', width: 80},
            {label: '客户编号', name: 'custnumber', index: 'custnumber', width: 80},
            {label: '客户名称', name: 'clientName', index: 'client_name', width: 80},
            {label: '申请时间', name: 'applyTime', index: 'apply_time', width: 80,hidden:true},
            {label: '账单开始日期', name: 'bargainTime', index: 'bargain_time', width: 80},
            {label: '账单结束日期', name: 'accomplishTime', index: 'accomplish_time', width: 80},
            {label: '到期还款日', name: 'expireTime', index: 'expire_time', width: 80},
            {label: '完成时间', name: 'accomplishTime', index: 'accomplish_time', width: 80,hidden:true},
            {label: '账单金额', name: 'money', index: 'money', width: 80},

            /*		{label: '计费类型', name: 'moneyType', index: 'money_type', width: 80},
                    {label: '结算状态', name: 'settlementStatus', index: 'settlement_status', width: 80,formatter: function (value) {
                            if (value == '301') {
                                return '已结算';
                            } else if (value == '302') {
                                return '未结算';
                            }
                            return value;
                        }
                        },
                    {label: '用户', name: 'user', index: 'user', width: 80},
                    {label: '订单状态', name: 'orderStatus', index: 'order_status', width: 80,
                        formatter: function (value) {
                            if (value == '0') {
                                return '待付款';
                            } else if (value == '1') {
                                return '已付款';
                            } else if (value == '403') {
                                return '订单已完成';
                            }

                            return value;
                        }
                    },
                    {label: '账单编号', name: 'billNumber', index: 'bill_number', width: 80}*/
            {
                label: '操作', width: 160, align: 'center', sortable: false, formatter: function (value, col, row) {
                    return '<button class="btn btn-outline btn-info" onclick="vm.lookDetail(' + row.id + ')"><i class="fa fa-info-circle"></i>&nbsp;账单详情</button>';
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
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

let vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        detail:false,
        title: null,
        majormajorbillnew: {},
        ruleValidate: {
            name: [
                {required: true, message: '名称不能为空', trigger: 'blur'}
            ]
        },
        q: {
            orderSn: '',
            orderStatus: ''
        }
    },
    methods: {
        lookDetail: function (rowId) { //第三步：定义编辑操作
            openWindow({
                type: 2,
                title: '<i class="fa fa-print"></i>账单详情',
                content: '../shop/billDetails.html?orderId=' + rowId,
                top: true,
                area: ['100%', '100%'],

            })
        },
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.majorbillnew = {};
        },
        update: function (event) {
            let id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            let url = vm.majorbillnew.id == null ? "../majorbillnew/save" : "../majorbillnew/update";
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.majorbillnew),
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
            let ids = getSelectedRows();
            if (ids == null){
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../majorbillnew/delete",
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
        getInfo: function(id){
            $.get("../majorbillnew/info/"+id, function (r) {
                vm.majorbillnew = r.majorbillnew;
            });
        },
        reload: function (event) {
            vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'orderSn': vm.q.orderSn,
                    'orderStatus': vm.q.orderStatus},
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
        }
    }
});
