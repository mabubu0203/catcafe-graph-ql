package mabubu0203.com.github.cafe.domain.repository.authorization;

import java.time.LocalDateTime;
import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import mabubu0203.com.github.cafe.domain.value.code.UserCode;
import reactor.core.publisher.Mono;

public interface AuthorizationRepository {

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
