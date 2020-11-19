package com.gemography.backendcodingchallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.Set;

/**
 * A RepositorySearchResult.
 */
public class RepositorySearchResult {

    @JsonProperty("items")
    private Set<Repository> repositories;

    public RepositorySearchResult() {
    }

    public RepositorySearchResult(Set<Repository> repositories) {
        this.repositories = repositories;
    }

    public Set<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(Set<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public String toString() {
        return "RepositorySearchResult{" +
                "repositories=" + repositories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RepositorySearchResult)) {
            return false;
        }
        return repositories != null && repositories.equals(((RepositorySearchResult) o).repositories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repositories);
    }

    public static class Repository {

        @JsonProperty("language")
        private String languageName;

        @JsonProperty("html_url")
        private String url;

        public Repository(String languageName, String url) {
            this.languageName = languageName;
            this.url = url;
        }

        public String getLanguageName() {
            return languageName;
        }

        public String getUrl() {
            return url;
        }

        public void setLanguageName(String languageName) {
            this.languageName = languageName;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Repository{" +
                    "languageName='" + languageName + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Repository)) {
                return false;
            }
            return url != null && url.equals(((Repository) o).url);
        }

        @Override
        public int hashCode() {
            return Objects.hash(url);
        }
    }
}
