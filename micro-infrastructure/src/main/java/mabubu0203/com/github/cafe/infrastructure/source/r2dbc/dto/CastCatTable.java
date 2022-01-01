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

@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(value = "cast_cat")
public class CastCatTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "code")
  private String code;

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
  @Transient
  public boolean isNew() {
    return super.isNew() || Objects.isNull(id);
  }

  public CastCatTable attach(CastCatEntity entity) {
    var sex =
        CastCatTable.Sex.getByLabel(entity.getSexLabel());
    return setCode(entity.getCastCatCodeValue())
        .setName(entity.getName())
        .setImage(entity.getImageValue())
        .setType(entity.getType())
        .setSex(sex)
        .setBirthdayDate(entity.getBirthdayDate())
        .setFavorite(entity.getFavorite())
        .setDislike(entity.getDislike())
        .setProhibition(entity.getProhibition())
//        .setBrothers()
//        .setSisters()
        .setMemo(entity.getMemoValue());
  }

  public CastCatEntity toEntity() {
    var castCatCode = new CastCatCode(this.getCode());
    var image = new HttpUrl(this.getImage());
    var sex = CatSex.getByLabel(this.getSex().name());
    var castCatMemo = new Memo(this.getMemo());
    return CastCatEntity.builder()
        .castCatCode(castCatCode)
        .name(this.getName())
        .image(image)
        .type(this.getType())
        .sex(sex)
        .birthdayDate(this.getBirthdayDate())
        .favorite(this.getFavorite())
        .dislike(this.getDislike())
        .prohibition(this.getProhibition())
        .memo(castCatMemo)
        .version(this.getVersion())
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
