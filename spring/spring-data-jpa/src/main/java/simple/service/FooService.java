package simple.service;

import simple.model.Foo;

public interface FooService {
    Foo create(Foo foo);
    Foo searchFooByName(String name);
}
