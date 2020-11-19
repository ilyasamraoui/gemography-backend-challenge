package com.gemography.backendcodingchallenge.testdata;

import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * repository search result data provider for testing.
 */
public class RepositorySearchResultData {

    public static RepositorySearchResult createRepositorySearchResultWithMultiRepos() {
        Set<RepositorySearchResult.Repository> repositories = Stream.of(
                new RepositorySearchResult.Repository("c", "url1"),
                new RepositorySearchResult.Repository("c++", "url2"),
                new RepositorySearchResult.Repository("c", "url3")
        ).collect(Collectors.toSet());
        return new RepositorySearchResult(repositories);
    }

    public static RepositorySearchResult createRepositorySearchResultWithOneRepo() {
        return new RepositorySearchResult(
                Collections.singleton(new RepositorySearchResult.Repository("java", "url1"))
        );
    }
}
