package mvc.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingServiceImpl implements SortingService {
    @Override
    public List<Integer> sortArray(List<Integer> arr) {
        return arr.stream().sorted().toList();
    }
}
