package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: tensquare_parent
 * @description:标签控制类
 * @author: cf
 * @create: 2019-06-11 17:16
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
@RefreshScope
public class LabelController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true,StatusCode.OK,  "保存成功");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,  "查询成功", labelService.findAll());
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String id){
        Label label = labelService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true,StatusCode.OK,  "修改成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId){
        labelService.delete(labelId);
        return new Result(true,StatusCode.OK,  "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        return new Result(true,StatusCode.OK,  "查询成功", labelService.findSearch(label));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@PathVariable int page, @PathVariable int size, @RequestBody Label label){
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true,StatusCode.OK, "查询成功",
                new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
    }
}
