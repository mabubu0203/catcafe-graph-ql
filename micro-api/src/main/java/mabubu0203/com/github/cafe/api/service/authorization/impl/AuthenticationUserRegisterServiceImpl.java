package mabubu0203.com.github.cafe.api.service.authorization.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.api.service.authorization.AuthenticationUserRegisterService;
import mabubu0203.com.github.cafe.api.service.authorization.impl.converter.input.AuthenticationUserRegisterServiceInputConverter;
import mabubu0203.com.github.cafe.api.service.authorization.impl.converter.output.AuthenticationUserServiceOutputConverter;
import mabubu0203.com.github.cafe.api.service.authorization.model.input.AuthenticationUserRegisterServiceInput;
import mabubu0203.com.github.cafe.api.service.authorization.model.output.AuthenticationUserRegisterServiceOutput;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.repository.authorization.AuthorizationRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthenticationUserRegisterServiceImpl implements AuthenticationUserRegisterService {

  private final AuthorizationRepository authorizationRepository;

  @Override
  @PreAuthorize("hasAuthority('Register')")
  @Transactional
  public Mono<AuthenticationUserRegisterServiceOutput> action(
      AuthenticationUserRegisterServiceInput input
  ) {
    var receptionTime = this.getReceptionTime();
    var roleKeys = input.roleKeys();
    return Mono.just(input)
        .map(new AuthenticationUserRegisterServiceInputConverter())
        .flatMap(entity -> this.beforeRegistration(entity, roleKeys))
        .flatMap(entity -> this.authorizationRepository.register(entity, receptionTime))
        .flatMap(this.authorizationRepository::findByCode)
        .map(new AuthenticationUserServiceOutputConverter());
  }

  @Override
  public Mono<AuthenticationUserRegisterServiceOutput> onAfterSave(
      AuthenticationUserRegisterServiceOutput output
  ) {
    return null;
  }

  private Mono<AuthenticationUserEntity> beforeRegistration(
      AuthenticationUserEntity entity,
      List<String> roleKeys
  ) {
    return this.authorizationRepository.searchByRoleKeys(roleKeys)
        .map(entity::addRole)
        .then(Mono.just(entity));
  }

}