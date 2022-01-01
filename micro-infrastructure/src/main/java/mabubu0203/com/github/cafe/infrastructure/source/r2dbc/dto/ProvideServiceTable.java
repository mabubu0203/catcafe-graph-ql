package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.math.BigDecimal;
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
@Table(value = "provide_service")
public class ProvideServiceTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "store_id")
  private Integer storeId;

  @Column(value = "name")
  private String name;

  @Column(value = "price")
  private BigDecimal price;

  @Column(value = "detail")
  private String detail;

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
  public ProvideServiceTable code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public ProvideServiceTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public ProvideServiceTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public ProvideServiceTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

}
