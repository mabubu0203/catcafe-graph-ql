package mabubu0203.com.github.cafe.api.service.cast.impl;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.cast.CastRegisterService;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastCatRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.input.CastRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastCatServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.impl.converter.output.CastServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.cast.model.input.CastRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.cast.model.output.CastServiceOutput;
import mabubu0203.com.github.cafe.domain.entity.cast.CastEntity;
import mabubu0203.com.github.cafe.domain.repository.cast.CastRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CastRegisterServiceImpl implements CastRegisterService {

  private final CastRepository castRepository;

  @Override
  public Mono<CastServiceOutput> action(CastRegisterServiceInput input) {
    var receptionTime = this.getReceptionTime();
    return Optional.of(input)
        .map(new CastRegisterServiceInputConverter())
//        .map(this::beforeRegistration)
//        .orElseThrow(RuntimeException::new)
        .map(entity -> this.castRepository.register(entity, receptionTime))
        .orElseThrow(RuntimeException::new)
        .flatMap(this.castRepository::findByCode)
        .map(new CastServiceOutputConverter());
  }

//  private Mono<CastEntity> beforeRegistration(CastEntity entity) {
//    var storeId = entity.getStoreId();
//    var castCatId = entity.getCastCatEntity().getCastCatId();
//    return this.storeRepository.findBy(storeId)
//        .doOnError(Mono::error)
//        .thenReturn(castCatId)
//        .flatMap(this.castRepository::findBy)
//        .doOnError(Mono::error)
//        .thenReturn(entity);
//  }

}
