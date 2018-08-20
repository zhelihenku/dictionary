package com.zhelihenku.dictionary.rest.modular.dictionary.controller;

import com.zhelihenku.dictionary.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhelihenku.dictionary.rest.modular.dictionary.model.Xiehouyu;
import com.zhelihenku.dictionary.rest.modular.dictionary.service.IXiehouyuService;

/**
 * 歇后语控制器
 *
 * @author PhilWang
 * @Date 2018-08-20 20:12:33
 */
@Controller
@RequestMapping("/xiehouyu")
public class XiehouyuController extends BaseController {

    private String PREFIX = "/dictionary/xiehouyu/";

    @Autowired
    private IXiehouyuService xiehouyuService;

    /**
     * 跳转到歇后语首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "xiehouyu.html";
    }

    /**
     * 跳转到添加歇后语
     */
    @RequestMapping("/xiehouyu_add")
    public String xiehouyuAdd() {
        return PREFIX + "xiehouyu_add.html";
    }

    /**
     * 跳转到修改歇后语
     */
    @RequestMapping("/xiehouyu_update/{xiehouyuId}")
    public String xiehouyuUpdate(@PathVariable Integer xiehouyuId, Model model) {
        return PREFIX + "xiehouyu_edit.html";
    }

    /**
     * 获取歇后语列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return xiehouyuService.selectList(null);
    }

    /**
     * 新增歇后语
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xiehouyu xiehouyu) {
        xiehouyuService.insert(xiehouyu);
        return SUCCESS_TIP;
    }

    /**
     * 删除歇后语
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer xiehouyuId) {
        xiehouyuService.deleteById(xiehouyuId);
        return SUCCESS_TIP;
    }

    /**
     * 修改歇后语
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xiehouyu xiehouyu) {
        xiehouyuService.updateById(xiehouyu);
        return SUCCESS_TIP;
    }

    /**
     * 歇后语详情
     */
    @RequestMapping(value = "/detail/{xiehouyuId}")
    @ResponseBody
    public Object detail(@PathVariable("xiehouyuId") Integer xiehouyuId) {
        return xiehouyuService.selectById(xiehouyuId);
    }
}
