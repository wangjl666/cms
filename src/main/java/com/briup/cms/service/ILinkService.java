package com.briup.cms.service;

import com.briup.cms.bean.Link;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface ILinkService {
    void addLink(Link link) throws CustomerException;

    void updateLink(Link link) throws CustomerException;

    void deleteLinkById(int id) throws CustomerException;

    Link findLinkById(int id) throws CustomerException;

    List<Link> findAllLink() throws CustomerException;

}
