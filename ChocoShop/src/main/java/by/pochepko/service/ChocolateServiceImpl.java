package by.pochepko.service;

import by.pochepko.dto.ChocolateDto;
import by.pochepko.repository.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ChocolateServiceImpl implements ChocolateService {

    @Autowired
    private ChocolateDtoMapper chocolateMapper;
    @Autowired
    private ChocolateRepository chocolateRepository;

    @Override
    public List<ChocolateDto> getChocolateLst() {

        return StreamSupport.stream(chocolateRepository.findAll().spliterator(), false)
                .map(chocolateMapper::modelToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateChocolate(ChocolateDto chocolate) {
        chocolateRepository.save(chocolateMapper.DtoToModel(chocolate));

    }

    @Override
    public ChocolateDto createChocolate(ChocolateDto chocolate) {

        return chocolateMapper.modelToDTO(chocolateRepository.save(chocolateMapper.DtoToModel(chocolate)));
    }

    @Override
    public ChocolateDto getChocolateById(long id) {

        return chocolateMapper.modelToDTO(chocolateRepository.findById(id).get());
    }
}
