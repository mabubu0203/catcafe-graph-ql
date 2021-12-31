package mabubu0203.com.github.cafe.domain.entity.cast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import mabubu0203.com.github.cafe.domain.value.HttpUrl;
import mabubu0203.com.github.cafe.domain.value.Memo;
import mabubu0203.com.github.cafe.domain.value.cast.CatSex;
import mabubu0203.com.github.cafe.domain.value.code.CastCatId;


/**
 * キャスト(猫)
 */
@Builder
@Value
@With
public class CastCatEntity {

  CastCatId castCatId;
  String name;
  HttpUrl image;
  String type;
  CatSex sex;
  LocalDate birthdayDate;
  String favorite;
  String dislike;
  String prohibition;
  List<CastCatId> brothers;
  List<CastCatId> sisters;
  Memo memo;
  LocalDateTime createdDateTime;
  Integer version;
  LocalDateTime updatedDateTime;

  public static CastCatEntity createByCastCatId(Integer castCatId) {
    return CastCatEntity.builder()
        .castCatId(new CastCatId(castCatId))
        .build();
  }

  public Integer getCastCatIdValue() {
    return Optional.ofNullable(this.castCatId)
        .map(CastCatId::value)
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
