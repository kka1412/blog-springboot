package io.renren.modules.blog.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.blog.dao.BlogTagDao;
import io.renren.modules.blog.entity.BlogTagEntity;
import io.renren.modules.blog.service.BlogTagService;


@Service("blogTagService")
public class BlogTagServiceImpl extends ServiceImpl<BlogTagDao, BlogTagEntity> implements BlogTagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String)params.get("key");

        IPage<BlogTagEntity> page = this.page(
                new Query<BlogTagEntity>().getPage(params),
                new QueryWrapper<BlogTagEntity>().like(StringUtils.isNotBlank(key),"tag_name", key)
        );

        return new PageUtils(page);
    }

}