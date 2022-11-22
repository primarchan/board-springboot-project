package com.primarchan.projectboard.dto.request;

import com.primarchan.projectboard.domain.Article;
import com.primarchan.projectboard.domain.ArticleComment;
import com.primarchan.projectboard.dto.ArticleDto;
import com.primarchan.projectboard.dto.UserAccountDto;

import java.time.LocalDateTime;

public record ArticleRequest(
        String title,
        String content,
        String hashtag
) {

    public static ArticleRequest of(String title, String content, String hashtag) {
        return new ArticleRequest(title, content, hashtag);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtag
        );
    }

}