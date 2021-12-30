# 開発環境
====

## IDE

IntelliJ IDEAを使用します。

### Plugin

下記の最新版をインストールします。

1. google-java-format Settings
1. Lombok Plugin

## 起動方法

### ミドルウェアまで起動

1. 当プロジェクトをIntelliJ IDEAにGradleProjectとしてclone
1. ProjectSDK はJDK17を指定
1. docker-composeよりMysql/Redisを起動
   `$ docker-compose -f ./docker/mac/docker-compose.yml up -d --build`

### 起動方法(IDEA)

1. アプリケーションをbootRun
    * GradleタスクよりbootRun(`:micro-api -> Tasks -> application -> bootRun`)

### 起動方法(Docker)

1. GradleタスクよりjibDockerBuild(`:micro-api -> Tasks -> jib -> jibDockerBuild`)
   `$ ./gradlew :micro-api:jibDockerBuild`
1. Dockerより起動
   `$ docker run --name micro-api --network mac_app-net --rm -p 9001:9001 -it micro-api:523ceba.dirty`

### Endpoints

- [Api][]
- [GraphiQL][]
- [Redisinsight][]

## 停止方法

1. アプリケーションの停止
    * bootRunの停止
    * Dockerより停止
      `$ docker stop micro-api`
1. docker-composeより停止
   `$ docker-compose -f ./docker/mac/docker-compose.yml stop`
1. docker-composeよりコンテナ破棄
   `$ docker-compose -f ./docker/mac/docker-compose.yml down -v`

[Api]: http://localhost:9001/                               "Api"

[GraphiQL]: http://localhost:9001/graphiql?path=/graphql    "GraphiQL"

[Redisinsight]: http://localhost:8001/                      "Redisinsight"