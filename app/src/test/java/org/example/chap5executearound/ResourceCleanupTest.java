package org.example.chap5executearound;

import org.example.chap5execurearound.Resource;
import org.example.chap5execurearound.ResourceCleanup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ResourceCleanupTest {
    @Mock
    private Resource resource;

    @Test
    void resourceCloseIsCalled() throws IOException {
        // given / when
        ResourceCleanup.use(resource, rc -> {
            rc.useResource();
            rc.useResource();
        });

        // then
        verify(resource, times(2)).action();
        verify(resource).close();
    }

}
