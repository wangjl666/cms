package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/delete")
    @ApiOperation("删除连接")
    public Message deleteLinkById(int id){
        linkService.deleteLinkById(id);
        return MessageUtil.success();
    }

    @PostMapping("/findLinkById")
    @ApiOperation("根据id查询连接")
    public Message<Link> findLinkById(int id){
        Link link =linkService.findLinkById(id);
         return MessageUtil.success(link);
    }

    @PostMapping("/findAllLink")
    @ApiOperation("查询所有的连接")
    public Message<List<Link>> findAllLink(){
        return MessageUtil.success(linkService.findAllLink());
    }


}
