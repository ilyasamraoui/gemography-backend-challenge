package com.gemography.backendcodingchallenge.service.mapper;

import com.gemography.backendcodingchallenge.domain.Language;
import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Mapper for the entity {@link Language} and {@link RepositorySearchResult}.
 */
@Component
public class LanguageMapper {

    /**
     * group github repos by languages and construct the set of languages with set of repos urls.
     *
     * @param  result the repository search result that we fetched from github
     * @return the set of languages.
     */
    public Set<Language> mapToLanguages(RepositorySearchResult result) {
        Map<String, Set<String>> map = result.getRepositories().stream()
                .filter(repo -> Optional.ofNullable(repo.getLanguageName()).isPresent())
                .collect(
                        groupingBy(RepositorySearchResult.Repository::getLanguageName,
                                mapping(RepositorySearchResult.Repository::getUrl, toSet())
                        )
                );
        return map.entrySet().stream()
                .map(entry -> new Language.Builder()
                        .languageName(entry.getKey())
                        .reposNumber(entry.getValue().size())
                        .reposUrls(entry.getValue())
                        .build()
                )
                .sorted(Comparator.comparingInt(Language::getReposCount).reversed())
                .collect(toCollection(LinkedHashSet::new));
    }
}
