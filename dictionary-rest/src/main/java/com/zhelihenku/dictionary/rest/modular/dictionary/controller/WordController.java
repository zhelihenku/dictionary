package com.zhelihenku.dictionary.rest.modular.dictionary.controller;

import com.zhelihenku.dictionary.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhelihenku.dictionary.rest.modular.dictionary.model.Word;
import com.zhelihenku.dictionary.rest.modular.dictionary.service.IWordService;

/**
 * 汉字控制器
 *
 * @author PhilWang
 * @Date 2018-08-20 20:12:19
 */
@Controller
@RequestMapping("/word")
public class WordController extends BaseController {

    private String PREFIX = "/dictionary/word/";

    @Autowired
    private IWordService wordService;

    /**
     * 跳转到汉字首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "word.html";
    }

    /**
     * 跳转到添加汉字
     */
    @RequestMapping("/word_add")
    public String wordAdd() {
        return PREFIX + "word_add.html";
    }

    /**
     * 跳转到修改汉字
     */
    @RequestMapping("/word_update/{wordId}")
    public String wordUpdate(@PathVariable Integer wordId, Model model) {
        return PREFIX + "word_edit.html";
    }

    /**
     * 获取汉字列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wordService.selectList(null);
    }

    /**
     * 新增汉字
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Word word) {
        wordService.insert(word);
        return SUCCESS_TIP;
    }

    /**
     * 删除汉字
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wordId) {
        wordService.deleteById(wordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改汉字
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Word word) {
        wordService.updateById(word);
        return SUCCESS_TIP;
    }

    /**
     * 汉字详情
     */
    @RequestMapping(value = "/detail/{wordId}")
    @ResponseBody
    public Object detail(@PathVariable("wordId") Integer wordId) {
        return wordService.selectById(wordId);
    }
}
