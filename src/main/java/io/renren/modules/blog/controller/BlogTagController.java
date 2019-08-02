package io.renren.modules.blog.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.blog.entity.BlogTagEntity;
import io.renren.modules.blog.service.BlogTagService;
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
@RequestMapping("blog/blogtag")
public class BlogTagController {
    @Autowired
    private BlogTagService blogTagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("blog:blogtag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = blogTagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("blog:blogtag:info")
    public R info(@PathVariable("id") Integer id){
		BlogTagEntity blogTag = blogTagService.getById(id);

        return R.ok().put("blogTag", blogTag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("blog:blogtag:save")
    public R save(@RequestBody BlogTagEntity blogTag){
		blogTagService.save(blogTag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("blog:blogtag:update")
    public R update(@RequestBody BlogTagEntity blogTag){
		blogTagService.updateById(blogTag);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("blog:blogtag:delete")
    public R delete(@RequestBody Integer[] ids){
		blogTagService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
