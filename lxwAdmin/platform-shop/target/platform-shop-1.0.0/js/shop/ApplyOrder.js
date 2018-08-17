$(function () {
    let shippingStatus = getQueryString("shippingStatus");
    let payStatus = getQueryString("payStatus");
    let orderStatus = getQueryString("orderStatus");
    let orderType = getQueryString("orderType");
    let url = '../order/listing';
    if (shippingStatus) {
        url += '?shippingStatus=' + shippingStatus;
    }
    if (payStatus) {
        url += '?payStatus=' + payStatus;
    }
    if (orderStatus) {
        url += '?orderStatus=' + orderStatus;
    }
    if (orderType) {
        url += '?orderType=' + orderType;
    }
    $("#jqGrid").jqGrid({
        url: url,
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
            {label: '申请单号', name: 'orderSn', index: 'order_sn', width: 120},
            {label: '订单编号', name: 'orderNo', index: 'order_no', width: 120},
            {label: '申请客户', name: 'clientName', index: 'client_name', width: 80},
            {label: '联系方式', name: 'mobile', index: 'mobile', width: 80},
            {label: '申请类型', name: 'applyTypes', index: 'apply_types', width: 80, formatter:function (value) {
                if(value=='1'){
                    return '采购';
                }else if(value=='2'){
                    return '租赁';
                }else if(value=='3'){
                    return '维修';
                }
                return value;
            }},
            {label: '需求是否明确', name: 'makeSure', index: 'make_sure', width: 80,formatter:function (value) {
                   if(value=='1'){
                       return '是';
                   } else  if(value=='2'){
                       return '否';
                   }
                    return value;
                }
            },
            {
                label: '处理状态', name: 'confirmStatus', index: 'confirm_status', width: 80, formatter: function (value) {
                    if (value == '501') {
                        return '订单已确认';
                    } else if (value == '502') {
                        return '订单未确认';
                    }
                    return value;
                }
            },
            // {label: '收货人', name: 'consignee', index: 'consignee', width: 80},
            // {label: '省', name: 'province', index: 'province', width: 20 },
            // {label: '地市', name: 'city', index: 'city', width: 20 },
            // {label: '区县', name: 'district', index: 'district', width: 20 },
            // {label: '收货地址', name: 'address', index: 'address', width: 80},
            // {label: '联系电话', name: 'mobile', index: 'mobile', width: 80},
            // {label: '补充说明', name: 'postscript', index: 'postscript', width: 80 },
            // {label: '快递公司Id', name: 'shippingId', index: 'shipping_id', width: 80 },
            /*     {label: '快递公司', name: 'shippingName', index: 'shipping_name', width: 80},*/
            //{label: '快递单号', name: 'shippingNo', index: 'shipping_No', width: 80},
            // {label: '付款方', name: 'payName', index: 'pay_name', width: 80},
            // {label: '快递费用', name: 'shippingFee', index: 'shipping_fee', width: 80},
            //{label: '实际支付金额', name: 'actualPrice', index: 'actual_price', width: 80},
            // {label: '', name: 'integral', index: 'integral', width: 80 },
            // {label: '', name: 'integralMoney', index: 'integral_money', width: 80 },
            //{label: '订单总价', name: 'orderPrice', index: 'order_price', width: 60},
            //{label: '商品总价', name: 'goodsPrice', index: 'goods_price', width: 60},
            {
                label: '申请时间', name: 'addTime', index: 'add_time', width: 120,
                formatter: function (value) {
                    return transDate(value);
                }
            },
            {label: '处理人', name: 'dispose', index: 'dispose', width: 80},
            {label: '处理时间', name: 'confirmTime', index: 'confirm_time', width: 80},
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
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

let vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        detail: false,
        details:false,
        showListDetails:false,
        title: null,
        order: {},
        shippings: [],
        integral:'',
        goodsTypeCoco: [],
        modelvList: [],
        modelbList: [],
        modelv: '',
        modelb: '',
        modelq: '',
        goodsTypeing:[],
        producted:[],
        username:'order.username',
        q: {
            orderSn: '',
            orderStatus: '',
            integral:''
        },
        ruleValidates:{
            time: [
                {required: true, message: '时间不能为空', trigger: 'blur'}
            ],
            integral: [
                {required: true, message: '数量不能为空,若客户未填写数量，此处需要填写数量，若客户已填写数量，并且此处已显示，不可更改，若更改忘记数量，可刷新网页', trigger: 'blur'}
            ],
            goodsPrice: [
                {required: true, message: '价格不能为空', trigger: 'blur'}
            ],
        },
    },
    methods: {
        query: function () {
            vm.reload();
        },
        getProduct:function () {
            $.get("../category/getproduct", function (r) {
                vm.producted = r.list;
            });
        },
        getGoods: function () {
            $.get("../goodsType/list", function (r) {
                vm.goodsTypeCoco = r.list;
            });
        },
        getGoodsTypeFor: function () {
            $.get("../provider/least", function (r) {
                vm.goodsTypeing = r.list;
            });
        },
        confirm: function (event) {
            let id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList=false;
            vm.title = "修改订单";
            vm.getGoods();
            vm.getInfo(id);
            let url =  "../order/confirm";
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.order),
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
        makeOrder: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.detail = false;
            vm.details=true;
            vm.getGoodsTypeFor();
            vm.getGoods();
            vm.getProduct();
            vm.title = "处理订单";
            $.get("../order/info/" + id, function (r) {
                vm.order = r.order;
                });
        },
        makeOrders: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.detail = false;
            vm.details=true;
            vm.getGoodsTypeFor();
            vm.getGoods();
            vm.getProduct();
            vm.title = "处理订单";
            $.get("../order/info/" + id, function (r) {
                vm.order = r.order;
            });

            var url ="../order/update";
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.order),
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
        sendGoods: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            $.get("../order/info/" + id, function (r) {
                vm.order = r.order;
                    if(r.order.confirmStatus==501){
                        alert("订单已生成,请到订单列表中修改订单!");
                        return
                    }
                    vm.showList = false;
                    vm.detail = false;
                    vm.details=false;
                    vm.getGoodsTypeFor();
                    vm.getGoods();
                    vm.getProduct();
                    vm.title = "生成订单";
                    $.get("../order/info/" + id, function (r) {
                        vm.order = r.order;
                    });
            });

        },
        getInfo: function(id){
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.title = "修改订单";
            $.get("../order/info/"+id, function (r) {
                vm.order = r.order;
            });
        },
        saveOrUpdate: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            var sos=vm.order.integral;
            var oso=vm.order.goodsPrice;
            $.get("../order/info/"+id, function (r) {
                vm.orders = r.order;
                var integral=r.order.integral;
                var goodsPrice=r.order.goodsPrice;
                if(sos==integral &&oso==goodsPrice){
                    var url ="../order/sendGoods";
                    $.ajax({
                        type: "POST",
                        url: url,
                        contentType: "application/json",
                        data: JSON.stringify(vm.order),
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
                }else {
                    alert('请勿修改数量或总预算！如果原始数据已忘记，请刷新网页');
                }
                });
        },
        reload: function (event) {
            vm.showList = true;
            vm.detail = false;
            vm.details=false;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'orderSn': vm.q.orderSn,
                    'orderStatus': vm.q.orderStatus,
                    'confirmStatus':vm.q.confirmStatus,
                    'orderNo':vm.q.orderNo,
                    'integral':vm.q.integral
                },
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
        },
        lookDetail: function (rowId) { //第三步：定义编辑操作
            vm.detail = true;
            vm.title = "详情";
            $.get("../order/info/" + rowId, function (r) {
                vm.order = r.order;
            });
        },
        printDetail: function (rowId) {
            openWindow({
                type: 2,
                title: '<i class="fa fa-print"></i>打印票据',
                content: '../shop/orderPrint.html?orderId=' + rowId
            })
        },
        max: function (){
            var modelv = this.modelv;
            if(modelv==""){
                return;
            }
            $.get("../goodsType/listMax?parentId=" + modelv, function (r) {
                vm.modelvList = r.list;
            });
        },
        minModel: function (){
            var modelb = this.modelb;
            if(modelb==""){
                return;
            }
            $.get("../goodsType/listMin?parentId=" + modelb, function (r) {
                vm.modelbList = r.list;
            });

        },
        handleReset: function (name) {
            handleResetForm(this, name);
        },
    },
    created: function () {
        let vue = this;
        $.get("../shipping/queryAll", function (r) {
            vue.shippings = r.list;
        });
    },



});