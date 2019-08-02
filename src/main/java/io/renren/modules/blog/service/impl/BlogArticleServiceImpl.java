package io.renren.modules.blog.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.blog.dao.BlogArticleDao;
import io.renren.modules.blog.entity.BlogArticleEntity;
import io.renren.modules.blog.service.BlogArticleService;


@Service("blogArticleService")
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleDao, BlogArticleEntity> implements BlogArticleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String)params.get("key");

        IPage<BlogArticleEntity> page = this.page(
                new Query<BlogArticleEntity>().getPage(params),
                new QueryWrapper<BlogArticleEntity>().like(StringUtils.isNotBlank(key),"title", key)
        );

        return new PageUtils(page);
    }

}