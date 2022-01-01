package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
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
import mabubu0203.com.github.cafe.domain.entity.cast.CastCatEntity;
import mabubu0203.com.github.cafe.domain.value.HttpUrl;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.CatSex;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(value = "cast_cat")
public class CastCatTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "name")
  private String name;

  @Column(value = "image_url")
  private String image;

  @Column(value = "type")
  private String type;

  @Column(value = "sex")
  private Sex sex = Sex.unknown;

  @Column(value = "birthday_date")
  private LocalDate birthdayDate;

  @Column(value = "favorite")
  private String favorite;

  @Column(value = "dislike")
  private String dislike;

  @Column(value = "prohibition")
  private String prohibition;

  @JsonRawValue
  @Column(value = "brothers")
  private String brothers;

  @JsonRawValue
  @Column(value = "sisters")
  private String sisters;

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
  public CastCatTable code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public CastCatTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public CastCatTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public CastCatTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

  public CastCatTable attach(CastCatEntity entity) {
    var sex =
        CastCatTable.Sex.getByLabel(entity.getSexLabel());
    return code(entity.getCastCatCodeValue())
        .name(entity.name())
        .image(entity.getImageValue())
        .type(entity.type())
        .sex(sex)
        .birthdayDate(entity.birthdayDate())
        .favorite(entity.favorite())
        .dislike(entity.dislike())
        .prohibition(entity.prohibition())
//        .setBrothers()
//        .setSisters()
        .memo(entity.getMemoValue());
  }

  public CastCatEntity toEntity() {
    var castCatCode = new CastCatCode(super.code());
    var image = new HttpUrl(this.image);
    var sex = CatSex.getByLabel(this.sex.name());
    var castCatMemo = new Memo(this.memo());
    return CastCatEntity.builder()
        .castCatCode(castCatCode)
        .name(this.name)
        .image(image)
        .type(this.type)
        .sex(sex)
        .birthdayDate(this.birthdayDate)
        .favorite(this.favorite)
        .dislike(this.dislike)
        .prohibition(this.prohibition)
        .memo(castCatMemo)
        .version(this.version())
        .build();
  }

  @Getter
  public enum Sex {
    unknown,
    male,
    female,
    ;

    public static Sex getByLabel(String label) {
      return Optional.ofNullable(label)
          .flatMap(val ->
              Arrays.stream(Sex.values())
                  .filter(sex -> sex.name().equals(val))
                  .findFirst())
          .orElse(Sex.unknown);
    }

  }

}
