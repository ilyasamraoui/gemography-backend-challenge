package com.gemography.backendcodingchallenge.service.mapper;

import com.gemography.backendcodingchallenge.BackendCodingChallengeApplication;
import com.gemography.backendcodingchallenge.testdata.LanguageData;
import com.gemography.backendcodingchallenge.testdata.RepositorySearchResultData;
import com.gemography.backendcodingchallenge.domain.Language;
import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest(classes = BackendCodingChallengeApplication.class)
class LanguageMapperTest {

    @Autowired
    private LanguageMapper languageMapper;

    @Test
    void testMapSearchResultToLanguageSet() {
        //given
        RepositorySearchResult result = RepositorySearchResultData.createRepositorySearchResultWithMultiRepos();
        //when
        Set<Language> mappedLanguages = languageMapper.mapToLanguages(result);
        //then
        assertThat(mappedLanguages).isEqualTo(LanguageData.createLanguagesSet());
    }
}
