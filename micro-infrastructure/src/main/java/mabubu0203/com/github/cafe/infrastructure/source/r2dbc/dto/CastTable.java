package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
@Table(value = "cast")
public class CastTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "store_id")
  private Integer storeId;

  @Column(value = "cast_cat_id")
  private Integer castCatId;

  @Column(value = "employment_status")
  private EmploymentStatus employmentStatus = EmploymentStatus.main;

  @Column(value = "first_attendance_date")
  private LocalDate firstAttendanceDate;

  @Column(value = "last_attendance_date")
  private LocalDate lastAttendanceDate;

  @Column(value = "memo")
  private String memo;

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
  public CastTable code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public CastTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public CastTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public CastTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

  @Getter
  public enum EmploymentStatus {
    main,
    sub,
    ;

    public static EmploymentStatus getByLabel(String label) {
      return Optional.ofNullable(label)
          .flatMap(val ->
              Arrays.stream(EmploymentStatus.values())
                  .filter(status -> status.name().equals(val))
                  .findFirst())
          .orElse(EmploymentStatus.main);
    }

  }

}
