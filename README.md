# CobEventEx

## 介绍
一个对 Cobblemon 模组进行扩展事件的模组

## 构建
### 克隆项目

`git clone https://github.com/FullIdle/CobEventEx.git CobEventEx`
### 进入项目目录

`cd CobEventEx`
### 构建模组

`./gradlew build`

## 安装
将 `build/libs` 目录下的 `CobEventEx-{version}.jar` 放入客户端中 `mods` 文件夹中

## 依赖
```groovy
repositories {
    maven {
        allowInsecureProtocol = true
        url 'http://server.pokemtd.top:31647/snapshots'
    }
}
dependencies {
    compileOnly 'org.figsq.cobeventex.cobeventex:CobEventEx:1.0-SNAPSHOT'
}
```
