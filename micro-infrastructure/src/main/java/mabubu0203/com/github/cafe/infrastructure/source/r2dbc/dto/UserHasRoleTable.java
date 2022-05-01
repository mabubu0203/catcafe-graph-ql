package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(fluent = true)
@Data
@Table(value = "user_has_role")
public class UserHasRoleTable {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "authentication_user_code")
  private String authenticationUserCode;

  @Column(value = "role_key")
  private String roleKey;

  @CreatedDate
  @Column(value = "created_date_time")
  private LocalDateTime createdDateTime;

  @Column(value = "created_by")
  private Integer createdBy;

  @Version
  @Column(value = "version")
  private Integer version;

  @LastModifiedDate
  @Column(value = "updated_date_time")
  private LocalDateTime updatedDateTime;

  @Column(value = "updated_by")
  private Integer updatedBy;

  @Column(value = "deleted_date_time")
  private LocalDateTime deletedDateTime;

  @Column(value = "deleted_flag")
  private BaseTable.DeletedFlag deletedFlag = BaseTable.DeletedFlag.is_false;

  @Transient
  private boolean isNew;

  @Transient
  public boolean isExists() {
    return BaseTable.DeletedFlag.is_false.equals(this.deletedFlag);
  }

  @Transient
  public boolean isDeleted() {
    return !BaseTable.DeletedFlag.is_false.equals(this.deletedFlag);
  }

  @Getter
  public enum DeletedFlag {
    is_true,
    is_false
  }

}
