package com.gemography.backendcodingchallenge.domain;

import java.util.Objects;
import java.util.Set;

/**
 * A Language.
 */
public class Language {

    private String languageName;
    private Integer reposCount;
    private Set<String> reposUrls;

    private Language(Builder builder) {
        this.languageName = builder.languageName;
        this.reposCount = builder.reposNumber;
        this.reposUrls = builder.reposUrls;
    }

    public String getLanguageName() {
        return languageName;
    }

    public Integer getReposCount() {
        return reposCount;
    }

    public Set<String> getReposUrls() {
        return reposUrls;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setReposCount(Integer reposCount) {
        this.reposCount = reposCount;
    }

    public void setReposUrls(Set<String> reposUrls) {
        this.reposUrls = reposUrls;
    }

    @Override
    public String toString() {
        return "Language{" +
                "numberRepos=" + reposCount +
                ", repos=" + reposUrls +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Language)) {
            return false;
        }
        return languageName != null && languageName.equals(((Language) o).languageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageName);
    }

    public static class Builder {
        private String languageName;
        private Integer reposNumber;
        private Set<String> reposUrls;

        public Builder languageName(String languageName) {
            this.languageName = languageName;
            return this;
        }

        public Builder reposNumber(Integer reposNumber) {
            this.reposNumber = reposNumber;
            return this;
        }

        public Builder reposUrls(Set<String> reposUrls) {
            this.reposUrls = reposUrls;
            return this;
        }

        public Language build() {
            return new Language(this);
        }
    }
}
