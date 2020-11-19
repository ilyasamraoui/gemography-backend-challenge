package com.gemography.backendcodingchallenge.service;

import com.gemography.backendcodingchallenge.BackendCodingChallengeApplication;
import com.gemography.backendcodingchallenge.testdata.LanguageData;
import com.gemography.backendcodingchallenge.testdata.RepositorySearchResultData;
import com.gemography.backendcodingchallenge.domain.Language;
import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;
import com.gemography.backendcodingchallenge.service.mapper.LanguageMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = BackendCodingChallengeApplication.class)
class LanguageServiceTest {

    @Mock
    private LanguageMapper languageMapper;
    @InjectMocks
    private LanguageService languageService;

    @Test
    void getTrendingLanguagesTest() {
        //given
        Set<Language> languages = LanguageData.createLanguagesSet();
        RepositorySearchResult result = RepositorySearchResultData.createRepositorySearchResultWithOneRepo();
        given(languageMapper.mapToLanguages(result)).willReturn(languages);
        //when
        Set<Language> returnedLanguages = languageService.getTrendingLanguages(result);
        //then
        assertThat(returnedLanguages).isEqualTo(languages);
    }
}
