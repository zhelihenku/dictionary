/**
 * 初始化成语详情对话框
 */
var IdiomInfoDlg = {
    idiomInfoData : {}
};

/**
 * 清除数据
 */
IdiomInfoDlg.clearData = function() {
    this.idiomInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IdiomInfoDlg.set = function(key, val) {
    this.idiomInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IdiomInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IdiomInfoDlg.close = function() {
    parent.layer.close(window.parent.Idiom.layerIndex);
}

/**
 * 收集数据
 */
IdiomInfoDlg.collectData = function() {
    this
    .set('id')
    .set('word')
    .set('pinyin')
    .set('abbreviation')
    .set('example')
    .set('derivation')
    .set('explanation')
    .set('desc')
    .set('status')
    .set('isDelete')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
IdiomInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/idiom/add", function(data){
        Feng.success("添加成功!");
        window.parent.Idiom.table.refresh();
        IdiomInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.idiomInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IdiomInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/idiom/update", function(data){
        Feng.success("修改成功!");
        window.parent.Idiom.table.refresh();
        IdiomInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.idiomInfoData);
    ajax.start();
}

$(function() {

});
