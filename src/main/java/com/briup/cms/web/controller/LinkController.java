package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/link")
@Api(description = "连接管理")
public class LinkController  {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/add")
    @ApiOperation("添加连接")
    public Message addLink(Link link){
        linkService.addLink(link);
        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation("更新连接")
    public Message updateLink(Link link){
        linkService.updateLink(link);
        return MessageUtil.success();
    }

    @GetMapping("/delete")
    @ApiOperation("删除连接")
    @ApiImplicitParam(name = "id",value = "连接id",required = true,paramType = "query",dataType = "int")
    public Message deleteLinkById(int id){
        linkService.deleteLinkById(id);
        return MessageUtil.success();
    }

    @GetMapping("/findLinkById")
    @ApiOperation("根据id查询连接")
    @ApiImplicitParam(name = "id",value = "连接id",required = true,paramType = "query",dataType = "int")
    public Message<Link> findLinkById(int id){
         return MessageUtil.success(linkService.findLinkById(id));
    }

    @GetMapping("/findAllLink")
    @ApiOperation("查询所有的连接")
    public Message<List<Link>> findAllLink(){
        return MessageUtil.success(linkService.findAllLink());
    }


}
