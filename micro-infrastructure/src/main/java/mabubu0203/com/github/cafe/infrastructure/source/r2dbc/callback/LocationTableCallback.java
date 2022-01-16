package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.callback;

import lombok.RequiredArgsConstructor;
import mabubu0203.com.github.cafe.domain.check.message.streams.publisher.LocationEventPublisher;
import mabubu0203.com.github.cafe.domain.value.code.LocationCode;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.LocationTable;
import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class LocationTableCallback implements AfterSaveCallback<LocationTable> {

  private final LocationEventPublisher eventPublisher;

  @Override
  public Publisher<LocationTable> onAfterSave(
      LocationTable dto,
      OutboundRow outboundRow,
      SqlIdentifier table
  ) {
    var locationCode = new LocationCode(dto.code());
    this.eventPublisher.publishEvent(locationCode);
    return Mono.just(dto);
  }

}
