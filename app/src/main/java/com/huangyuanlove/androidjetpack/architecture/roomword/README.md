#### Room简介

原文地址：https://developer.android.google.cn/training/data-storage/room/index.html

Room 持久性库在 SQLite 的基础上提供了一个抽象层，让用户能够在充分利用 SQLite 的强大功能的同时，获享更强健的数据库访问机制。
Room 包含 3 个主要组件：

* 数据库：包含数据库持有者，并作为应用已保留的持久关系型数据的底层连接的主要接入点。

  使用 @Database 注释的类应满足以下条件：
  * 是扩展 RoomDatabase 的抽象类。

  * 在注释中添加与数据库关联的实体列表。

  * 包含具有 0 个参数且返回使用 @Dao 注释的类的抽象方法。

	在运行时，您可以通过调用 Room.databaseBuilder() 或 Room.inMemoryDatabaseBuilder() 获取 Database 的实例。

* Entity：表示数据库中的表。

* DAO：包含用于访问数据库的方法。

#### Room使用

##### 添加依赖

选择合适的版本

```
// Room components
implementation "androidx.room:room-runtime:2.2.3"
annotationProcessor "androidx.room:room-compiler:2.2.3"
androidTestImplementation "androidx.room:room-testing:2.2.3"

// Lifecycle components
implementation "androidx.lifecycle:lifecycle-extensions:2.1.0"
annotationProcessor "androidx.lifecycle:lifecycle-compiler:2.1.0"

// UI
implementation "com.google.android.material:material:1.0.0"

```




