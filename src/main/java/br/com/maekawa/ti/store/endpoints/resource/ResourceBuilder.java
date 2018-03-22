package br.com.maekawa.ti.store.endpoints.resource;

import org.springframework.data.domain.Page;
import org.springframework.http.server.reactive.ServerHttpRequest;

public class ResourceBuilder<T> {

    private String uri;

    public ResourceBuilder(ServerHttpRequest request) {
        this.uri = request.getURI().getPath();
    }

    public Resource<T> build(T item) {
        Resource<T> resource = new Resource<>();
        resource.setItem(item);
        resource.setUri(uri);
        return resource;
    }

    public Resource<T> build() {
        Resource<T> resource = new Resource<>();
        resource.setUri(uri);
        return resource;
    }

    public Resource<T> build(Page<T> page) {

        Resource<T> resource = new Resource<>();
        resource.setItems(page.getContent());

        resource.setUri(uri);

        if (page.hasNext()) {
            int nextPage = page.getNumber() + 1;
            resource.addLink("next", uri + "?page=" + nextPage);
        }
        if(page.hasPrevious()) {
            int previousPage = page.getNumber() - 1;
            resource.addLink("previous", uri + "?page=" + previousPage);
        }
        resource.setPageNumber(page.getNumber());
        resource.setTotalElements(page.getTotalElements());
        resource.setTotalPages(page.getTotalPages());
        resource.setPageNumber(page.getNumber());
        return resource;
    }
}
