package com.zhelihenku.dictionary.modular.dictionary.controller;

import com.zhelihenku.dictionary.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.zhelihenku.dictionary.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhelihenku.dictionary.modular.dictionary.model.Idiom;
import com.zhelihenku.dictionary.modular.dictionary.service.IIdiomService;

/**
 * 成语控制器
 *
 * @author PhilWang
 * @Date 2018-08-20 20:11:53
 */
@Controller
@RequestMapping("/idiom")
public class IdiomController extends BaseController {

    private String PREFIX = "/dictionary/idiom/";

    @Autowired
    private IIdiomService idiomService;

    /**
     * 跳转到成语首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "idiom.html";
    }

    /**
     * 跳转到添加成语
     */
    @RequestMapping("/idiom_add")
    public String idiomAdd() {
        return PREFIX + "idiom_add.html";
    }

    /**
     * 跳转到修改成语
     */
    @RequestMapping("/idiom_update/{idiomId}")
    public String idiomUpdate(@PathVariable Integer idiomId, Model model) {
        Idiom idiom = idiomService.selectById(idiomId);
        model.addAttribute("item",idiom);
        LogObjectHolder.me().set(idiom);
        return PREFIX + "idiom_edit.html";
    }

    /**
     * 获取成语列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return idiomService.selectList(null);
    }

    /**
     * 新增成语
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Idiom idiom) {
        idiomService.insert(idiom);
        return SUCCESS_TIP;
    }

    /**
     * 删除成语
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer idiomId) {
        idiomService.deleteById(idiomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改成语
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Idiom idiom) {
        idiomService.updateById(idiom);
        return SUCCESS_TIP;
    }

    /**
     * 成语详情
     */
    @RequestMapping(value = "/detail/{idiomId}")
    @ResponseBody
    public Object detail(@PathVariable("idiomId") Integer idiomId) {
        return idiomService.selectById(idiomId);
    }
}
