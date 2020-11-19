package com.gemography.backendcodingchallenge.web.rest;

import com.gemography.backendcodingchallenge.BackendCodingChallengeApplication;
import com.gemography.backendcodingchallenge.testdata.RepositorySearchResultData;
import com.gemography.backendcodingchallenge.domain.RepositorySearchResult;
import com.gemography.backendcodingchallenge.web.rest.client.GitHubApiProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BackendCodingChallengeApplication.class)
@AutoConfigureMockMvc
class LanguageResourceTest {

    @MockBean
    private GitHubApiProxy gitHubApiProxy;
    @Autowired
    private MockMvc mockMvc;

    private RepositorySearchResult result;
    @BeforeEach
    void intiTests() {
        result = RepositorySearchResultData.createRepositorySearchResultWithOneRepo();
    }

    @Test
    void getTrendingLanguagesTest() throws Exception {
        given(gitHubApiProxy.fetchTrendingRepos(LocalDate.now().minusDays(30).toString())).willReturn(result);
        RepositorySearchResult.Repository repository = result.getRepositories().iterator().next();
        mockMvc.perform(get("/trendingLanguages")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].languageName").value(repository.getLanguageName()))
                .andExpect(jsonPath("$.[0].reposUrls").value(repository.getUrl()))
                .andExpect(jsonPath("$.[*].reposCount").value(1));
    }
}
