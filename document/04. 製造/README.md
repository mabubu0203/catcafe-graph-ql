# 開発環境
====

## IDE

IntelliJ IDEAを使用します。

### Plugin

下記の最新版をインストールします。

- EditorConfig
- GraphQL
- Lombok Plugin

## 起動方法

### ミドルウェアまで起動

1. 当プロジェクトをIntelliJ IDEAにGradleProjectとしてclone
1. ProjectSDK はJDK17を指定
1. docker-composeより `Elasticsearch/Mysql/Redis` を起動
    * `$ docker-compose -f ./docker/mac/docker-compose.yml up -d --build`

### 起動方法(IDEA)

1. アプリケーションをbootRun
    * GradleタスクよりbootRun(`:micro-api -> Tasks -> application -> bootRun`)
    * GradleタスクよりbootRun(`:micro-batch -> Tasks -> application -> bootRun`)

### SpectaQL生成

1. GradleタスクよりspectaqlRun(`:micro-api -> Tasks -> other -> spectaqlRun`)
    * `$ ./gradlew :micro-api:spectaqlRun`
    * `open ./docs/index.html`

### Endpoints

- [Api](http://localhost:9001/)
- [GraphiQL](http://localhost:9001/graphiql?path=/graphql)
- [Kibana](http://localhost:5601/app/home)
- [phpMyAdmin](http://localhost:8021/)
- [Redisinsight](http://localhost:8001/)
- [RedisCommand](http://localhost:8081/)

## 停止方法

1. アプリケーションの停止
    * bootRunの停止
    * Dockerより停止
      * `$ docker stop micro-api`
1. docker-composeより停止
    * `$ docker-compose -f ./docker/mac/docker-compose.yml stop`
1. docker-composeよりコンテナ破棄
    * `$ docker-compose -f ./docker/mac/docker-compose.yml down -v`

## リクエストサンプル

[sample.md](./sample.md)