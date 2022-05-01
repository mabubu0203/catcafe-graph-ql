package mabubu0203.com.github.cafe.domain.repository.authorization;

import java.time.LocalDateTime;
import java.util.List;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.value.authorization.Role;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.domain.value.code.UserCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorizationRepository {

  /**
   * ロールを複数取得する
   *
   * @param roleKeys
   * @return
   */
  Flux<Role> searchByRoleKeys(List<String> roleKeys);

  /**
   * ユーザーを1件取得する
   *
   * @param userCode
   * @return
   */
  Mono<AuthenticationUserEntity> findByCode(UserCode userCode);

  /**
   * Usernameを条件にユーザーを1件取得する
   *
   * @param username
   * @return
   */
  Mono<AuthenticationUserEntity> findByUsername(Username username);

  /**
   * ユーザーを1件登録する
   *
   * @param user
   * @param receptionTime
   * @return
   */
  Mono<UserCode> register(AuthenticationUserEntity user, LocalDateTime receptionTime);

}
