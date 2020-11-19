package com.gemography.backendcodingchallenge.domain;

import com.gemography.backendcodingchallenge.testdata.LanguageData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LanguageTest {
    private Language language;
    private Language otherLanguage;

    @BeforeEach
    void initTest() {
        //given
        language = LanguageData.createLanguage();
        otherLanguage = LanguageData.createLanguage();
    }

    @Test
    void equalsVerifier() {
        //then
        assertThat(language).isEqualTo(otherLanguage);

        //and when
        otherLanguage.setLanguageName("java");

        //then
        assertThat(language).isNotEqualTo(otherLanguage);
    }

    @Test
    void hashCodeVerifier() {
        //then
        assertThat(language).hasSameHashCodeAs(otherLanguage);

        //and when
        otherLanguage.setLanguageName("java");
        assertThat(language.hashCode()).isNotEqualTo(otherLanguage.hashCode());
    }
}
