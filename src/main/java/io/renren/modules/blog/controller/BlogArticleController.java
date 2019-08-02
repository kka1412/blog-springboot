package io.renren.modules.blog.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.blog.entity.BlogArticleEntity;
import io.renren.modules.blog.service.BlogArticleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-30 13:57:41
 */
@RestController
@RequestMapping("blog/blogarticle")
public class BlogArticleController {
    @Autowired
    private BlogArticleService blogArticleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("generator:blogarticle:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = blogArticleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("generator:blogarticle:info")
    public R info(@PathVariable("id") Long id){
		BlogArticleEntity blogArticle = blogArticleService.getById(id);

        return R.ok().put("blogArticle", blogArticle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("blog:blogarticle:save")
    public R save(@RequestBody BlogArticleEntity blogArticle){
        blogArticle.setCreateDate(new Date());
        blogArticle.setUpdateDate(new Date());
		blogArticleService.save(blogArticle);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("blog:blogarticle:update")
    public R update(@RequestBody BlogArticleEntity blogArticle){
        blogArticle.setUpdateDate(new Date());
		blogArticleService.updateById(blogArticle);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("blog:blogarticle:delete")
    public R delete(@RequestBody Long[] ids){
		blogArticleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
