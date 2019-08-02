package io.renren.modules.blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-30 13:57:41
 */
@Data
@TableName("blog_article")
public class BlogArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 文章标签
	 */
	private String tag;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 文章内容
	 */
	private String content;
	/**
	 * 阅读次数
	 */
	private Integer readNumber;
	/**
	 * 次序(置顶功能)
	 */
	private Integer topNum;
	/**
	 * 创建用户
	 */
	private String createBy;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Date updateDate;
	/**
	 * 0正常1删除
	 */
	private Integer delFlag;

}
