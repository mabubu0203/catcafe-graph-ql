package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.callback;

import lombok.extern.java.Log;
import mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto.LocationTable;
import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log
@Component
public class LocationTableCallback implements AfterSaveCallback<LocationTable> {

  @Override
  public Publisher<LocationTable> onAfterSave(
      LocationTable dto,
      OutboundRow outboundRow,
      SqlIdentifier table
  ) {
    log.info("onAfterSave");
    return Mono.just(dto);
  }

}
