$(function () {
    let shippingStatus = getQueryString("shippingStatus");
    let payStatus = getQueryString("payStatus");
    let orderStatus = getQueryString("orderStatus");
    let orderType = getQueryString("orderType");
    let url = '../order/list';
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
            {label: '申请单号', name: 'orderNo', index: 'order_no', width: 100},
            {label: '会员', name: 'consignee', index: 'consignee', width: 80,hidden:true},
            {label: '供应商', name: 'username', index: 'user_name', width: 80,hidden:true},
            {
                label: '订单状态', name: 'orderStatus', index: 'order_status', width: 80, formatter: function (value) {
                   /* if (value == '0') {
                        return '待付款';
                    } else */if (value == '101') {
                        return '订单已取消';
                    } else if (value == '102') {
                        return '订单已删除';
                    } else if (value == '201') {
                        return '订单已付款';
                    } else if (value == '300') {
                        return '订单发货中';
                    } else if (value == '301') {
                        return '用户确认收货';
                    } else if (value == '401') {
                        return '订单已退款';
                    } else if (value == '402') {
                        return '订单已收货';
                    }
                    else if (value == '403') {
                        return '订单已完成';
                    }
                    return value;
                }
            },
            {label: '商品', name: 'commodity', index: 'commodity', width: 80,hidden:true},
          /*  {label: '商品名称', name: 'commodityName', index: 'commodity_name', width: 80},*/
            {label: '售卖单价', name: 'unitPrice', index: 'unit_price', width: 80,hidden:true},
            {label: '单价(含税)', name: 'nunitPrice', index: 'nunit_price', width: 80},
            {label: '数量', name: 'quantity', index: 'quantity', width: 80},
            {label: '客户', name: 'clientName', index: 'client_name', width: 80},
            {
                label: '下单时间', name: 'addTime', index: 'add_time', width: 80,
                formatter: function (value) {
                    return transDate(value);
                }
            },
            {label: '预计完成时间', name: 'time', index: 'time', width: 80,
                formatter: function (value) {
                    return transDate(value);
                   }
                },
            {label: '完成时间', name: 'creatingTime', index: 'creating_time', width: 80},
            {label: '订单金额', name: 'generalBudget', index: 'general_budget', width: 80},
            {label: '物流方式', name: 'modeDistribution', index: 'mode_distribution', width: 80,
                formatter: function (value) {
                    if (value == '1') {
                        return '自送';
                    } else if (value == '2') {
                        return '快递';
                    }
                    return value;
                }},

            {label: '联系方式', name: 'mobiles', index: 'mobiles', width: 80,hidden:true},
            {label: '配送人', name: 'person', index: 'person', width: 80,hidden:true},

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
                label: '操作', width: 160, align: 'center', sortable: false, formatter: function (value, col, row) {
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
        id:'',
        cons:'',
        showList: true,
        detail: false,
        title: null,
        order: {},
        shippings: [],
        goodsTypeCoco: [],
        modelvList: [],
        modelbList: [],
        modelv: '',
        modelb: '',
        modelq: '',
        goodsTypeing:[],
        orderStatus:'',
        producted:[],
        username:'order.username',
        q: {
            orderSn: '',
            orderStatus: ''
        }
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
            alert(value);
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
        sendGoods: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.getGoodsTypeFor();
            vm.getGoods();
            vm.getProduct();
            vm.title = "确认订单";
            $.get("../order/info/" + id, function (r) {
                vm.order = r.order;
                vm.showList=false;
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
            var url ="../order/sendGood";
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
        reload: function (event) {
            vm.showList = true;
            vm.detail = false;
            vm.new=false;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'orderSn': vm.q.orderSn,
                    'orderStatus': vm.q.orderStatus
                },
                page: page
            }).trigger("reloadGrid");
        },
        lookDetail: function (rowId) { //第三步：定义编辑操作
            vm.detail = true;
            vm.title = "详情";
            $.get("../order/info/" + rowId, function (r) {
                vm.order = r.order;
            });
        },
        updateing: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
              var url ="../order/sendGood";
                $.ajax({
                    type: "POST",
                    url: url,
                    contentType: "application/json",
                    data: JSON.stringify({
                        id:id,
                        orderStatus:101
                    }),
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
        updated: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            var url ="../order/sendGood";
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify({
                    id:id,
                    orderStatus:401
                }),
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
        updates: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            var url ="../order/sendGood";
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify({
                    id:id,
                    orderStatus:300
                }),
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
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            var url ="../order/sendGood";
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify({
                    id:id,
                    orderStatus:402
                }),
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

        }
    },
    created: function () {
        let vue = this;
        $.get("../shipping/queryAll", function (r) {
            vue.shippings = r.list;
        });
    },



});