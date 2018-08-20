/**
 * 初始化词语详情对话框
 */
var CiInfoDlg = {
    ciInfoData : {}
};

/**
 * 清除数据
 */
CiInfoDlg.clearData = function() {
    this.ciInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CiInfoDlg.set = function(key, val) {
    this.ciInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CiInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CiInfoDlg.close = function() {
    parent.layer.close(window.parent.Ci.layerIndex);
}

/**
 * 收集数据
 */
CiInfoDlg.collectData = function() {
    this
    .set('id')
    .set('ci')
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
CiInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ci/add", function(data){
        Feng.success("添加成功!");
        window.parent.Ci.table.refresh();
        CiInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ciInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CiInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ci/update", function(data){
        Feng.success("修改成功!");
        window.parent.Ci.table.refresh();
        CiInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ciInfoData);
    ajax.start();
}

$(function() {

});
