/**
 * 歇后语管理初始化
 */
var Xiehouyu = {
    id: "XiehouyuTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Xiehouyu.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '答案', field: 'answer', visible: true, align: 'center', valign: 'middle'},
            {title: '谜语', field: 'riddle', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'desc', visible: true, align: 'center', valign: 'middle'},
            {title: '状态（0：下架，1：上架）', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '删除标识（0：未删除，1：已删除）', field: 'isDelete', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Xiehouyu.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Xiehouyu.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加歇后语
 */
Xiehouyu.openAddXiehouyu = function () {
    var index = layer.open({
        type: 2,
        title: '添加歇后语',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/xiehouyu/xiehouyu_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看歇后语详情
 */
Xiehouyu.openXiehouyuDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '歇后语详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/xiehouyu/xiehouyu_update/' + Xiehouyu.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除歇后语
 */
Xiehouyu.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/xiehouyu/delete", function (data) {
            Feng.success("删除成功!");
            Xiehouyu.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("xiehouyuId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询歇后语列表
 */
Xiehouyu.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Xiehouyu.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Xiehouyu.initColumn();
    var table = new BSTable(Xiehouyu.id, "/xiehouyu/list", defaultColunms);
    table.setPaginationType("client");
    Xiehouyu.table = table.init();
});
