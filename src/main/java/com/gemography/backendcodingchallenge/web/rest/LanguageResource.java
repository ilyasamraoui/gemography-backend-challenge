package com.gemography.backendcodingchallenge.web.rest;

import com.gemography.backendcodingchallenge.domain.Language;
import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;
import com.gemography.backendcodingchallenge.service.LanguageService;
import com.gemography.backendcodingchallenge.web.rest.client.GitHubApiProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

/**
 * REST controller for managing {@link Language}.
 */
@RestController
public class LanguageResource {
    private final GitHubApiProxy githubApiProxy;
    private final LanguageService languageService;

    public LanguageResource(GitHubApiProxy githubApiProxy, LanguageService languageService) {
        this.githubApiProxy = githubApiProxy;
        this.languageService = languageService;
    }

    /**
     * {@code GET  /trendingLanguages} : get languages used by the 100 trending public repos on GitHub.
     *
     * @return the {@link Set<Language>} with status {@code 200 (OK)}.
     */
    @GetMapping("/trendingLanguages")
    public Set<Language> trendingLanguages() {
        RepositorySearchResult result = githubApiProxy.fetchTrendingRepos(LocalDate.now().minusDays(30).toString());
        return languageService.getTrendingLanguages(result);
    }
}
