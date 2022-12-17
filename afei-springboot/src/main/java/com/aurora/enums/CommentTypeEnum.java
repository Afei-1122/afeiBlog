package com.aurora.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author aFei
 * 评论类型枚举
 */
@Getter
@AllArgsConstructor
public enum CommentTypeEnum {

    /**
     * 文章
     */
    ARTICLE(1, "文章", "/articles/"),

    /**
     * 留言
     */
    MESSAGE(2, "留言", "/message/"),

    /**
     * 关于我
     */
    ABOUT(3, "关于我", "/about/"),

    /**
     * 友链
     */
    LINK(4, "友链", "/friends/"),

    /**
     * 说说
     */
    TALK(5, "说说", "/talks/");

    /**
     * 状态
     */
    private final Integer type;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 路径
     */
    private final String path;

    /**
     * 获取评论路径
     *
     * @param type 类型
     * @return {@link String}
     */
    public static String getCommentPath(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.getType().equals(type)) {
                return value.getPath();
            }
        }
        return null;
    }

    /**
     * 获取评论枚举
     *
     * @param type 类型
     * @return {@link CommentTypeEnum}
     */
    public static CommentTypeEnum getCommentEnum(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.getType().equals(type)) {
                return value;
            }
        }
        return null;
    }

}
