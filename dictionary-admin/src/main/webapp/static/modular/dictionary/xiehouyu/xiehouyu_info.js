/**
 * 初始化歇后语详情对话框
 */
var XiehouyuInfoDlg = {
    xiehouyuInfoData : {}
};

/**
 * 清除数据
 */
XiehouyuInfoDlg.clearData = function() {
    this.xiehouyuInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
XiehouyuInfoDlg.set = function(key, val) {
    this.xiehouyuInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
XiehouyuInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
XiehouyuInfoDlg.close = function() {
    parent.layer.close(window.parent.Xiehouyu.layerIndex);
}

/**
 * 收集数据
 */
XiehouyuInfoDlg.collectData = function() {
    this
    .set('id')
    .set('answer')
    .set('riddle')
    .set('desc')
    .set('status')
    .set('isDelete')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
XiehouyuInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xiehouyu/add", function(data){
        Feng.success("添加成功!");
        window.parent.Xiehouyu.table.refresh();
        XiehouyuInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xiehouyuInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
XiehouyuInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/xiehouyu/update", function(data){
        Feng.success("修改成功!");
        window.parent.Xiehouyu.table.refresh();
        XiehouyuInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.xiehouyuInfoData);
    ajax.start();
}

$(function() {

});
