package mabubu0203.com.github.cafe.infrastructure.source.r2dbc.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import mabubu0203.com.github.cafe.common.source.r2dbc.base.BaseTable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.util.Objects;

@Accessors(fluent = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(value = "frequently_asked_question")
public class FrequentlyAskedQuestionTable extends BaseTable<Integer> {

  @Id
  @Column(value = "id")
  private Integer id;

  @Column(value = "location_code")
  private String locationCode;

  @Column(value = "category")
  private String category;

  @Column(value = "question_summary")
  private String questionSummary;

  @Column(value = "answer_summary")
  private String answerSummary;

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
  public FrequentlyAskedQuestionTable code(String code) {
    super.code(code);
    return this;
  }

  @Override
  @Transient
  public FrequentlyAskedQuestionTable createdBy(Integer createdBy) {
    super.createdBy(createdBy);
    return this;
  }

  @Override
  @Transient
  public FrequentlyAskedQuestionTable version(Integer version) {
    super.version(version);
    return this;
  }

  @Override
  @Transient
  public FrequentlyAskedQuestionTable updatedBy(Integer updatedBy) {
    super.updatedBy(updatedBy);
    return this;
  }

}
