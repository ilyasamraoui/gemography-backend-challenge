package com.gemography.backendcodingchallenge.testdata;

import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;

/**
 * repository data provider for testing.
 */
public class RepositoryData {

    public static RepositorySearchResult.Repository createRepository() {
        return new RepositorySearchResult.Repository("python", "url1");
    }
}
