package mabubu0203.com.github.cafe.infrastructure.source.elastic;

import mabubu0203.com.github.cafe.common.source.elastic.DocumentSource;
import mabubu0203.com.github.cafe.infrastructure.source.elastic.dto.LocationDocument;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDocumentSource extends DocumentSource<LocationDocument, String> {

}
