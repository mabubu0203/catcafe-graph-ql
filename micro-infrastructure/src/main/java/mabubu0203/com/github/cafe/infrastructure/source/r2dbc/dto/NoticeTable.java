package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(value = "notice")
public class NoticeTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "store_id")
  private Integer storeId;

  @Column(value = "summary")
  private String summary;

  @Column(value = "detail")
  private String detail;

  @Column(value = "publication_start_date_time")
  private LocalDateTime publicationStartDateTime;

  @Column(value = "publication_end_date_time")
  private LocalDateTime publicationEndDateTime;

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  @Transient
  public boolean isNew() {
    return super.isNew() || Objects.isNull(this.id);
  }

  @Override
  @Transient
  public NoticeTable code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public NoticeTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public NoticeTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public NoticeTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

}
