package com.gemography.backendcodingchallenge.testdata;

import com.gemography.backendcodingchallenge.domain.Language;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

/**
 * language data provider for testing.
 */
public class LanguageData {

    public static Set<Language> createLanguagesSet() {
        Language[] languages = {
                new Language.Builder()
                        .languageName("c")
                        .reposUrls(new HashSet<>(Arrays.asList("url1", "url2")))
                        .reposNumber(2)
                        .build(),
                new Language.Builder()
                        .languageName("c++")
                        .reposUrls(Collections.singleton("url3"))
                        .reposNumber(1)
                        .build()
        };
        return Stream.of(languages)
                .sorted(Comparator.comparingInt(Language::getReposCount).reversed())
                .collect(toCollection(LinkedHashSet::new));
    }

    public static Language createLanguage() {
        return new Language.Builder().languageName("c").build();
    }
}
