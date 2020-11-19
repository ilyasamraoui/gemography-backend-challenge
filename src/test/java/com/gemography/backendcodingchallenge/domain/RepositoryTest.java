package com.gemography.backendcodingchallenge.domain;

import com.gemography.backendcodingchallenge.testdata.RepositoryData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RepositoryTest {

    private RepositorySearchResult.Repository repository;
    private RepositorySearchResult.Repository otherRepository;

    @BeforeEach
    void initTest() {
        //given
        repository = RepositoryData.createRepository();
        otherRepository = RepositoryData.createRepository();
    }

    @Test
    void equalsVerifier() {
        //then
        assertThat(repository).isEqualTo(otherRepository);

        //and when
        otherRepository.setUrl("url2");

        //then
        assertThat(repository).isNotEqualTo(otherRepository);
    }

    @Test
    void hashCodeVerifier() {
        //then
        assertThat(repository).hasSameHashCodeAs(otherRepository);

        //and when
        otherRepository.setUrl("url2");

        //then
        assertThat(repository.hashCode()).isNotEqualTo(otherRepository.hashCode());
    }
}
