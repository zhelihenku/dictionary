/**
 * 词语管理初始化
 */
var Ci = {
    id: "CiTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Ci.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '词', field: 'ci', visible: true, align: 'center', valign: 'middle'},
            {title: '解释', field: 'explanation', visible: true, align: 'center', valign: 'middle'},
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
Ci.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Ci.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加词语
 */
Ci.openAddCi = function () {
    var index = layer.open({
        type: 2,
        title: '添加词语',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/ci/ci_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看词语详情
 */
Ci.openCiDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '词语详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/ci/ci_update/' + Ci.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除词语
 */
Ci.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/ci/delete", function (data) {
            Feng.success("删除成功!");
            Ci.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("ciId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询词语列表
 */
Ci.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Ci.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Ci.initColumn();
    var table = new BSTable(Ci.id, "/ci/list", defaultColunms);
    table.setPaginationType("client");
    Ci.table = table.init();
});
