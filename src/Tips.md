# Tips

## DB関連

### SQLファイルについて

クラス直下に下記のSQLファイルが存在した場合、アプリケーション起動時に読み込む

- schema-(platform).sql
- schema.sql
- data-(platform).sql
- data.sql

platform は起動時に指定することが出来る

```
--spring.datasource.platform=${platform}
```

SQLファイル内で日本語を利用する場合の設定は下記となる

```
spring.datasource.sql-script-encoding=UTF-8
```

起動時に読み込みたくない場合

```
spring.datasource.initialize=false
```

### トランザクション制御について

`@Transactional` は実行時例外が発生した場合はロールバックされるが、 ***チェック例外*** の場合は ***ロールバックされない*** 。


### JPAについて

スキーマ生成したくない場合

```
spring.jpa.hibernate.ddl-auto=none
```

nativeQuery 使用時は `Pageable` を使用できない