package simple.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import simple.JpaApplication;
import simple.model.Foo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaApplication.class})
@DirtiesContext // 次のテストの実行前に、アプリケーションコンテキストを破棄し、新しいコンテキストを作成
class FooServiceImplTest {

    @Autowired
    FooService fooService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenInvalidEntityIsCreated_thenDataException() {
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            fooService.create(new Foo());
        });
    }

    @Test
    void whenValidEntityIsCreated_thenSuccess() {
        Foo foo = fooService.create(new Foo("test_name"));
        Assertions.assertNotNull(foo);
        Assertions.assertEquals("test_name", foo.getName());
    }

    @Test
    void whenSearchFooByNameIsInvoked_thenSuccess() {
        fooService.create(new Foo("test_name"));    // TODO: テストデータ追加方法の改善
        Foo foo = fooService.searchFooByName("test_name");
        Assertions.assertNotNull(foo);
        Assertions.assertEquals("test_name", foo.getName());
    }
}