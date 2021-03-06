package io.renren.modules.blog.dao;

import io.renren.modules.blog.entity.BlogArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-30 13:57:41
 */
@Mapper
public interface BlogArticleDao extends BaseMapper<BlogArticleEntity> {
	
}
