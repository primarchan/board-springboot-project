package com.primarchan.projectboard.repository;

import com.primarchan.projectboard.domain.Article;
import com.primarchan.projectboard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle>
{

    /**
     * @apiNote 검색 기능 추가를 위한 매서드 재정의
     * @param bindings the {@link QuerydslBindings} to customize, will never be {@literal null}.
     * @param root the entity root, will never be {@literal null}.
     */
    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true); // 전체 필드에 대한 검색 기능 차단 활성화
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy); // 검색 가능한 필드 설정
        bindings.bind(root.title).first((StringExpression::containsIgnoreCase)); // Like 검색, 대소문자 구분하지 않도록 설정
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase));
        bindings.bind(root.hashtag).first((StringExpression::containsIgnoreCase));
        bindings.bind(root.createdAt).first((DateTimeExpression::eq));
        bindings.bind(root.createdBy).first((StringExpression::containsIgnoreCase));
    }
}