/**
 * 汉字管理初始化
 */
var Word = {
    id: "WordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Word.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '词', field: 'word', visible: true, align: 'center', valign: 'middle'},
            {title: '旧词', field: 'oldword', visible: true, align: 'center', valign: 'middle'},
            {title: '拼音', field: 'pinyin', visible: true, align: 'center', valign: 'middle'},
            {title: '笔画', field: 'strokes', visible: true, align: 'center', valign: 'middle'},
            {title: '偏旁', field: 'radicals', visible: true, align: 'center', valign: 'middle'},
            {title: '解释', field: 'explanation', visible: true, align: 'center', valign: 'middle'},
            {title: '更多', field: 'more', visible: true, align: 'center', valign: 'middle'},
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
Word.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Word.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加汉字
 */
Word.openAddWord = function () {
    var index = layer.open({
        type: 2,
        title: '添加汉字',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/word/word_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看汉字详情
 */
Word.openWordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '汉字详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/word/word_update/' + Word.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除汉字
 */
Word.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/word/delete", function (data) {
            Feng.success("删除成功!");
            Word.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询汉字列表
 */
Word.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Word.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Word.initColumn();
    var table = new BSTable(Word.id, "/word/list", defaultColunms);
    table.setPaginationType("client");
    Word.table = table.init();
});
