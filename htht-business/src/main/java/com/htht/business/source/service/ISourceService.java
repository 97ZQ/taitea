package com.htht.business.source.service;

import com.htht.business.source.domain.Source;
import com.htht.business.source.service.dto.SourcePageDto;
import com.htht.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletResponse;

public interface ISourceService {

    void add(Source source);

    void upd(Source source);

    void del(String sourceId);

    TableDataInfo<Source> page(SourcePageDto sourcePageDto);

    Source getById(String sourceId);

    Source getByCode(String code);

    void createQrCode(HttpServletResponse response, String content);

}
