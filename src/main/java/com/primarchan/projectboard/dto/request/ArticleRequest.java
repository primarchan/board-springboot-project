package com.primarchan.projectboard.dto.request;

import com.primarchan.projectboard.domain.Article;
import com.primarchan.projectboard.domain.ArticleComment;
import com.primarchan.projectboard.dto.ArticleDto;
import com.primarchan.projectboard.dto.HashtagDto;
import com.primarchan.projectboard.dto.UserAccountDto;

import java.time.LocalDateTime;
import java.util.Set;

public record ArticleRequest(
        String title,
        String content
) {

    public static ArticleRequest of(String title, String content) {
        return new ArticleRequest(title, content);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return toDto(userAccountDto, null);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto, Set<HashtagDto> hashtagDtos) {
        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtagDtos
        );
    }

}