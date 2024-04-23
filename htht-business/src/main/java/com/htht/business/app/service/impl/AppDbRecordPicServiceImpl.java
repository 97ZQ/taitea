package com.htht.business.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.business.app.domain.AppDbRecordPic;
import com.htht.business.app.mapper.AppDbRecordPicMapper;
import com.htht.business.app.service.AppDbRecordPicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppDbRecordPicServiceImpl extends ServiceImpl<AppDbRecordPicMapper, AppDbRecordPic> implements AppDbRecordPicService {
}
