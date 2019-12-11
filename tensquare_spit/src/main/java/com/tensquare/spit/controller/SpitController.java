package com.tensquare.spit.controller;

import com.tensquare.spit.model.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import util.BaseExceptionHandler;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController extends BaseExceptionHandler {
    @Autowired
    private SpitService spitService;

    /**
     * 查询所有
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    /**
     * 根据Id查询
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(id));
    }

    /**
     * 增加
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit) {
        spitService.add(spit);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    /**
     * 修改
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@RequestBody Spit spit,@PathVariable String id) {
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result update(@PathVariable String id) {
        spitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /**
     * 根据上级Id查询吐槽列表（分页）
     * @param parentId
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "comment/{parentId}/{page}/{size}",method = RequestMethod.GET)
    public Result findByParentId(@PathVariable String parentId,@PathVariable int page,
                                 @PathVariable int size){
        Page<Spit> spits = spitService.findByParentId(parentId, page, size);
        return new Result(true,StatusCode.OK,"查询成功",
               new PageResult<Spit>(spits.getTotalElements(),spits.getContent()));
    }

    /**
     * 增加点赞
     * @param id
     */
    @RequestMapping(value = "/thumbup/{id}",method = RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id){
        spitService.updateThumbup(id);
        return new Result(true,StatusCode.OK,"点赞成功");
    }

}
