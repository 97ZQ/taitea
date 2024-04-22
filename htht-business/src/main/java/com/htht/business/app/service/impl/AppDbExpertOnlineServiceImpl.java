package com.htht.business.app.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbExpertOnline;
import com.htht.business.app.dto.AppDbExpertOnlineDTO;
import com.htht.business.app.mapper.AppDbExpertOnlineMapper;
import com.htht.business.app.service.AppDbExpertOnlineService;
import com.htht.common.core.domain.PageQuery;
import com.htht.common.core.page.TableDataInfo;
import com.htht.common.helper.LoginHelper;
import com.htht.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*
*/
@Service
public class AppDbExpertOnlineServiceImpl extends ServiceImpl<AppDbExpertOnlineMapper, AppDbExpertOnline>
implements AppDbExpertOnlineService{

    @Override
    public TableDataInfo<AppDbExpertOnline> list(AppDbExpertOnlineDTO appDbExpertOnlineDTO) {
        Page<AppDbExpertOnline> page = this.lambdaQuery()
            .eq(StringUtils.isNotBlank(appDbExpertOnlineDTO.getQuestionType()), AppDbExpertOnline::getQuestionType, appDbExpertOnlineDTO.getQuestionType())
            .like(StringUtils.isNotBlank(appDbExpertOnlineDTO.getQuestionContent()), AppDbExpertOnline::getQuestionContent, appDbExpertOnlineDTO.getQuestionContent())
            .page(appDbExpertOnlineDTO.build());
        return TableDataInfo.build(page);
    }

    @Override
    public TableDataInfo<AppDbExpertOnline> userList() {
        Long userId = LoginHelper.getUserId();
        List<AppDbExpertOnline> list = this.lambdaQuery()
            .eq(AppDbExpertOnline::getUserId, userId)
            .list();
        return TableDataInfo.build(list);
    }

    @Override
    @Transactional
    public void reply(String replyContent, Long id) {
        AppDbExpertOnline one = this.lambdaQuery()
            .eq(AppDbExpertOnline::getId, id)
            .one();
        one.setReplyContent(replyContent);
        one.setReplyTime(DateTime.now());
        one.setStatus("1");
        this.updateById(one);
    }
}
