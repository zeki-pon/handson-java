package simple.service;

import org.springframework.stereotype.Service;
import simple.model.Foo;
import simple.repository.FooRepository;

@Service
public class FooServiceImpl implements FooService {

    FooRepository fooRepository;

    public FooServiceImpl(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public Foo create(Foo foo) {
        return fooRepository.save(foo);
    }

    @Override
    public Foo searchFooByName(String name) {
        return fooRepository.findByName(name);
    }
}
