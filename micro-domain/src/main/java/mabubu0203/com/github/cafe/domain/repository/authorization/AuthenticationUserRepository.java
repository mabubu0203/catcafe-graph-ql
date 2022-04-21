package mabubu0203.com.github.cafe.domain.repository.authorization;

import mabubu0203.com.github.cafe.domain.entity.authorization.AuthenticationUserEntity;
import mabubu0203.com.github.cafe.domain.value.authorization.Username;
import reactor.core.publisher.Mono;

public interface AuthenticationUserRepository {

  /**
   * 認証済みユーザーを1件取得する
   *
   * @param username
   * @return
   */
  Mono<AuthenticationUserEntity> findByUsername(Username username);
}
