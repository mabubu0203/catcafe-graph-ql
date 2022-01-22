package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastRegisterService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import mabubu0203.com.github.cafe.domain.repository.location.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CastRegisterServiceImpl implements CastRegisterService {

  private final CastRepository castRepository;
  private final LocationRepository locationRepository;

  @Override
  @Transactional
  public Mono<CastServiceOutput> action(CastRegisterServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Mono.just(input)
        .map(new CastRegisterServiceInputConverter())
        .flatMap(this::beforeRegistration)
        .flatMap(entity -> this.castRepository.register(entity, receptionTime))
        .flatMap(this.castRepository::findByCode)
        .map(new CastServiceOutputConverter());
  }

  @Override
  public Mono<CastServiceOutput> onAfterSave(CastServiceOutput output) {
    return null;
  }

  private Mono<CastEntity> beforeRegistration(CastEntity entity) {
    var locationCode = entity.locationCode();
    var castCatCode = entity.castCatCode();
    return this.locationRepository.findByCode(locationCode)
        .doOnError(Mono::error)
        .thenReturn(castCatCode)
        .flatMap(this.castRepository::findByCode)
        .doOnError(Mono::error)
        .thenReturn(entity);
  }

}
