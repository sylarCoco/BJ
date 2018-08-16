$(function () {
    $("#jqGrid").jqGrid({
        url: '../order/info/',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
            {label: '账单编号', name: 'billNumber', index: 'bill_number', width: 80},
            {label: '客户编号', name: 'custnumber', index: 'custnumber', width: 80},
            {label: '客户名称', name: 'clientName', index: 'client_name', width: 80},
            {label: '申请时间', name: 'applyTime', index: 'apply_time', width: 80,hidden:true},
            {label: '账单开始日期', name: 'bargainTime', index: 'bargain_time', width: 80},
            {label: '账单结束日期', name: 'bargainTime', index: 'bargain_time', width: 80},
            {label: '到期还款日', name: 'bargainTime', index: 'bargain_time', width: 80},
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
        ],
        viewrecords: true,
        height: 35,
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

$(function () {
    $("#jqGrid1").jqGrid({
        url: '../order/listed',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
            {label: '订单编号', name: 'billNumber', index: 'bill_number', width: 80},
            {label: '客户编号', name: 'custnumber', index: 'custnumber', width: 80},
            {label: '客户名称', name: 'clientName', index: 'client_name', width: 80},
            {label: '申请时间', name: 'applyTime', index: 'apply_time', width: 80,hidden:true},
            {label: '账单开始日期', name: 'bargainTime', index: 'bargain_time', width: 80},
            {label: '账单结束日期', name: 'bargainTime', index: 'bargain_time', width: 80},
            {label: '到期还款日', name: 'bargainTime', index: 'bargain_time', width: 80},
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
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager1",
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
            $("#jqGrid1").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});
let vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        billnew: {},
    },
    methods: {
        reload: function (event) {
            vm.showList = true;
            let page = $("#jqGrid1").jqGrid('getGridParam', 'page');
            $("#jqGrid1").jqGrid('setGridParam', {
                postData: {
                    'orderSn': vm.q.orderSn,
                    'orderStatus': vm.q.orderStatus
                },
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
        },
    }
});


