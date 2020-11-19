package com.gemography.backendcodingchallenge.domain;

import com.gemography.backendcodingchallenge.testdata.RepositorySearchResultData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class RepositorySearchResultTest {

    private RepositorySearchResult result;
    private RepositorySearchResult otherResult;

    @BeforeEach
    void initTest() {
        //given
        result = RepositorySearchResultData.createRepositorySearchResultWithOneRepo();
        otherResult = RepositorySearchResultData.createRepositorySearchResultWithOneRepo();
    }

    @Test
    void equalsVerifier() {

        //then
        assertThat(result).isEqualTo(otherResult);

        //and when
        result.setRepositories(new HashSet<>());

        //then
        assertThat(result).isNotEqualTo(otherResult);
    }

    @Test
    void hashCodeVerifier() {
        //then
        assertThat(result).hasSameHashCodeAs(otherResult);

        //and when
        result.setRepositories(new HashSet<>());

        //then
        assertThat(result.hashCode()).isNotEqualTo(otherResult.hashCode());
    }
}
