package br.com.maekawa.ti.store.endpoints.resource;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resource<T> {

    private T item;
    private Collection<T> items;

    private Integer pageNumber;
    private Integer totalPages;
    private Long totalElements;
    private Boolean hasNext;
    private Boolean hasPrevious;
    private String uri;
    private Collection<Link> links;
    private List<Error> errors;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Collection<Link> getLinks() {
        return links;
    }

    public void addLink(String href, String rel) {
        if (this.links == null) {
            this.links = new ArrayList<>();
        }
        this.links.add(new Link(href, rel));
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void addError(String message) {
        if(this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(new Error(message));
    }
}

