package com.aurora.strategy;

import com.aurora.model.dto.ArticleSearchDTO;

import java.util.List;

/**
 * @author aFei
 * 搜索策略
 */
public interface SearchStrategy {

    List<ArticleSearchDTO> searchArticle(String keywords);

}
