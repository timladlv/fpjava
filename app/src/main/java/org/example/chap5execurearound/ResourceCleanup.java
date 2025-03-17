package org.example.chap5execurearound;

import java.io.IOException;

public class ResourceCleanup {
    private final Resource resource;
    private ResourceCleanup(final Resource resource) {
        this.resource = resource;
    }
    public void useResource() {
        resource.action();
    }
    private void close() {
        resource.close();
    }
    public static void use(final Resource resource,
                           final UseInstance<ResourceCleanup, IOException> block)
            throws IOException {
        ResourceCleanup resourceCleanup = new ResourceCleanup(resource);
        try {
            block.accept(resourceCleanup);
        } finally {
            resourceCleanup.close();
        }
    }
}
