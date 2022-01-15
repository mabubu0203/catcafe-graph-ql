package mabubu0203.com.github.cafe.batch.controller.location;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import mabubu0203.com.github.cafe.batch.service.location.ReplacementService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log
@Component
@RequiredArgsConstructor
public class LocationTaskController {

  private final ReplacementService replacementService;

  // 前回の実行完了時刻から10秒後に実行する
  @Scheduled(fixedDelay = 10000)
  public void replacement() {
    log.info("バッチ開始");
    var count = this.replacementService.replacement();
    log.info("バッチ数: " + count);
    log.info("バッチ終了");
  }

}
