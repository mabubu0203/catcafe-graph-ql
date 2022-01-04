package mabubu0203.com.github.cafe.domain.entity.notice;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.entity.SearchConditions;
import mabubu0203.com.github.cafe.domain.value.code.NoticeCode;

@Accessors(fluent = true)
@Value
@EqualsAndHashCode(callSuper = true)
public class NoticeSearchConditions extends SearchConditions {

  Optional<List<NoticeCode>> optNoticeCodes;

  public List<String> noticeCodes() {
    return this.optNoticeCodes.orElseGet(Collections::emptyList)
        .stream()
        .map(NoticeCode::value)
        .toList();
  }

}
