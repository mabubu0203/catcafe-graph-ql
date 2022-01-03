package mabubu0203.com.github.cafe.api.service.cast.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastModifyService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastModifyServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastModifyServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastModifyServiceImpl implements CastModifyService {

  private final CastRepository castRepository;

  @Override
  @Transactional
  public Mono<CastServiceOutput> action(CastModifyServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Optional.of(input)
        .map(new CastModifyServiceInputConverter())
//        .map(this::beforeRegistration)
//        .orElseThrow(RuntimeException::new)
        .map(entity -> this.castRepository.modify(entity, receptionTime))
        .orElseThrow(RuntimeException::new)
        .flatMap(this.castRepository::findByCode)
        .map(new CastServiceOutputConverter());
  }

//  private Mono<CastEntity> beforeRegistration(CastEntity entity) {
//    var locationCode = entity.locationCode();
//    var castCatCode = entity.castCatCode();
//    return this.storeRepository.findBy(locationCode)
//        .doOnError(Mono::error)
//        .thenReturn(castCatCode)
//        .flatMap(this.castRepository::findByCode)
//        .doOnError(Mono::error)
//        .thenReturn(entity);
//  }

}
