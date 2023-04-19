package com.primarchan.projectboard.service;

import com.primarchan.projectboard.domain.Hashtag;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HashtagService {
    public Set<String> parseHashtagNames(String content) {
        if (content == null) {
            return Set.of();
        }

        Pattern pattern = Pattern.compile("#[\\w가-힣]+");
        Matcher matcher = pattern.matcher(content.strip());
        Set<String> result = new HashSet<>();

        while (matcher.find()) {
            result.add(matcher.group().replace("#", ""));
        }

        return result;
    }

    public Set<Hashtag> findHashtagsByNames(Set<String> expectedHashtagNames) {
        return null;
    }

    public void deleteHashtagWithoutArticles(Object any) {
    }
}
