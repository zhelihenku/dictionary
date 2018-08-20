/**
 * 初始化汉字详情对话框
 */
var WordInfoDlg = {
    wordInfoData : {}
};

/**
 * 清除数据
 */
WordInfoDlg.clearData = function() {
    this.wordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WordInfoDlg.set = function(key, val) {
    this.wordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WordInfoDlg.close = function() {
    parent.layer.close(window.parent.Word.layerIndex);
}

/**
 * 收集数据
 */
WordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('word')
    .set('oldword')
    .set('pinyin')
    .set('strokes')
    .set('radicals')
    .set('explanation')
    .set('more')
    .set('desc')
    .set('status')
    .set('isDelete')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
WordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/word/add", function(data){
        Feng.success("添加成功!");
        window.parent.Word.table.refresh();
        WordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/word/update", function(data){
        Feng.success("修改成功!");
        window.parent.Word.table.refresh();
        WordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wordInfoData);
    ajax.start();
}

$(function() {

});
