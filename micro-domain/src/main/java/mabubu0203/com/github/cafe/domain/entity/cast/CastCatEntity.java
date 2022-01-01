package mabubu0203.com.github.cafe.domain.entity.cast;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.domain.value.HttpUrl;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.CatSex;
import mabubu0203.com.github.cafe.domain.value.code.CastCatCode;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;


/**
 * キャスト(猫)
 */
@Accessors(fluent = true)
@Builder
@Value
@With
public class CastCatEntity {

  @Deprecated
  CastCatId castCatId;
  CastCatCode castCatCode;
  String name;
  HttpUrl image;
  String type;
  CatSex sex;
  LocalDate birthdayDate;
  String favorite;
  String dislike;
  String prohibition;
  List<CastCatCode> brothers;
  List<CastCatCode> sisters;
  Memo memo;
  Integer version;

  public static CastCatEntity createByCastCatCode(String castCatCode) {
    return CastCatEntity.builder()
        .castCatCode(new CastCatCode(castCatCode))
        .build();
  }

  @Deprecated
  public Integer getCastCatIdValue() {
    return Optional.ofNullable(this.castCatId)
        .map(CastCatId::value)
        .orElse(null);
  }

  public String getCastCatCodeValue() {
    return Optional.ofNullable(this.castCatCode)
        .map(CastCatCode::value)
        .orElse(null);
  }

  public String getImageValue() {
    return Optional.ofNullable(this.image)
        .map(HttpUrl::value)
        .orElse(null);
  }

  public Integer getSexCode() {
    return Optional.ofNullable(this.sex)
        .map(CatSex::getCode)
        .orElse(null);
  }

  public String getSexLabel() {
    return Optional.ofNullable(this.sex)
        .map(CatSex::getLabel)
        .orElse(null);
  }

  public String getMemoValue() {
    return Optional.ofNullable(this.memo)
        .map(Memo::value)
        .orElse(null);
  }

}
