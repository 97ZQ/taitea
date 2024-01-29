package com.htht.business.source.service.impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htht.business.config.properties.AppProperties;
import com.htht.business.source.domain.Source;
import com.htht.business.source.mapper.SourceMapper;
import com.htht.business.source.service.ISourceService;
import com.htht.business.source.service.dto.SourcePageDto;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.exception.ServiceException;
import com.htht.common.utils.StringUtils;
import com.htht.common.utils.file.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SourceServiceImpl implements ISourceService {

    private final AppProperties appProperties;
    private final SourceMapper sourceMapper;

    @Override
    public void add(Source source) {
        int maxCount = 5;
        String code = null;
        for (int i = 0; i < maxCount; i++) {
            String noValidateCode = createCode(source);
            boolean isExistCode = validateIsExistCode(noValidateCode);
            if (!isExistCode) {
                code = noValidateCode;
                break;
            }
        }
        if (code == null) {
            throw new ServiceException("新增溯源数据失败");
        }
        source.setCode(code);

        int insertCount = sourceMapper.insert(source);
        if (insertCount != 1) {
            throw new ServiceException("新增溯源数据失败");
        }
    }

    private String createCode(Source source) {
        String prefix = "TS";
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return prefix + source.getType() + year + RandomStringUtils.randomNumeric(5);
    }

    private boolean validateIsExistCode(String code) {
        List<Source> sources = sourceMapper.selectList(Wrappers.lambdaQuery(Source.class).eq(Source::getCode, code));
        return sources.size() > 0;
    }

    @Override
    public void upd(Source source) {
        int updateCount = sourceMapper.updateById(source);
        if (updateCount != 1) {
            throw new ServiceException("更新溯源数据失败");
        }
    }

    @Override
    public void del(String sourceId) {
        int delCount = sourceMapper.deleteById(sourceId);
        if (delCount != 1) {
            throw new ServiceException("删除溯源数据失败");
        }
    }

    @Override
    public TableDataInfo<Source> page(SourcePageDto sourcePageDto) {
        IPage<Source> page = sourceMapper.selectVoPage(
            new Page<>(sourcePageDto.getPageNum(), sourcePageDto.getPageSize()),
            Wrappers.lambdaQuery(Source.class)
                .like(StringUtils.isNotEmpty(sourcePageDto.getName()), Source::getName, sourcePageDto.getName())
        );
        return TableDataInfo.build(page);
    }

    @Override
    public Source getById(String sourceId) {
        return sourceMapper.selectVoById(sourceId);
    }

    @Override
    public Source getByCode(String code) {
        List<Source> sources = sourceMapper.selectList(Wrappers.lambdaQuery(Source.class).eq(Source::getCode, code));
        if (sources.size() == 0) {
            return null;
        } else {
            return sources.get(0);
        }
    }

    @Override
    public void createQrCode(HttpServletResponse response, String content) {
        byte[] bytes = QrCodeUtil.generatePng(content, QrConfig.create());
        try {
            response.getOutputStream().write(bytes);
            FileUtils.setAttachmentResponseHeader(response, "qrCode.png");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("生成二维码错误：" + e.getMessage());
            throw new ServiceException("生成二维码错误");
        }
    }
}
