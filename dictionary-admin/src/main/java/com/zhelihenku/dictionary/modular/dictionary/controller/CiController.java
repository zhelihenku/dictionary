package com.zhelihenku.dictionary.modular.dictionary.controller;

import com.zhelihenku.dictionary.core.base.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.zhelihenku.dictionary.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhelihenku.dictionary.modular.dictionary.model.Ci;
import com.zhelihenku.dictionary.modular.dictionary.service.ICiService;

/**
 * 词语控制器
 *
 * @author PhilWang
 * @Date 2018-08-20 20:11:17
 */
@Controller
@RequestMapping("/ci")
public class CiController extends BaseController {

    private String PREFIX = "/dictionary/ci/";

    @Autowired
    private ICiService ciService;

    /**
     * 跳转到词语首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "ci.html";
    }

    /**
     * 跳转到添加词语
     */
    @RequestMapping("/ci_add")
    public String ciAdd() {
        return PREFIX + "ci_add.html";
    }

    /**
     * 跳转到修改词语
     */
    @RequestMapping("/ci_update/{ciId}")
    public String ciUpdate(@PathVariable Integer ciId, Model model) {
        Ci ci = ciService.selectById(ciId);
        model.addAttribute("item",ci);
        LogObjectHolder.me().set(ci);
        return PREFIX + "ci_edit.html";
    }

    /**
     * 获取词语列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return ciService.selectList(null);
    }

    /**
     * 新增词语
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Ci ci) {
        ciService.insert(ci);
        return SUCCESS_TIP;
    }

    /**
     * 删除词语
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer ciId) {
        ciService.deleteById(ciId);
        return SUCCESS_TIP;
    }

    /**
     * 修改词语
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Ci ci) {
        ciService.updateById(ci);
        return SUCCESS_TIP;
    }

    /**
     * 词语详情
     */
    @RequestMapping(value = "/detail/{ciId}")
    @ResponseBody
    public Object detail(@PathVariable("ciId") Integer ciId) {
        return ciService.selectById(ciId);
    }
}
