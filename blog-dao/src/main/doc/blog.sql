

DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL COMMENT '用户id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '正文',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `agree_count` int(10) unsigned zerofill DEFAULT NULL COMMENT '统计评论',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_blog_agree_with`;
CREATE TABLE `t_blog_agree_with` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog_id` bigint(20) NOT NULL COMMENT '博客id',
  `uid` varchar(255) NOT NULL COMMENT '用户id',
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog_id` bigint(20) NOT NULL,
  `uid` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `agree_count` int(255) unsigned zerofill DEFAULT NULL COMMENT '统计评论点赞',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
