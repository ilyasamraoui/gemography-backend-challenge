package com.gemography.backendcodingchallenge.web.rest.client;

import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Rest Client for the gitHub api
 */
@FeignClient(name = "github-api", url = "https://api.github.com")
public interface GitHubApiProxy {

    /**
     * {@code GET  /search/repositories?q=created:>{date}&sort=stars&order=desc :
     * fetching the most starred repos created in the last 30 days.
     *
     * @param date of the last 30 days.
     * @return the {@link RepositorySearchResult} with status {@code 200 (OK)}}.
     */
    @GetMapping("/search/repositories?q=created:%3E{date}&sort=stars&order=desc")
    RepositorySearchResult fetchTrendingRepos(@PathVariable("date") String date);
}
