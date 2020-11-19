package com.gemography.backendcodingchallenge.service;

import com.gemography.backendcodingchallenge.domain.Language;
import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;
import com.gemography.backendcodingchallenge.service.mapper.LanguageMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Service Implementation for managing {@link Language}.
 */
@Service
public class LanguageService {
    private final LanguageMapper languageMapper;

    public LanguageService(LanguageMapper languageMapper) {
        this.languageMapper = languageMapper;
    }

    /**
     * Get Languages used in trending github repos.
     *
     * @param  result the repository search result that we fetched from github
     * @return the set of languages.
     */
    public Set<Language> getTrendingLanguages(RepositorySearchResult result) {
        return languageMapper.mapToLanguages(result);
    }
}
